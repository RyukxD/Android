package com.example.angelo.lab090216;

import android.graphics.drawable.shapes.Shape;
import android.os.Debug;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private FrameLayout container;
    private Animation animation;
    private MyShape shape;
    private TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.container = (FrameLayout)findViewById(R.id.frame);
        this.tx = (TextView)findViewById(R.id.counter);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.container.removeAllViews();
        this.shape = new MyShape(container.getContext(),container.getWidth(),container.getHeight());
        this.container.addView(shape);
        this.container.invalidate();
    }

    public void move(View v) {
        String direct = String.valueOf(((Button)findViewById(v.getId())).getText());
        if (direct.equals(">"))
            animation(this.shape.getMove());
        else
            animation(-1*(this.shape.getMove()));

        this.tx.setText(String.valueOf((Integer.valueOf(tx.getText().toString())+1)));
    }

    private void animation(int move) {
        this.animation = new TranslateAnimation(0,move,0,0);
        this.animation.setDuration(1000);
        this.animation.setFillAfter(true);
        this.shape.startAnimation(animation);
        this.shape.setX(move);
    }


}
