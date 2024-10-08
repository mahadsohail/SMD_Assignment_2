package com.mahad.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mahad.todolist.MainActivity;
import com.mahad.todolist.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logoImage = findViewById(R.id.logoImage);

        // Loading animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_and_scale);
        logoImage.startAnimation(animation);

        // Listener to handle when animation ends
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Navigate to MainActivity when animation ends
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivityForResult(intent, 100);  // Using StartActivityForResult
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            // Handle the result if necessary
        }
    }

}
