package com.mvp.utils.api;

import com.mvp.bean.UserBean;
import com.mvp.constants.Urls;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface Api {

    /**
     * 得到用户信息
     *
     * @param cempCode
     * @return
     */
    @POST(Urls.GET_JSON)
    Observable<UserBean> getUser(@QueryMap Map<String, Object> map);
}