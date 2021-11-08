package com.example.reach.flames;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class friends extends Activity {
    TextView text;
    Typeface myfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        text= findViewById(R.id.textView4);
        myfont =Typeface.createFromAsset(this.getAssets(),"fonts/TWINPINE.ttf");
        text.setTypeface(myfont);


    }

}
