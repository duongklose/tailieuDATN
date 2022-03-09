package com.example.vinatravel.ui.book_ticket;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.tranportation_company.TranportationCompany;
import com.example.vinatravel.ui.ItemClickListener;

import java.util.ArrayList;

public class TransportationCompanyAdapter extends RecyclerView.Adapter<TransportationCompanyAdapter.ViewHolder> {

    private ArrayList<TranportationCompany> tranportationCompanies;
    private Context context;

    public TransportationCompanyAdapter(ArrayList<TranportationCompany> tranportationCompanies, Context context) {
        this.tranportationCompanies = tranportationCompanies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row_choose_coach_recyclerview,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(tranportationCompanies.get(position).getName());
        holder.imvLogo.setImageResource(tranportationCompanies.get(position).getLogo());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ChooseSeat.class);
                intent.putExtra("chooseSeat", tranportationCompanies.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tranportationCompanies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        ImageView imvLogo;
        TextView tvName;
        private ItemClickListener itemClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imvLogo = (ImageView) itemView.findViewById(R.id.imvLogo);
            tvName = (TextView) itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }
}
