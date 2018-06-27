package com.mythoughts;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener {
    private EditText username, password;
    private Button signin;
    private TextView forgotpassword;
    String name="", password1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Initialized method
        initViews();
    }

    private void initViews() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin_button);
        forgotpassword = (TextView) findViewById(R.id.forgot_password);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signin_button) {
            ValidateCreditinals();
        }
    }

    public void ValidateCreditinals() {
        name = username.getText().toString();
        Log.d("lalitha", "ValidateCreditinals: "+name);
        password1 = password.getText().toString();
        if (name == null || name.equals(""))
            Toast.makeText(getApplicationContext(), "wrong username",
                    Toast.LENGTH_LONG).show();
        else if (password1 == "" || password1.length()<6)
            Toast.makeText(getApplicationContext(), "wrong password",
                    Toast.LENGTH_LONG).show();
        else Toast.makeText(getApplicationContext(), "username:" + name +"\n"+ "password" + password1,
                    Toast.LENGTH_LONG).show();

    }
}
