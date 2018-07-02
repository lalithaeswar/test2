package com.mythoughts.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mythoughts.R;
import com.mythoughts.helper.InputValidation;
import com.mythoughts.model1.User;
import com.mythoughts.sql1.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;
    private DatabaseHelper databaseHelper;
    private User user;
    private InputValidation inputValidation;
    private EditText username, password;
    private Button signin;
    private TextView forgotpassword;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Initialized method
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin_button);
        forgotpassword = findViewById(R.id.forgot_password);
        scrollView=findViewById(R.id.scrollview_login);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    private void initListeners() {
        signin.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin_button: {
                verifyFromSQLite();
            }
            case R.id.forgot_password: {

            }
        }
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(username,  getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(username,  getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(password,  getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(username.getText().toString().trim()
                , password.getText().toString().trim())) {

            setData();
            emptyInputEditText();

        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(scrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        username.setText(null);
        password.setText(null);
    }
    public void setData()
    {
        Toast.makeText(activity, "success", Toast.LENGTH_LONG).show();
    }
}
