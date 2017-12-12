package com.nebras.aidi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mahmoudkamal on 8/27/17.
 */

public class SplashActivity extends AppCompatActivity {

   // private SharedData sharedData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
     //   sharedData = new SharedData(this);

        new Handler().postDelayed(new Runnable() {
            // Using handler with postDelayed called runnable run method
            @Override
            public void run() {


               // if(!sharedData.getUserLoginStatus()){
                    startActivity(new Intent(SplashActivity.this,IntroActivity.class));

              //  }else {
               //     startActivity(new Intent(Splash.this,HomeActivity.class));


              //  }


            }
        }, 2 * 1000); // wait for 5 seconds



    }


    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
