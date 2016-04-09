package com.example.angelo.lab140415;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private LinearLayout back;
    private static final String BACKGROUND = "BACKGROUND";
    private static final String RESULT = "RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.back = (LinearLayout) findViewById(R.id.back);
        this.result = (TextView)findViewById(R.id.text);
        if(savedInstanceState != null){
            this.result.setText(savedInstanceState.getString(RESULT));
            this.back.setBackgroundColor(savedInstanceState.getInt(BACKGROUND));
        }
    }

    public void onSaveInstanceState(android.os.Bundle	savedInstanceState)	{
        savedInstanceState.putString(RESULT, this.result.getText().toString());
        savedInstanceState.putInt(BACKGROUND, ((ColorDrawable) this.back.getBackground()).getColor());
        super.onSaveInstanceState(savedInstanceState);
    }

    public  void operation(View v) {
        String[] name = getResources().getResourceName(v.getId()).split("/");
        if(name[1].equals("uno"))
            this.result.setText("1");
        else if (!(result.getText().toString().isEmpty())){
            if (name[1].equals("perdue"))
                mul();
            else if (name[1].equals("divisodue"))
                div();
            else
                log();
        } else
            return;

    }


    private void mul(){
            this.result.setText(Double.toString(Double.parseDouble(result.getText().toString()) * 2));
    }

    private void div(){
            this.result.setText(Double.toString(Double.parseDouble(result.getText().toString())/2));
    }

    private void log() {
            this.result.setText(Double.toString(Math.log(Math.log(Double.parseDouble(result.getText()
                .toString())))));
    }

    public void color(View v){
        String[] name = getResources().getResourceName(v.getId()).split("/");
        if(name[1].equals("verde"))
            this.back.setBackgroundResource(R.color.green);
        else if (name[1].equals("rosso"))
            this.back.setBackgroundResource(R.color.red);
        else if (name[1].equals("bianco"))
            this.back.setBackgroundResource(R.color.white);
        else
            this.back.setBackgroundResource(R.color.blue);
    }
}
