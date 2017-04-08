package com.mvp.model.user;

import com.mvp.bean.UserBean;
import com.mvp.utils.LogUtils;
import com.mvp.utils.NetWorkUtils;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by maple on 2017/4/8 0008.
 */

public class UserIndicatorImpl  implements UserIndicator{
    @Override
    public void getInit(Map<String, Object> map,final onFinishedListener listener) {
        NetWorkUtils.getApi().getUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.d("onResponse", e.toString());
                        listener.onError("网络出错，稍后再试");

                    }

                    @Override
                    public void onNext(UserBean userBean) {

                        listener.onFinished(userBean);


                    }
                });
    }

    @Override
    public void getRefresh(Map<String, Object> map,final onFinishedListener listener) {
        NetWorkUtils.getApi().getUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.d("onResponse", e.toString());
                        listener.onError("网络出错，稍后再试");

                    }

                    @Override
                    public void onNext(UserBean userBean) {

                        listener.onRefreshFinished(userBean);


                    }
                });
    }

    @Override
    public void getLoadMore(Map<String, Object> map,final onFinishedListener listener) {
        NetWorkUtils.getApi().getUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.d("onResponse", e.toString());
                        listener.onError("网络出错，稍后再试");

                    }

                    @Override
                    public void onNext(UserBean userBean) {

                        listener.onLoadMoreFinished(userBean);


                    }
                });
    }
}
