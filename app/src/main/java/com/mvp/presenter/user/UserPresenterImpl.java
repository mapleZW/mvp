package com.mvp.presenter.user;

import com.mvp.bean.UserBean;
import com.mvp.model.user.UserIndicator;
import com.mvp.model.user.UserIndicatorImpl;
import com.mvp.view.activity.main.MainView;

import java.util.Map;

/**
 * Created by maple on 2017/4/8 0008.
 */

public class UserPresenterImpl implements UserPresenter,UserIndicatorImpl.onFinishedListener {

    private MainView mView;
    private UserIndicator mIndicator;

    public UserPresenterImpl(MainView mView) {
        this.mView = mView;
        mIndicator = new UserIndicatorImpl();
    }


    @Override
    public void getInit(Map<String, Object> map) {
        if (null != mView) {
            mView.showDialog("加载中");
            mIndicator.getInit(map, this);
        }
    }

    @Override
    public void getRefresh(Map<String, Object> map)  {
        if (null != mView) {
            mView.showDialog("加载中");
            mIndicator.getRefresh(map, this);
        }
    }

    @Override
    public void getLoad(Map<String, Object> map) {
        if (null != mView) {
            mView.showDialog("加载中");
            mIndicator.getLoadMore(map, this);
        }
    }

    @Override
    public void onFinished(UserBean userBean) {
        if (null != mView) {
            mView.hideDialog();
            mView.onInitFinished(userBean);
        }
    }

    @Override
    public void onRefreshFinished(UserBean userBean) {
        if (null != mView) {
            mView.hideDialog();
            mView.onRefreshFinished(userBean);
        }
    }

    @Override
    public void onLoadMoreFinished(UserBean userBean) {
        if (null != mView) {
            mView.hideDialog();
            mView.onLoadMoreFinished(userBean);
        }
    }


    @Override
    public void onError(String msg) {
        if (null != mView) {
            mView.hideDialog();
            mView.showError(msg);
        }
    }
}
