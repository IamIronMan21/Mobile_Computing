package com.example.registerandlogin_haquee1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private boolean isImageBig = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.imageView);

        // Automatically resize the image after a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resizeImage();
                navigateToMainActivity();
            }
        }, 3000);
    }

    private void resizeImage() {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();

        // Set fixed dimensions for the image
        params.width = 200; // width in pixels
        params.height = 250; // height in pixels

        imageView.setLayoutParams(params);
    }
    private void navigateToMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
