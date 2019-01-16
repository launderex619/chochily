package com.carcavaz.chochilyapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;

public class StartActivity extends AppCompatActivity {

    CardView startPersonalCardview;
    CardView startProduccionCardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startPersonalCardview = (CardView) findViewById(R.id.start_personal_cardview);
        startProduccionCardview = (CardView) findViewById(R.id.start_produccion_cardview);



        startPersonalCardview.setOnClickListener(listener);
        startProduccionCardview.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            if(v == startPersonalCardview){
                intent.putExtra("StartPage", R.id.navigation_personal);
            }
            else if(v == startProduccionCardview){
                intent.putExtra("StartPage", R.id.navigation_produccion);
            }

            startActivity(intent);
        }
    };
}
