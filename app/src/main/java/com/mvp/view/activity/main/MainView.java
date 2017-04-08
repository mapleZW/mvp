package com.mvp.view.activity.main;

import com.mvp.bean.UserBean;
import com.mvp.view.base.BaseView;

/**
 * Created by maple on 2017/4/8 0008.
 */

public interface MainView extends BaseView {
    void onInitFinished(UserBean userBean);

    void onRefreshFinished(UserBean userBean);

    void onLoadMoreFinished(UserBean userBean);

}
