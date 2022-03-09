package com.example.vinatravel.ui.home.manage_ticket;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vinatravel.R;
import com.google.android.material.tabs.TabLayout;

public class TicketFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public TicketFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_ticket);
        viewPager = view.findViewById(R.id.view_pager_ticket);

        ManageTicketAdapter manageTicketAdapter = new ManageTicketAdapter(getFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(manageTicketAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}