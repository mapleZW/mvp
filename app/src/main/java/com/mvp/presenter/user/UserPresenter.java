package com.mvp.presenter.user;

import java.util.Map;

/**
 * Created by maple on 2017/4/8 0008.
 */

public interface UserPresenter {
    void getInit(Map<String, Object> map);

    void getRefresh(Map<String, Object> map);

    void getLoad(Map<String, Object> map);
}
