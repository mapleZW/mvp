package com.mvp.model.user;

import com.mvp.bean.UserBean;

import java.util.Map;

/**
 * Created by maple on 2017/4/8 0008.
 */

public interface UserIndicator {
    interface onFinishedListener {

        void onFinished(UserBean userBean);

        void onRefreshFinished(UserBean userBean);

        void onLoadMoreFinished(UserBean userBean);


        void onError(String msg);
    }

    void getInit(Map<String, Object> map,final onFinishedListener listener);

    void getRefresh(Map<String, Object> map,final onFinishedListener listener);

    void getLoadMore(Map<String, Object> map,final onFinishedListener listener);
}
