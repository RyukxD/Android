package com.example.angelo.lab090216;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by angelo on 04/07/16.
 */
public class MyShape extends View {

    private Paint paint;
    private int dimension,move,x,y;

    public MyShape(Context context, int x, int y) {
        super(context);

        this.x = x;
        this.y = y/2;
        this.dimension = x/20;
        this.move = x;
        this.paint = new Paint();
        this.paint.setColor(Color.RED);
        this.paint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.x,this.y,this.dimension,this.paint);
    }

    public void setX(int x) {
        this.x += x;
    }

    public int getMove() {
        return this.move;
    }

    public int getDimension() {
        return dimension;
    }
}
