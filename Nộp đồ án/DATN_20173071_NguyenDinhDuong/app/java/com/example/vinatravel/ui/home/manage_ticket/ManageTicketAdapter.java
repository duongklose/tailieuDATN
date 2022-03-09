package com.example.vinatravel.ui.home.manage_ticket;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ManageTicketAdapter extends FragmentPagerAdapter {
    public ManageTicketAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MyTicketFragment();
            case 1:
                return new OldTicketFragment();
            case 2:
                return new CancelledTicketFragment();
            default:
                return new MyTicketFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Vé đang đặt";
                break;
            case 1:
                title = "Chuyến đã đi";
                break;
            case 2:
                title = "Vé đã hủy";
                break;
            default:
                title = "Vé đang đặt";
        }
        return title;
    }
}
