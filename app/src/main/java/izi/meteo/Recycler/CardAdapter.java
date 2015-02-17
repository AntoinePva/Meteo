package izi.meteo.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import izi.meteo.Data.DataController;
import izi.meteo.Data.DataModel;
import izi.meteo.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    List<DataModel> mItems;
 
    public CardAdapter() {
        super();

       mItems = DataController.listLocation;

    }
 
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_simple_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
 
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DataModel mD = mItems.get(i);
        viewHolder.tvMovie.setText(mD.getName());
//        viewHolder.imgThumbnail.setImageResource(mD.getId());
    }
 
    @Override
    public int getItemCount() {
        return mItems.size();
    }
 
    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvMovie;
 
        public ViewHolder(View itemView) {
            super(itemView);

            tvMovie = (TextView)itemView.findViewById(R.id.displayCityInfo);
        }
    }
}