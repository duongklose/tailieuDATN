package com.example.vinatravel.ui.book_ticket;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.tranportation_company.TranportationCompany;
import com.example.vinatravel.ui.home.MainActivity;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class ChooseCoach extends Activity {
    RecyclerView recyclerView;
    MaterialToolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_coach_screen);
        initView();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("info");
        if (bundle != null){
            String startLocation = bundle.getString("startLocation");
            String endLocation = bundle.getString("endLocation");
            String date = bundle.getString("date");

            toolbar.setTitle(startLocation + " - " + endLocation);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initView(){
        toolbar = findViewById(R.id.topAppBarChooseCoach);

        recyclerView = findViewById(R.id.recyclerview_choose_coach);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        ArrayList<TranportationCompany> companyArrayList = new ArrayList<>();
        companyArrayList.add(new TranportationCompany(R.drawable.mailinh, "Mai Linh"));
        companyArrayList.add(new TranportationCompany(R.drawable.hoanglong, "Hoàng Long"));
        TransportationCompanyAdapter transportationCompanyAdapter = new TransportationCompanyAdapter(companyArrayList, getApplicationContext());
        recyclerView.setAdapter(transportationCompanyAdapter);
    }
}
