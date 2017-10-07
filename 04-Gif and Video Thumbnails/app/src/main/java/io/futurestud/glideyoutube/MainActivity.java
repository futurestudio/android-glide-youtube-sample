package io.futurestud.glideyoutube;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

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

        loadImageGif();
        loadImageLocalVideoThumbnail();

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    100);
        }
    }

    private void loadImageGif() {
        GlideApp
                .with(context)
                .asBitmap()
                .load(R.drawable.funny)
                .error(R.drawable.false_icon)
                .into(imageView1);
    }

    private void loadImageLocalVideoThumbnail() {
        GlideApp
                .with(context)
                .load("/storage/emulated/0/Download/funny_video.mp4")
                .error(R.drawable.false_icon)
                .into(imageView2);
    }

}
