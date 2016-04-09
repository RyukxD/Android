package com.example.angelo.lab150706;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by angelo on 27/03/16.
 */


public class  Shape extends View{

    private int x,y,dimension,move;
    private Paint paint;


    public Shape(Context context,int x,int y){
        super(context);
        this.x = x/2;
        this.y = y/2;
        this.dimension = x/20;
        this.move = x/10;
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.RED);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.x,this.y,this.dimension,this.paint);
    }


    public void setX(int x) {
        this.x += x;
    }

    public void setY(int y) {
        this.y += y;
    }

    public void setDimension(int dimension){
        this.dimension = dimension;
    }


    public int getMyX() {
        return this.y;
    }

     public int getMyY(){
         return this.x;
     }

    public int getDimension() {
        return this.dimension;
    }

    public int getMove(){ return this.move; }



}
