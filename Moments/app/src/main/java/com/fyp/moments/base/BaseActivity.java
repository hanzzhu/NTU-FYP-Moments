package com.fyp.moments.base;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;

import com.fyp.moments.SplashScreenActivity;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class BaseActivity extends AppCompatActivity {

    public static final int READ_WRITE_STORAGE_CODE = 100;
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int GALLERY_PERMISSION_CODE = 102;
    private ProgressDialog mProgressDialog;


    public boolean requestPermission(String permission) {
        boolean isGranted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        if (!isGranted) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, READ_WRITE_STORAGE_CODE);
            ActivityCompat.requestPermissions(this, new String[]{permission}, CAMERA_PERMISSION_CODE);
            ActivityCompat.requestPermissions(this, new String[]{permission}, GALLERY_PERMISSION_CODE);
        }
        return isGranted;
    }

    public void makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected void showLoading(@NonNull String message) {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    protected void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected void showSnackbar(@NonNull String message) {
        View view = findViewById(android.R.id.content);
        if (view != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    protected void closeNow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        } else {
            finish();
        }
    }
}
