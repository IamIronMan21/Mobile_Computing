package com.example.registerandlogin_haquee1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    private EditText emailLi, passwordLi;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLi = findViewById(R.id.emailEtv);
        passwordLi = findViewById(R.id.passwordEtv);
        loginButton = findViewById(R.id.sendLoginBtn);

        setUpLogin();
    }

    private void setUpLogin() {
        // Set up login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values from EditTexts
                String email = emailLi.getText().toString();
                String password = passwordLi.getText().toString();

                // Perform login validation
                boolean isValid = validateLogin(email, password);

                if (isValid) {
                    // If login is successful, user can navigate to another activity or perform any other action
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();

                    // Navigate to another activity (for now MainActivity)
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateLogin(String email, String password) {
        // I'm checking if both email and password are non-empty
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }
}
