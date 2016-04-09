package com.example.angelo.minisudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

public class MiniSudoku extends AppCompatActivity {

    private GridLayout grid;
    private TextView tv;
    private EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_sudoku);
        this.grid = (GridLayout)findViewById(R.id.grid);
        this.tv = (TextView)findViewById(R.id.text);
        this.et = (EditText)findViewById(R.id.et);
        setAction();


    }

    private void setAction() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et.getText().toString();
                Button field = (Button) v;
                try {
                    if ((!number.isEmpty()  &&
                            (Integer.parseInt(number) > 0 && Integer.parseInt(number) < 4)
                            && field.getText().toString().isEmpty())) {
                        field.setText(number);
                    }
                }catch(NumberFormatException e){

                }
            }

        };

        View.OnLongClickListener longlistener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ((Button)v).setText("");
                return true;
            }
        };

        for(int c=0 ; c<this.grid.getChildCount(); c++) {
            this.grid.getChildAt(c).setOnClickListener(listener);
            this.grid.getChildAt(c).setOnLongClickListener(longlistener);
        }





    }


    public void check(View v){
        this.tv.setText("");
        for(int c = 0;c<this.grid.getRowCount();c++)
            if(((Button)this.grid.getChildAt(c)).getText().toString().equals(((Button)this.grid.getChildAt(c+3)).getText().toString())
                    || ((Button)this.grid.getChildAt(c)).getText().toString().equals(((Button)this.grid.getChildAt(c+6)).getText().toString())
                    || ((Button)this.grid.getChildAt(c*3)).getText().toString().equals(((Button)this.grid.getChildAt((c*3)+1)).getText().toString())
                    || ((Button)this.grid.getChildAt(c*3)).getText().toString().equals(((Button)this.grid.getChildAt((c*3)+2)).getText().toString())
                    || ((Button)this.grid.getChildAt(c+3)).getText().toString().equals(((Button)this.grid.getChildAt(c+6)).getText().toString())
                    || ((Button)this.grid.getChildAt((c*3)+1)).getText().toString().equals(((Button)this.grid.getChildAt((c*3)+2)).getText().toString()))
                this.tv.setText("Configurazione non legale");
    }


}
