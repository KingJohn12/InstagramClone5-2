package com.example.instagramclone5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText UserName;
    private EditText Password;
    private Button SignInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser() != null)
        {
            goMainActivity();
        }

        UserName = findViewById(R.id.UserName);
        Password = findViewById(R.id.Password);
        SignInButton = findViewById(R.id.SignInButton);


        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = UserName.getText().toString();
                String password = Password.getText().toString();
                loginUser(username, password);
            }


        });
    }


        private void loginUser(String username, String password) {
            Log.i(TAG, "Attempted to login user" + username);
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(e!= null)
                    {
                        Log.e(TAG, "Issue with login",e);
                        Toast.makeText(LoginActivity.this, "Issue with Login", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    goMainActivity();
                    Toast.makeText(LoginActivity.this, "Success!!!",Toast.LENGTH_SHORT).show();
                }
            });

    }

    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}