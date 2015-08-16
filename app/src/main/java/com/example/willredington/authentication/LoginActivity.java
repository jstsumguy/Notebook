package com.example.willredington.authentication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.willredington.db.UserDataSource;
import com.example.willredington.notebook.MainActivity;
import com.example.willredington.notebook.R;

/**
 * Created by willredington on 8/15/15.
 */
public class LoginActivity extends Activity {

    private EditText email;
    private EditText password;
    private Button login;
    private static UserDataSource uds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        uds = new UserDataSource(this);

        email = (EditText)findViewById(R.id.usernametxt);
        password = (EditText) findViewById(R.id.passwordtxt);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uds.validate(password.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Successfully logged in!", Toast.LENGTH_LONG);
                    finishActivity(MainActivity.LOGIN_REQUEST);
                }
            }
        });
    }
}
