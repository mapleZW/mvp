package com.mvp.view.activity.main;

import android.os.Bundle;
import android.widget.TextView;

import com.mvp.R;
import com.mvp.bean.UserBean;
import com.mvp.presenter.user.UserPresenter;
import com.mvp.presenter.user.UserPresenterImpl;
import com.mvp.view.activity.base_activity.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.main_tv)
    TextView textView;
    private SweetAlertDialog dialog;
    private UserPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
       // initView();

    }
    private void initData() {
        mPresenter = new UserPresenterImpl(this);
        Map<String, Object> map = new HashMap<>();
        map.put("cempCode","asdf");
        //map.put("requestContent", "{}");

        mPresenter.getInit(map);

    }

    @Override
    public void showDialog(String msg) {
        dialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        dialog.setTitleText(msg);
        dialog.show();
    }

    @Override
    public void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void showError(String msg) {
        if (null != dialog) {
            dialog.dismiss();
        }
        dialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        dialog.setTitleText(msg);
        dialog.show();

    }

    @Override
    public void onInitFinished(UserBean userBean) {
        if(userBean.getCode()==0)
        {
            textView.setText(userBean.getRequestContent().toString());

        }


    }

    @Override
    public void onRefreshFinished(UserBean userBean) {

    }

    @Override
    public void onLoadMoreFinished(UserBean userBean) {

    }
}
