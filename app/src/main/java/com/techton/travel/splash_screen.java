package com.techton.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class splash_screen extends Activity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Checker", "SplashCheck");
        setContentView(R.layout.splash_background);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showMain();
            }
    },2000);
    }

    protected void showMain() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
       // overridePendingTransition(0, 0);
        finish();
       // overridePendingTransition(0, R.anim.fade_out);
    }
}
