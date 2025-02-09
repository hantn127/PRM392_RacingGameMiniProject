package com.example.racinggameminiproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.homepage);
        ImageView backgroundView = findViewById(R.id.backgroundView);


        ObjectAnimator animator = ObjectAnimator.ofFloat(backgroundView, "translationY", -1000f, 0f);
        animator.setDuration(3000);
        animator.setRepeatCount(0);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.start();

        ImageView duckView = findViewById(R.id.duck);


        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                duckView.setVisibility(View.VISIBLE);


                ObjectAnimator duckSwim = ObjectAnimator.ofFloat(duckView, "translationX", 0f, 800f);
                duckSwim.setDuration(4000);
                duckSwim.setRepeatCount(ObjectAnimator.INFINITE);
                duckSwim.setRepeatMode(ObjectAnimator.REVERSE);
                duckSwim.start();
            }
        });


        animator.start();
    }
}