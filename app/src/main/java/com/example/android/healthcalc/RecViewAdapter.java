package com.example.android.healthcalc;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Stanislav on 10/14/2016.
 */
public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    private ArrayList<Food> mAdapterData;
    private String mStringG;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName, mTvCal, mTvProt, mTvCarbs, mTvFats;

        public ViewHolder(View itemView) {
            super(itemView);

            mTvName=(TextView)itemView.findViewById(R.id.tv_rec_view_item_name);
            mTvCal=(TextView)itemView.findViewById(R.id.tv_rec_view_item_cal);
            mTvProt=(TextView)itemView.findViewById(R.id.tv_rec_view_item_prot);
            mTvCarbs=(TextView)itemView.findViewById(R.id.tv_rec_view_item_carbs);
            mTvFats=(TextView)itemView.findViewById(R.id.tv_rec_view_item_fats);

        }
    }

    public RecViewAdapter(ArrayList<Food> data) {
        mAdapterData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mStringG = parent.getResources().getString(R.string.g);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_item,parent,false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder!=null){
            holder.mTvName.setText(mAdapterData.get(position).getmStrName());
            holder.mTvCal.append(" " + String.valueOf(mAdapterData.get(position).getmIntCalories()));
            holder.mTvProt.append(" " + String.valueOf(mAdapterData.get(position).getmIntProtein()) + mStringG);
            holder.mTvCarbs.append(" " + String.valueOf(mAdapterData.get(position).getmIntCarbs()) + mStringG);
            holder.mTvFats.append(" " + String.valueOf(mAdapterData.get(position).getmIntFats()) + mStringG);
        }

    }

    @Override
    public int getItemCount() {
        return mAdapterData.size();
    }


}
