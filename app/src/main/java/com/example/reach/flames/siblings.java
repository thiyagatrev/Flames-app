package com.example.reach.flames;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class siblings extends Activity {
    TextView textview;
    Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siblings);
        textview= findViewById(R.id.textView8);
        font = Typeface.createFromAsset(this.getAssets(),"fonts/TWINPINE.ttf");
        textview.setTypeface(font);
    }

}
