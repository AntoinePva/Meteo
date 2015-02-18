package izi.meteo.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import izi.meteo.Data.DataModel;
import izi.meteo.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    ArrayList<DataModel> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<>();
        DataModel dOne = new DataModel("Lun'zer");
        DataModel dTwo = new DataModel("Mar'zer");
        DataModel dThree = new DataModel("Mercre'zer");
        DataModel dFour = new DataModel("Jeudizi");
        DataModel dFive = new DataModel("Vendredizi");
        DataModel dSix = new DataModel("Samedizi");
        mItems.add(dOne);
        mItems.add(dTwo);
        mItems.add(dThree);
        mItems.add(dFour);
        mItems.add(dFive);
        mItems.add(dSix);
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
        viewHolder.tvDay.setText(mD.getName());
//        viewHolder.imgThumbnail.setImageResource(mD.getId());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDay;

        public ViewHolder(View itemView) {
            super(itemView);

            tvDay = (TextView) itemView.findViewById(R.id.displayCityInfo);
        }
    }
}