package com.example.app_new;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.Holobtn);
        button.setOnClickListener(v -> {
            Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
            Uri intentUri =
                    Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                            .appendQueryParameter("file", "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/ABeautifulGame/glTF/ABeautifulGame.gltf")
                            .appendQueryParameter("mode", "3d_only")
                            .build();
            sceneViewerIntent.setData(intentUri);
            sceneViewerIntent.setPackage("com.google.ar.core");
            startActivity(sceneViewerIntent);
        });
    }
}