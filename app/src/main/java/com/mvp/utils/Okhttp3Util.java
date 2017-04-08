package com.mvp.utils;


import com.mvp.application.BaseApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class Okhttp3Util {

    private static OkHttpClient mOkHttpClient;

    //设置缓存目录
    //private static File cacheDirectory = new File(BaseApplication.getInstance().getApplicationContext().getCacheDir().getAbsolutePath(), "com.mvp");
    //设置缓存 10M
    //private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);

    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient() {

        if (null == mOkHttpClient) {

            mOkHttpClient = new OkHttpClient.Builder()
                    //日志拦截器
                  //  .addInterceptor(loggingInterceptor)
                    //添加拦截器
//                    .addInterceptor(new TokenInterceptor())
                    //.addNetworkInterceptor(new TokenInterceptor())
//                    .addInterceptor(interceptor)
                    //设置请求读写的超时时间
                    .connectTimeout(3, TimeUnit.SECONDS)
                    .writeTimeout(3, TimeUnit.SECONDS)
                    .readTimeout(3, TimeUnit.SECONDS)
                    //添加缓存
                    //.cache(cache)
                    //失败重连
                    .retryOnConnectionFailure(true)
                    .build();
        }

        return mOkHttpClient;
    }

    static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtils.isNetworkConnected(BaseApplication.getInstance())) {
                LogUtils.d("Log", "no network");
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetUtils.isNetworkConnected(BaseApplication.getInstance())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 14; // tolerate 2-weeks stale
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    /**
     * 日志拦截器
     */
    static Interceptor loggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            LogUtils.d("Log", "日志拦截：" + String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            LogUtils.d("Log", "日志拦截：" + String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    };
}
