package com.yuncheng.china.Fanju.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.china.yuncheng.fanju.R;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by agonyice on 14-9-9.
 */
public class LoginActivity extends Activity {
    /*用户名*/
    @ViewInject(R.id.loginNameEditText)
    private EditText loginNameEditText;
    /*密码*/
    @ViewInject(R.id.passwordEditText)
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

    }

}
