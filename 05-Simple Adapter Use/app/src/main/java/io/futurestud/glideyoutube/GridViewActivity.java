package io.futurestud.glideyoutube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_gridview);
        GridView gridView = (GridView) findViewById(R.id.usage_example_gridview);

        gridView.setAdapter(
                new SimpleImageListAdapter(
                        GridViewActivity.this,
                        ListViewActivity.eatFoodyImages
                )
        );
    }
}