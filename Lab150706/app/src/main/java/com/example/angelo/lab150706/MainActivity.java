package com.example.angelo.lab150706;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;
    private Animation animation;
    private Shape shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.container = (FrameLayout) findViewById(R.id.frame);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.container.removeAllViews();
        this.shape = new Shape(getApplicationContext(),this.container.getWidth(),this.container.getHeight());
        this.container.addView(shape);
        this.container.invalidate();
    }


    public void move(View v){
        String[] name = getResources().getResourceName(v.getId()).split("/");
        if(name[1].equals("up"))
             animationY(-1 * (this.shape.getMove()));
        else if (name[1].equals("down"))
            animationY(this.shape.getMove());
        else if (name[1].equals("left"))
            animationX(-1 * (this.shape.getMove()));
        else
            animationX(this.shape.getMove());

    }

    public void animationX(int move){
        Log.d("DEBUG","");
        if(intersects(this.shape.getMyX(),this.container.getWidth())) {
            this.animation = new TranslateAnimation(0, move, 0, 0);
            this.animation.setDuration(1000);
            this.animation.setFillAfter(true);
            this.shape.startAnimation(animation);
            this.shape.setX(move);
            Log.d("DEBUG", "");
        }
    }


    public void animationY(int move){
        if(intersects(this.shape.getMyY(),this.container.getHeight())) {
            this.animation = new TranslateAnimation(0, 0, 0, move);
            this.animation.setDuration(1000);
            this.animation.setFillAfter(true);
            this.shape.startAnimation(animation);
            this.shape.setY(move);
        }
    }

    public boolean intersects(int x,int d){
        int dimension = this.shape.getDimension();
        boolean intersects = true;
        if (x + dimension >= d || x - dimension <= 0)
            intersects = false;

        return intersects;
    }





}
