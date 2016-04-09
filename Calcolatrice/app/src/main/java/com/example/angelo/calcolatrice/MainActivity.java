package com.example.angelo.calcolatrice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int[] number={R.id.zero,R.id.uno,R.id.due,R.id.tre,R.id.quattro,R.id.cinque,R.id.sei,
            R.id.sette,R.id.otto,R.id.nove};
    private int operator[]={R.id.divisione,R.id.moltiplicazione,R.id.addizione,R.id.sottrazione };
    private TextView result;
    private String currentOp;
    private float first;
    private float second;
    private boolean check=false;
    static  final String STATE = "ESPRESSIONE";
    static  final String CHECK = "CONTROLLO";
    static final String OPERATION = "OPERAZIONE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.result = (TextView) findViewById(R.id.risultato);
        setNumericOnClicklistener();
        setOperatorOnClicklistener();
    }


    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        result.setText(savedInstanceState.getString(STATE).toString());
        check = savedInstanceState.getBoolean(CHECK);
        currentOp = savedInstanceState.getString(OPERATION);
    }


    @Override
    public	void onSaveInstanceState(android.os.Bundle	savedInstanceState)	{
        savedInstanceState.putString(STATE,result.getText().toString());
        savedInstanceState.putBoolean(CHECK,check);
        savedInstanceState.putString(OPERATION,currentOp);
        super.onSaveInstanceState(savedInstanceState);
    }


    private void setNumericOnClicklistener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button=(Button) v;
                result.append(button.getText());
            }
        };
        for(int id : number)
            findViewById(id).setOnClickListener(listener);

    }

    private void setOperatorOnClicklistener(){
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!check) {
                        Button button = (Button) v;
                        result.append(button.getText());
                        currentOp = ((Button) v).getText().toString();
                        check = true;
                    }
                }
            };
            for (int id : operator)
                findViewById(id).setOnClickListener(listener);



        findViewById(R.id.punto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append(".");
            }
        });

        findViewById(R.id.cancella).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                check=false;
            }
        });

        findViewById(R.id.uguale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=false;
                String expression = result.getText().toString();
                if (expression.isEmpty())
                    return;
                String[] tmp=expression.split("[-,+,X,/]");
                if(tmp.length==2) {
                    first = Float.parseFloat(tmp[0]);
                    second =Float.parseFloat(tmp[1]);
                    if (currentOp.equals("+"))
                        add(first, second);
                    else if (currentOp.equals("-"))
                        sub(first, second);
                    else if (currentOp.equals("X"))
                        mol(first, second);
                    else if (currentOp.equals("/"))
                        div(first, second);
                    else
                        Toast.makeText(MainActivity.this,"Errore",Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(MainActivity.this,"Errore",Toast.LENGTH_SHORT).show();

            }
        });



    }
    public void add(float a, float b){
        result.setText(Float.toString(a+b));

    }

    public void sub(float a, float b){
        result.setText(Float.toString(a-b));

    }

    public void mol(float a, float b){
        result.setText(Float.toString(a*b));
    }

    public void div(float a , float b){
        result.setText(Float.toString(a/b));

    }

}
