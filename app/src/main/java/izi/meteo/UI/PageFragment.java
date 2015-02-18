package izi.meteo.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import izi.meteo.Data.DataController;
import izi.meteo.R;


/**
 * Created by Antoine on 03/02/2015.
 */
public class PageFragment extends Fragment {
    //    @InjectView(R.id.displayCityInfo)
//    TextView tv_city;
    @InjectView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        create view to display weather
        View viewMeteo = inflater.inflate(R.layout.fragment_meteo, container, false);
        View viewSettings = inflater.inflate(R.layout.fragment_favoris, container, false);

        switch (mPage) {
            case 1:


                ButterKnife.inject(this, viewMeteo);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(mLayoutManager);
                RecyclerView.Adapter mAdapter;
                mAdapter = new CardAdapter();
                mRecyclerView.setAdapter(mAdapter);

//                tv_city.setText(SplashScreen.CURRENT_TOWN);
                return viewMeteo;
            case 2:

                return viewSettings;
            default:

                return viewMeteo;
        }
    }


}

