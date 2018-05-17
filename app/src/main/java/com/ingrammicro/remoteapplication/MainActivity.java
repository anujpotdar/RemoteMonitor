package com.ingrammicro.remoteapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ingrammicro.remoteapplication.databinding.ActivityMainBinding;
import com.ingrammicro.remotemonitor.CollectData;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CollectData collectData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(binding.getRoot());

        collectData = new CollectData(this);

        collectData.requestStoragePermission();

        binding.takescreenshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collectData.takeScreenshot();
                collectData.getDeviceInfo();
            }
        });
    }

}
