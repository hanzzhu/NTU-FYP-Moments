package com.fyp.moments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.fyp.moments.base.BaseActivity;

public class SplashScreenActivity extends BaseActivity {

    private static final int READ_WRITE_STORAGE_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();

        if (ContextCompat.checkSelfPermission(
                SplashScreenActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }else{
            try {
                Thread.sleep(1000);
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case READ_WRITE_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    try {
                        Thread.sleep(1000);
                        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                } else {
                    closeNow();
                }
            }
        }
    }

}


