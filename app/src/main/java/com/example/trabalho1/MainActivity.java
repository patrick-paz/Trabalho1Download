package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button downloadButton;
    private EditText edtUrl;
    private ImageView image;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadButton = findViewById(R.id.downloadButton);
        edtUrl = findViewById(R.id.edtUrl);
        image = findViewById(R.id.image);
        progressBar = findViewById(R.id.progressBar);

        downloadButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Download download = new Download(downloadButton, image, progressBar);
        download.execute(edtUrl.getText().toString());

    }
}