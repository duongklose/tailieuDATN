package com.example.vinatravel.ui.book_ticket;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.seat.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatFragment extends Fragment {
    ArrayList<Seat> seatArrayList;
    RecyclerView rcvSeat;
    RecyclerView.LayoutManager layoutManager;
    TextView tvSeats, tvPrice;
    SeatAdapter seatAdapter;

    public SeatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        seatArrayList = new ArrayList<>();
        seatArrayList.add(new Seat("A1", 0));
        seatArrayList.add(new Seat("B1", 0));
        seatArrayList.add(new Seat("C1", 0));
        seatArrayList.add(new Seat("A3", 0));
        View view = inflater.inflate(R.layout.item_40_seats_coach, container, false);
        initView(view);
        return view;
    }

    public void initView(View view){
        tvSeats = getActivity().findViewById(R.id.tv_seats);
        tvPrice = getActivity().findViewById(R.id.tv_price);
        rcvSeat = view.findViewById(R.id.rcv_40_seats);
        layoutManager = new GridLayoutManager(getActivity(), 10);
        rcvSeat.setLayoutManager(layoutManager);
        seatAdapter = new SeatAdapter(seatArrayList, getActivity());
        rcvSeat.setAdapter(seatAdapter);
        rcvSeat.setHasFixedSize(true);
    }
}