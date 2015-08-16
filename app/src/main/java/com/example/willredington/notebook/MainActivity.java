package com.example.willredington.notebook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import com.example.willredington.authentication.LoginActivity;
import com.example.willredington.authentication.User;

public class MainActivity extends AppCompatActivity {

    public static int LOGIN_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!User.isLoggedIn())
        {
            Intent i = new Intent(this, LoginActivity.class);
            this.startActivityForResult(i, LOGIN_REQUEST);
        }

        /* Get all notebooks */

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == LOGIN_REQUEST && requestCode == Activity.RESULT_OK)
        {
            // Login finished
        }
    }
}
