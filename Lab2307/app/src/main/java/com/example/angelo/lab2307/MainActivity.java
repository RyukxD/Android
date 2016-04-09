package com.example.angelo.lab2307;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int[] value = {R.id.resu,R.id.resu1,R.id.resu2,R.id.resu3,R.id.resu4,R.id.resu5,
            R.id.resu6};
    private int[] decremento = {R.id.dec,R.id.dec1,R.id.dec2,R.id.dec3,R.id.dec4,R.id.dec5,
            R.id.dec6};
    private int[] incremento = {R.id.inc,R.id.inc1,R.id.inc2,R.id.inc3,R.id.inc4,R.id.inc5,
            R.id.inc6};
    private Button risultato;
    private String[] valori = new String[7];
    private static final String STATO = "RISULTATO";
    private static final String ARRAY = "VALORI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.risultato = (Button) findViewById(R.id.risultato);
        setDecrementoOnClickListener();
        setIncrementoOnClickListener();
        setOperationOnClickListener();
        if(savedInstanceState != null){
            risultato.setText(savedInstanceState.getString(STATO).toString());
            for(int id=0;id<value.length;id++)
                ((Button)findViewById(value[id])).setText(savedInstanceState.
                        getStringArray(ARRAY)[id].toString());
        }

    }


   /* @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        risultato.setText(savedInstanceState.getString(STATO).toString());
        for(int id=0;id<value.length;id++)
            ((Button)findViewById(value[id])).setText(savedInstanceState.
                    getStringArray(ARRAY)[id].toString());
    }*/

    @Override
    public void onSaveInstanceState(android.os.Bundle	savedInstanceState)	{
        savedInstanceState.putString(STATO,risultato.getText().toString());
        for(int id=0;id<value.length;id++)
            valori[id]=((Button)findViewById(value[id])).getText().toString();
        savedInstanceState.putStringArray(ARRAY,valori);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void setDecrementoOnClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                int buttonid = button.getId();
                for (int id=0; id<decremento.length;id++)
                    if(buttonid == decremento[id]){
                        Button valuebutton = (Button)findViewById(value[id]);
                        int tmp = Integer.parseInt(valuebutton.getText().toString());
                        if (!(tmp <=0))
                            valuebutton.setText(Integer.toString(tmp-1));
                        break;
                    }
            }
        };
        for(int id : decremento)
            findViewById(id).setOnClickListener(listener);
    }




    private  void setIncrementoOnClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button =(Button) v;
                int buttonid = button.getId();
                for (int id=0; id<incremento.length;id++)
                    if(buttonid == incremento[id]){
                        Button valuebutton = (Button)findViewById(value[id]);
                        int tmp = Integer.parseInt(valuebutton.getText().toString());
                        if (tmp <20)
                            valuebutton.setText(Integer.toString(tmp+1));
                        break;
                    }
            }
        };
        for(int id : incremento)
            findViewById(id).setOnClickListener(listener);
    }

    private void setOperationOnClickListener(){
        findViewById(R.id.somma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp=0;
                for(int id: value)
                    tmp+= Integer.parseInt(((Button)findViewById(id)).getText().toString());
                risultato.setText(Integer.toString(tmp));
            }
        });

        findViewById(R.id.moltiplicazione).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp=1;
                for(int id:value)
                    tmp*= Integer.parseInt(((Button)findViewById(id)).getText().toString());
                risultato.setText(Integer.toString(tmp));
            }
        });

    }

}



