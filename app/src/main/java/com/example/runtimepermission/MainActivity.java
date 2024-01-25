package com.example.runtimepermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] permission={"android.permission.WRITE_EXTERNAL_STORAGE"};
    AppCompatButton btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.permission);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(permission, 80);
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==80)
        {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "DOWNLOAD CODE", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "DOWNLOAD CANCEL", Toast.LENGTH_SHORT).show();
            }
        }
    }
}