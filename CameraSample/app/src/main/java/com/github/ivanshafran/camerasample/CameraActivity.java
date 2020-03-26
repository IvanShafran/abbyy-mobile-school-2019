package com.github.ivanshafran.camerasample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageCapture;
import androidx.camera.view.CameraView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

public class CameraActivity extends AppCompatActivity implements ImageCapture.OnImageSavedListener {

    private static final int CAMERA_REQUEST_CODE = 0;

    private CameraView cameraView;
    private View takePictureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            startCamera();
        } else {
            requestPermission();
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[] {Manifest.permission.CAMERA},
			CAMERA_REQUEST_CODE
        );
    }

    @Override
    public void onRequestPermissionsResult(
            final int requestCode,
            @NonNull final String[] permissions,
            @NonNull final int[] grantResults
    ) {
        if (requestCode == CAMERA_REQUEST_CODE ) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera();
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    Toast.makeText(this, R.string.need_permission, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, R.string.permission_in_settings, Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void startCamera() {
        cameraView = findViewById(R.id.cameraView);
        cameraView.setCaptureMode(CameraView.CaptureMode.IMAGE);
        cameraView.bindToLifecycle((LifecycleOwner) this);

        takePictureButton = findViewById(R.id.takePictureButton);
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                cameraView.takePicture(
                        generatePictureFile(),
                        AsyncTask.SERIAL_EXECUTOR,
                        CameraActivity.this
                );
            }
        });
    }

    @Override
    public void onImageSaved(@NonNull final File file) {
		int t = 0;
    }

    @Override
    public void onError(
            @NonNull final ImageCapture.ImageCaptureError imageCaptureError,
            @NonNull final String message,
            @Nullable final Throwable cause) {
        finish();
    }

    private File generatePictureFile() {
        return new File(getFilesDir(), UUID.randomUUID().toString());
    }
}
