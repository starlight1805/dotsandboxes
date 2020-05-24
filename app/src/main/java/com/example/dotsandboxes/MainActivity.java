package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView actv;
    EditText player1,player2;
    ImageView arrow;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv=findViewById(R.id.actv);
        arrow=findViewById(R.id.arrow);
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        enter=findViewById(R.id.enter);
        final Intent intent=new Intent(this,Main2Activity.class);
        ArrayAdapter<String>adapter=new ArrayAdapter<String >(this,android.R.layout.simple_dropdown_item_1line,grids);
        actv.setAdapter(adapter);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv.showDropDown();
            }
        });
        actv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv.showDropDown();
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=""+player1.getText().toString();
                String name2=""+player2.getText().toString();
                int gr1=Integer.parseInt(actv.getText().toString());
                intent.putExtra("grid",gr1);
                intent.putExtra("name1",name1);
                intent.putExtra("name2",name2);
                startActivity(intent);
            }
        });

    }
    public static final String[] grids=new String[]{"3","4","5","6"};
}
