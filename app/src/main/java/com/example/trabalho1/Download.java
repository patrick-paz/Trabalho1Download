package com.example.trabalho1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Download extends AsyncTask<String, Void, Bitmap> {

    ImageButton downloadBtn;
    ImageView image;
    ProgressBar progress;

    public Download(ImageButton downloadBtn, ImageView image, ProgressBar progress) {
        this.downloadBtn = downloadBtn;
        this.image = image;
        this.progress = progress;
    }

    @Override
    protected void onPreExecute() {
        downloadBtn.setEnabled(false);
        image.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        progress.setVisibility(View.INVISIBLE);
        image.setImageBitmap(bitmap);
        image.setVisibility(View.VISIBLE);
        downloadBtn.setEnabled(true);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;

        try {
            InputStream in = new URL(url).openStream();

            bitmap = BitmapFactory.decodeStream(in);

            in.close();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        return bitmap;
    }
}
