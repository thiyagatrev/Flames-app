package com.example.reach.flames;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class lovers extends Activity {
    TextView text;
    Typeface myfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovers);

        text= findViewById(R.id.textView5);
        myfont =Typeface.createFromAsset(this.getAssets(),"fonts/BLUNT.TTF");
        text.setTypeface(myfont);
    }

}
