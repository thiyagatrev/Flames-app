package com.example.reach.flames;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class marriage extends Activity {
    TextView text;
    Typeface myfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage);
        text= findViewById(R.id.textView7);
        myfont =Typeface.createFromAsset(this.getAssets(),"fonts/BLUNT.TTF");
        text.setTypeface(myfont);
    }

}
