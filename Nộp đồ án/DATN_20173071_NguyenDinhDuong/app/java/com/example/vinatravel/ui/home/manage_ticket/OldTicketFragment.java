package com.example.vinatravel.ui.home.manage_ticket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.vinatravel.R;

public class OldTicketFragment extends Fragment {

    public OldTicketFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_old_ticket, container, false);
    }
}
