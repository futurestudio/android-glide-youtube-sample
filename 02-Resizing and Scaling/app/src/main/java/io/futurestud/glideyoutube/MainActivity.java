package io.futurestud.glideyoutube;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST = 100;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private Context context = MainActivity.this;
    private String stockPhotoUrl = "https://cdn.pixabay.com/photo/2017/07/31/11/14/poppyseed-2557339_1280.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.standard_list_imageview1);
        imageView2 = (ImageView) findViewById(R.id.standard_list_imageview2);
        imageView3 = (ImageView) findViewById(R.id.standard_list_imageview3);
        imageView4 = (ImageView) findViewById(R.id.standard_list_imageview4);

        requestStoragePermission();

        //loadImageByInternetUrl();
        //loadImageByResourceId();
        //loadImageByFile();
        //loadImageByUri();

        loadImageOriginal();
        loadImageCenterCrop();
        loadImageFitCenter();
        loadImageWithResize();
    }

    // Second Video: Glide - Image Resizing & Scaling
    private void loadImageOriginal() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl)
                .into(imageView1);
    }

    private void loadImageCenterCrop() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl)
                .centerCrop()
                .into(imageView2);
    }

    private void loadImageFitCenter() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl)
                .fitCenter()
                .into(imageView3);
    }

    private void loadImageWithResize() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl)
                .override(400, 50)
                .into(imageView4);
    }

    // First Video: Glide - Getting Started
    private void loadImageByInternetUrl() {
        // the url could be any image URL, which is accessible with a normal HTTP GET request
        String internetUrl = "http://i.imgur.com/DvpvklR.png";

        Glide
                .with(context)
                .load(internetUrl)
                .into(imageView1);
    }

    private void loadImageByResourceId() {
        int resourceId = R.mipmap.ic_launcher;

        Glide
                .with(context)
                .load(resourceId)
                .into(imageView2);
    }

    private void loadImageByFile() {
        // this file probably does not exist on your device. However, you can use any file path, which points to an image file
        File file = new File("/storage/emulated/0/Download/futurestudio-logo.png");

        Glide
                .with(context)
                .load(file)
                .into(imageView3);
    }

    private void loadImageByUri() {
        // this could be any Uri. for demonstration purposes we're just creating an Uri pointing to a launcher icon
        Uri uri = Uri.parse("android.resource://io.futurestud.glideyoutube/" + R.mipmap.ic_launcher_round);

        Glide
                .with(context)
                .load(uri)
                .into(imageView4);
    }

    // Preparation
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // file-related task you need to do.

                }
                else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }}
