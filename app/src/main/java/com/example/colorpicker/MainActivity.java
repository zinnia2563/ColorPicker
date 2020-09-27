package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView mimageView;
    TextView mResulttv;
    View mcolorview;
    Bitmap bitmap;
ImageButton mclrbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mimageView = findViewById(R.id.ivID);
        mResulttv = findViewById(R.id.resultTV);
        mcolorview = findViewById(R.id.colorView);
        mclrbtn = findViewById(R.id.clrbtn);

        mimageView.setDrawingCacheEnabled(true);
        mimageView.buildDrawingCache(true);


        mimageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

                    bitmap = mimageView.getDrawingCache();

                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);


                    String hex = "#" + Integer.toHexString(pixel);
                    mcolorview.setBackgroundColor(Color.rgb(r, g, b));
                    mResulttv.setText("RGB: " + r + "," + g + "," + b + " , " + hex);

                }
                return true;
            }
        });

       mclrbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mResulttv.setText("");
               mcolorview.setBackgroundColor(0xFFFFFF);
           }
       });
    }




}