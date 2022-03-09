package com.example.vinatravel.ui.book_ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vinatravel.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ChooseArrivalLocation extends AppCompatActivity {
    MaterialToolbar toolbar;
    Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_arrival_location_screen);
        toolbar = findViewById(R.id.topAppBarChooseArrivalLocation);
        btnContinue = findViewById(R.id.continue_btn_arrival_location);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content_arrival_location, new ArrivalLocationFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ChooseService.class);
                startActivity(intent1);
            }
        });
    }
}