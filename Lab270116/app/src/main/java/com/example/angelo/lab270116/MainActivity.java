package com.example.angelo.lab270116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView name,activity,activity2;
    private Button b,b2;
    private EditText et;
    private String[] activityarr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.name = (TextView)findViewById(R.id.activity);
        this.activity = (TextView)findViewById(R.id.insertactivity);
        this.activity2 = (TextView)findViewById(R.id.insertactivity2);
        this.b = (Button)findViewById(R.id.button1);
        this.b2 = (Button)findViewById(R.id.button2);
        this.et = (EditText)findViewById(R.id.edit);
        this.name.setText("Activity 1");
        this.activity.setText("Activity 2:");
        this.activity2.setText("Activity 3:");
        this.b.setText("Activity2");
        this.b2.setText("Activity3");
        this.activityarr = new String[3];
        restore();
    }

        public void activity(View v){
            this.activityarr[0] = this.et.getText().toString();
            if(((Button)v).getText().toString().equals(b.getText().toString())) {
                Intent activity2 = new Intent(this, Activity2.class);
                activity2.putExtra("strings",this.activityarr);
                startActivity(activity2);
            }else {
                Intent activity3 = new Intent(this, Activity3.class);
                activity3.putExtra("strings", this.activityarr);
                startActivity(activity3);
            }
        }

    private void restore(){
        Intent i = getIntent();
        String[] tmp = i.getStringArrayExtra("strings");
        if (tmp != null) {
            this.activityarr = tmp;
            this.activity.setText("Activity 2: " + this.activityarr[1]);
            this.activity2.setText("Activity 3: " + this.activityarr[2]);
        }
    }




}
