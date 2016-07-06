package com.example.angelo.lab090216;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
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
        String direct = String.valueOf(((Button)v).getText());
        v.setEnabled(false);
        final Button b = (Button) v;
        if (direct.equals(">")) {
            this.animation = new TranslateAnimation(0,(this.shape.getMove() - (this.shape.getDimension()*2)),0,0);
            this.animation.setDuration(100);
            this.animation.setFillAfter(true);
            this.animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    (((RelativeLayout) b.getParent()).getChildAt(1)).setEnabled(true);
                    shape.setMyX((shape.getMove() - (shape.getDimension()*2)));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            this.shape.startAnimation(animation);
        }
        else {
            this.animation = new TranslateAnimation(0,-1 * (this.shape.getMove() - (this.shape.getDimension()*2)),0,0);
            this.animation.setDuration(100);
            this.animation.setFillAfter(true);
            this.animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    (((RelativeLayout) b.getParent()).getChildAt(0)).setEnabled(true);
                    shape.setMyX(-1 * (shape.getMove() - (shape.getDimension()*2)));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            this.shape.startAnimation(animation);
        }

        this.container.invalidate();
        this.tx.setText(String.valueOf((Integer.valueOf(tx.getText().toString())+1)));
    }


}
