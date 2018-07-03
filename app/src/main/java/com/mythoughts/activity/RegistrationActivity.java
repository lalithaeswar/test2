package com.mythoughts.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mythoughts.R;
import com.mythoughts.helper.InputValidation;
import com.mythoughts.model1.User;
import com.mythoughts.sql1.DatabaseHelper;


public class RegistrationActivity extends AppCompatActivity implements  View.OnClickListener  {
    //intialize all objects
    private final AppCompatActivity activity = RegistrationActivity.this;
    private  EditText edtFullName, edtUser, edtPass, edtConfPass, edtEmail,mobile_Num;
    private CheckBox checkbox_Terms;
    private  TextView logintext;
    private Button registerbutton;
    private DatabaseHelper databaseHelper;
    private User user;
    private InputValidation inputValidation;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
        initObjects();
        initListeners();
    }
    public void initViews()
    {
        edtFullName=findViewById(R.id.fullname_id);
        edtUser=findViewById(R.id.username_id);
        edtPass=findViewById(R.id.password_id);
        edtConfPass=findViewById(R.id.conform_password_id);
        edtEmail=findViewById(R.id.email_id);
        checkbox_Terms=findViewById(R.id.checkbox_terms);
        mobile_Num= findViewById(R.id.mobile_id);
        registerbutton=findViewById(R.id.subscribe_btn);
        logintext=findViewById(R.id.login);
        scrollView=findViewById(R.id.scrollview_register);


    }
    private void initListeners() {
        registerbutton .setOnClickListener(this);
        logintext.setOnClickListener(this);

    }
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation=new InputValidation(activity);
        user = new User();

    }

    @Override
    public void onClick(View  v)
    {
        switch (v.getId()) {
            case R.id.subscribe_btn: {
                postDataToSQLite();
                break;
            }
            case R.id.login: {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(edtFullName, "enter fullname")) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(edtUser, "enter username")) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(mobile_Num, "enter mobilenumber")) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(edtEmail, "enter emailId")) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(edtEmail, "wrong emailid")) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(edtPass,  "enter password")) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(edtPass, edtConfPass, "password is not matched")) {
            return;
        }

        if (!databaseHelper.checkUser(edtEmail.getText().toString().trim())) {

            user.setName(edtUser.getText().toString().trim());
            user.setEmail(edtEmail.getText().toString().trim());
            user.setPassword(edtPass.getText().toString().trim());
            user.setPnumber(mobile_Num.getText().toString());
            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
           // Snackbar.make(scrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            alertMessage();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(scrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        edtFullName.setText(null);
        edtEmail.setText(null);
        edtPass.setText(null);
        edtConfPass.setText(null);
        edtUser.setText(null);
        mobile_Num.setText(null);
    }
   /* public void validaation()
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(edtFullName.getText().toString().length()==0){
            edtFullName.setError("First name not entered");
            edtFullName.requestFocus();
        }

        else  if(edtUser.getText().toString().length()==0){
            edtUser.setError("Username is Required");
            edtUser.requestFocus();
        }
        else  if(mobile_Num.getText().toString().length()==0){
            edtUser.setError("mobile is Required");
            edtUser.requestFocus();
        }
        else if(!edtEmail.getText().toString().matches(emailPattern))
        {
            edtEmail.setError("incorrect emailId");
            edtEmail.requestFocus();
        }
        else if(edtPass.getText().toString().length()==0){
            edtPass.setError("Password not entered");
            edtPass.requestFocus();
        }
        else  if(edtConfPass.getText().toString().length()==0){
            edtConfPass.setError("Please confirm password");
            edtConfPass.requestFocus();
        }
        else  if(!edtPass.getText().toString().equals(edtConfPass.getText().toString())){
            edtConfPass.setError("Password Not matched");
            edtConfPass.requestFocus();
        }
        else  if(edtPass.getText().toString().length()<8) {
            edtPass.setError("Password should be atleast of 8 charactors");
            edtPass.requestFocus();

        }
        else if(!checkbox_Terms.isChecked())
        {
            checkbox_Terms.setError("must to accept terms and conditions");
            checkbox_Terms.requestFocus();

        }
        else {
            alertMessage();
        }

    }*/
    public void alertMessage()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
        builder.setTitle("Successfully Registerd");
        builder.setMessage("Thank U!");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent accountsIntent = new Intent(activity, UsersListActivity.class);
                        startActivity(accountsIntent);
                        emptyInputEditText();

                    }
                });
        builder.show();

    }

}

