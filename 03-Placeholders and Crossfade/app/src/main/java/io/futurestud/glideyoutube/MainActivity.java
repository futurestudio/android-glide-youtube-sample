package io.futurestud.glideyoutube;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

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

        loadImageOriginal();
        loadImagePlaceholder();
        //loadImageError();
        //loadImageFallback();
    }

    private void loadImageOriginal() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl)
                .into(imageView1);
    }

    private void loadImagePlaceholder() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl)
                .placeholder(R.drawable.hourglass)
                .error(R.drawable.false_icon)
                .fallback(R.drawable.futurestudio_logo)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .into(imageView2);
    }

    private void loadImageError() {
        GlideApp
                .with(context)
                .load(stockPhotoUrl + " error!")
                .error(R.drawable.false_icon)
                .into(imageView3);
    }

    private void loadImageFallback() {
        GlideApp
                .with(context)
                .load(null)
                .fallback(R.drawable.futurestudio_logo)
                .into(imageView4);
    }
}
