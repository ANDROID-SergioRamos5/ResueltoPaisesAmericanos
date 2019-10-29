    package com.example.resueltopaisesamericanos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

    public class MainActivity extends AppCompatActivity {

    private String[] paises = {"Argentina","Chile","Paraguay","Bolivia","Peru", "Ecuador", "Brasil", "Colombia",
            "Venezuela", "Uruguay", "TODOS"};
    private int[] poblacion = {40000000, 17000000,6500000,10000000,30000000,
            14000000,183000000,44000000,29000000,3500000};

    private TextView tV;
    private ListView lV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV = (TextView)findViewById(R.id.textView);
        lV = (ListView) findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, paises);
        lV.setAdapter(adapter);

        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (paises[position] == "TODOS")
                {
                    int total = 0;
                    //En los apuntes pone paises.length, esta mal, debe ser poblacion.lenght
                    for (int i = 0; i<poblacion.length; i++)
                        total += poblacion[i];

                    tV.setText("Poblacion de " + lV.getItemAtPosition(position) + " es " + total + " millones.");
                }
                else
                    tV.setText("Poblacion de " + lV.getItemAtPosition(position)+ " es " + poblacion[position] + " millones");

            }
        });
    }
}
