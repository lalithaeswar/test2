package sampleproject.com.task1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sampleproject.com.task1.R;


public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signin_btn)
        {
            Intent intent = new Intent(LoginActivity.this,navigation.class);
            startActivity(intent);
        }
    }
}
