package com.example.registerandlogin_haquee1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

public class RegistrationActivity extends AppCompatActivity {

    private EditText firstNameEtv, lastNameEtv, birthdayEtv, emailEtv, passwordEtv;
    private Button sendRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstNameEtv = findViewById(R.id.firstNameEtv);
        lastNameEtv = findViewById(R.id.lastNameEtv);
        birthdayEtv = findViewById(R.id.birthdayEtv);
        emailEtv = findViewById(R.id.emailEtv);
        passwordEtv = findViewById(R.id.passwordEtv);
        sendRegisterBtn = findViewById(R.id.btn_register);

        setUpRegistration();
    }

    private void setUpRegistration() {
        sendRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = firstNameEtv.getText().toString();
                String lastname = lastNameEtv.getText().toString();
                String birthday = birthdayEtv.getText().toString();
                String email = emailEtv.getText().toString();
                String password = passwordEtv.getText().toString();

                boolean verify = validation(firstname, lastname, birthday, email, password);

                if (verify) {
                    Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();

                    // Navigate back to MainActivity
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity
                } else {
                    Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validation(String firstname, String lastname, String birthday, String email, String password) {
        // Check if all fields are filled and meet specific criteria

        if (firstname.isEmpty() || lastname.isEmpty() || birthday.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "All fields are required.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (firstname.length() < 3 || firstname.length() > 30) {
            Toast.makeText(getApplicationContext(), "First name must be between 3 and 30 characters.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (lastname.length() == 0) {
            Toast.makeText(getApplicationContext(), "Last name.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (birthday.length() == 0 || birthday.length() <= 7) {
            Toast.makeText(getApplicationContext(), "Input birthday.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(getApplicationContext(), "Enter email address.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Input Password.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
