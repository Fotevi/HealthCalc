package com.example.android.healthcalc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fotev on 10/23/2016.
 */
public class RecViewAdapterDiary extends RecyclerView.Adapter<RecViewAdapterDiary.ViewHolder> {

    public interface IRVdiaryOnClick{
        void onItemSelected(int position);
    }

    private IRVdiaryOnClick mListener;
    private String mStringG;
    private ArrayList<Food> mAdapterData;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName, mTvCal, mTvProt, mTvCarbs, mTvFats, mTvVitA, mTvVitB, mTvVitC, mTvVitD,
                mTvZinc, mTvMagnesium, mTvIron;
        int position;

        private void getItemPosition(int position){
            this.position=position;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            mTvName=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_name);
            mTvCal=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_cal);
            mTvProt=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_prot);
            mTvCarbs=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_carbs);
            mTvFats=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_fats);
            mTvVitA=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_vitA);
            mTvVitB=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_vitB6);
            mTvVitC=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_vitC);
            mTvVitD=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_vitD);
            mTvZinc=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_zinc);
            mTvMagnesium=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_magnesium);
            mTvIron=(TextView)itemView.findViewById(R.id.tv_rec_view_diary_item_iron);

        }
    }

    public RecViewAdapterDiary(ArrayList<Food> data, IRVdiaryOnClick context) {
        this.mAdapterData = data;
        this.mListener = context;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder!=null){
            holder.mTvName.setText(mAdapterData.get(position).getmStrName());
            holder.mTvCal.append(" " + String.valueOf(mAdapterData.get(position).getmIntCalories()));
            holder.mTvProt.append(" " + String.valueOf(mAdapterData.get(position).getmIntProtein()) + mStringG);
            holder.mTvCarbs.append(" " + String.valueOf(mAdapterData.get(position).getmIntCarbs()) + mStringG);
            holder.mTvFats.append(" " + String.valueOf(mAdapterData.get(position).getmIntFats()) + mStringG);
            holder.mTvVitA.append(" " + String.valueOf(mAdapterData.get(position).getmIntVitA()));
            holder.mTvVitB.append(" " + String.valueOf(mAdapterData.get(position).getmIntVitB6()));
            holder.mTvVitC.append(" " + String.valueOf(mAdapterData.get(position).getmIntVitC()));
            holder.mTvVitD.append(" " + String.valueOf(mAdapterData.get(position).getmIntVitD()));
            holder.mTvZinc.append(" " + String.valueOf(mAdapterData.get(position).getmIntZinc()));
            holder.mTvMagnesium.append(" " + String.valueOf(mAdapterData.get(position).getmIntMagnesium()));
            holder.mTvIron.append(" " + String.valueOf(mAdapterData.get(position).getmIntIron()));
            holder.getItemPosition(position);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mStringG = parent.getResources().getString(R.string.g);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_diary_item,parent,false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public int getItemCount() {
        return mAdapterData.size();
    }
}
