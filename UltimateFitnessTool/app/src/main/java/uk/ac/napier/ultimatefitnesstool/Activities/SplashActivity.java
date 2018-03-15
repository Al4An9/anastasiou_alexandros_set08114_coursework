package uk.ac.napier.ultimatefitnesstool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import uk.ac.napier.ultimatefitnesstool.R;

/**
 * Created by alex4 on 15/03/2018.
 */

public class SplashActivity  extends AppCompatActivity{
    private static int SPLASH_TIME_OUT= 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
