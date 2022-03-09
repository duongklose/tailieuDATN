package com.example.vinatravel.ui.book_ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.vinatravel.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ChoosePaymentMethod extends AppCompatActivity {
    MaterialToolbar toolbar;
    AutoCompleteTextView bank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_payment_method_screen);
        toolbar = findViewById(R.id.topAppBarChoosePaymentMethod);
        bank = findViewById(R.id.bank);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //dropdown menu - bank
//        String []bank = getResources().getStringArray(R.array.list_bank);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getParent(), R.layout.province_item, bank);
//
//        //make default value
//        bank.setText(arrayAdapter.getItem(0).toString(), false);
//        bank.setAdapter(arrayAdapter);
        Intent intent = getIntent();
    }
}