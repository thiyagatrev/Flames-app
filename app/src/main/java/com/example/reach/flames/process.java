package com.example.reach.flames;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class process extends Activity {
    String nameone,nametwo,name1,name2;
    EditText editText,editText2;
    Button flames;
    Typeface font,font1;
    TextView text,text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);


        editText=findViewById(R.id.editText);
        editText2= (findViewById(R.id.editText2));
        flames=  findViewById(R.id.flames);
        text=  findViewById(R.id.textView);
        text1= findViewById(R.id.textView2) ;
        font =Typeface.createFromAsset(this.getAssets(),"fonts/BLUNT.TTF");
        font1 =Typeface.createFromAsset(this.getAssets(),"fonts/TWINPINE.ttf");

        text.setTypeface(font1);
        text1.setTypeface(font1);
        editText.setTypeface(font);
        editText2.setTypeface(font);
        flames.setTypeface(font1);


        flames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*saving the names */
                nameone = editText.getText().toString();
                nametwo=editText2.getText().toString();
                /*converting to char array*/
                char[] name1char=nameone.toCharArray();
                char[] name2char=nametwo.toCharArray();

                /*finding the length*/

                int a= nameone.length();
                int b=nametwo.length();
                int combinedNamesLength=a+b;

                /*eliminating the common letters*/

                for(int i=0;i<a;i++)
                {
                    for(int j=0;j<b;j++)
                    {
                        if(name1char  [i] == name2char[j])
                        {
                            name1char[i]=' ';
                            name2char[j]=' ';
                            combinedNamesLength= combinedNamesLength-2;
                            break;
                        }
                    }
                }



                String flames = "flames";
                StringBuilder flamesString = new StringBuilder(flames);
                char flameResult = 0;

                while(flamesString.length()!=1)
                {
                    int y = combinedNamesLength%flamesString.length();
                    String temp;

                    if(y!=0)
                    {
                        temp = flamesString.substring(y) + flamesString.substring(0, y-1);
                        // taking substring (counting purpose)
                    }
                    else
                    {
                        temp = flamesString.substring(0, flamesString.length()-1); // taking substring (counting purpose)

                    }
                    flamesString = new StringBuilder(temp);
                    flameResult = flamesString.charAt(0);

                }



                    /* results*/
                    Intent i;
                    switch(flameResult)
                    {
                        case 'f':
                            i = new Intent(process.this, friends.class);
                            startActivity(i);
                            break;
                        case 'l':
                            i = new Intent(process.this, lovers.class);
                            startActivity(i);
                            break;
                        case 'a':
                            i = new Intent(process.this, affection.class);
                            startActivity(i);
                            break;
                        case 'm':
                            i = new Intent(process.this, marriage.class);
                            startActivity(i);
                            break;
                        case 'e':
                            i = new Intent(process.this, enemies.class);
                            startActivity(i);
                            break;
                        case 's':
                            i= new Intent(process.this, siblings.class);
                            startActivity(i);
                            break;
                        default:
                            break;

                    }

            }
        });












    }

}
