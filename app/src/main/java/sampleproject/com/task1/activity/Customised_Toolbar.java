package sampleproject.com.task1.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import sampleproject.com.task1.R;
import sampleproject.com.task1.helper.InputValidation;
import sampleproject.com.task1.helper.TextValidator;

import static android.content.Intent.EXTRA_TITLE;

public class Customised_Toolbar extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener{
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Context context;
    private EditText firstName,lastName,email,passowrd,re_Password,date_of_birth,country, city,city1;
    private TextView tv_FirstName,tv_LastName,tv_Email,tv_Passowrd,tv_Re_Password,tv_Date_of_birth,tv_Country, tv_City,tv_City1,tv_Gender;
    DatePickerDialog datePickerDialog;
    private InputValidation inputValidation;
    Spinner gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customised__toolbar);
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "image2");
        supportPostponeEnterTransition();
        initViews();
        initEvents();
    }

    private void initViews() {
        //toolbar
        context = getApplicationContext();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //collaspingtoolbar
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "R.drawable.image2");
        supportPostponeEnterTransition();
        //all edittext fields
        firstName=findViewById(R.id.firstname_et);
        lastName=findViewById(R.id.lastname_et);
        email=findViewById(R.id.email_et);
        passowrd=findViewById(R.id.password_et);
        re_Password=findViewById(R.id.re_password_et);
        date_of_birth=findViewById(R.id.birthday_et);
        date_of_birth.setOnClickListener(this);
        country=findViewById(R.id.country_et);
        city=findViewById(R.id.city_et);
        city1=findViewById(R.id.city1_et);
        gender=findViewById(R.id.gender_et);
        //all textfield views
        tv_Gender=findViewById(R.id.gender_tv);
        tv_FirstName=findViewById(R.id.firstname_tv);
        tv_LastName=findViewById(R.id.lastname_tv);
        tv_Email=findViewById(R.id.email_tv);
        tv_Passowrd=findViewById(R.id.password_tv);
        tv_Re_Password=findViewById(R.id.re_password_tv);
        tv_Date_of_birth=findViewById(R.id.birthday_tv);
        tv_Country=findViewById(R.id.country_tv);
        tv_City=findViewById(R.id.city_tv);
        tv_City1=findViewById(R.id.city1_tv);
        inputValidation=new InputValidation(this);

    }
    private void initEvents()
    {
        firstName.setOnFocusChangeListener(this);
        lastName.setOnFocusChangeListener(this);
        email.setOnFocusChangeListener(this);
        passowrd.setOnFocusChangeListener(this);
        re_Password.setOnFocusChangeListener(this);
        date_of_birth.setOnFocusChangeListener(this);
        country.setOnFocusChangeListener(this);
        city.setOnFocusChangeListener(this);
        city1.setOnFocusChangeListener(this);
        gender.setOnFocusChangeListener(this);

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (!hasFocus) {
            switch(v.getId()) {
                case R.id.firstname_et:
                    if (inputValidation.isInputEditTextFilled(firstName)) {
                        if (inputValidation.isInputEditTextName(firstName))
                            tv_FirstName.setVisibility(View.GONE);
                        else tv_FirstName.setText("Invalid name");
                    }
                    break;
                case R.id.lastname_et: if(inputValidation.isInputEditTextFilled(lastName)) {
                    if (inputValidation.isInputEditTextName(lastName))
                       tv_LastName.setVisibility(View.GONE);
                    else tv_LastName.setText("Invalid name");
                }
                    break;
                case R.id.email_et:
                    if (inputValidation.isInputEditTextFilled(email)) {
                        if (inputValidation.isInputEditTextEmail(email))
                            tv_Email.setVisibility(View.GONE);
                        else tv_Email.setText("Invalid email");
                    }
                    break;
                case R.id.password_et:
                    if (inputValidation.isInputEditTextFilled(passowrd)) {
                        if (inputValidation.isInputEditTextPassword(passowrd))
                            tv_Passowrd.setVisibility(View.GONE);
                        else tv_Passowrd.setText("more than 6 characters");
                    }
                    break;
                case R.id.re_password_et:
                    if (inputValidation.isInputEditTextFilled(re_Password)) {
                        if (inputValidation.isInputEditTextMatches(re_Password,passowrd))
                           tv_Re_Password.setVisibility(View.GONE);
                        else tv_Re_Password.setText("InValid Password");
                    }
                   
                    break;
                case R.id.country_et:
                    if (inputValidation.isInputEditTextFilled(country)) {
                        tv_Country.setVisibility(View.GONE);
                    }
                    break;
                case R.id.city1_et:
                    if (inputValidation.isInputEditTextFilled(city1)) {
                        tv_City1.setVisibility(View.GONE);
                    }
                    break;
                case R.id.city_et:
                    if (inputValidation.isInputEditTextFilled(city)) {
                        tv_City.setVisibility(View.GONE);
                    }
                    break;

            }
        }
    }
//  create a textWatcher member


    //to support the toolbar backbutton
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_signup:{}
            case R.id.birthday_et:{
                prepareDatePickerDialog();}
        }
    }
    private void prepareDatePickerDialog() {
        //Get current date
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        //Create datePickerDialog with initial date which is current and decide what happens when a date is selected.
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change birthdayEdittext's text and dismiss dialog.
                date_of_birth.setText(day+"/"+month+"/"+year);
                datePickerDialog.dismiss();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}
