package sampleproject.com.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button bn=findViewById(R.id.signin_btn);
        bn.setOnClickListener(new View.OnClickListener() {

public void onClick(View v){

        Intent intent = new Intent(LoginActivity.this, ProfilePage.class);
        startActivity(intent);
        }
        });


    }
}
