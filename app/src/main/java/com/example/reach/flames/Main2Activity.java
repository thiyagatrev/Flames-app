package com.example.reach.flames;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity {
    Button proceed;
    TextView text;
    Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        proceed = findViewById(R.id.button);
        text= findViewById(R.id.textView3);
        font =Typeface.createFromAsset(this.getAssets(),"fonts/BLUNT.TTF");
        text.setTypeface(font);
        proceed.setTypeface(font);

        proceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Main2Activity.this,
                        process.class);
                startActivity(myIntent);
            }
        });

    }


}
