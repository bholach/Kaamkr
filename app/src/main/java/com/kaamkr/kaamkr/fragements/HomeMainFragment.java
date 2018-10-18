package com.kaamkr.kaamkr.fragements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaamkr.kaamkr.R;
import com.kaamkr.kaamkr.adapter.HomeCardRecyclerAdapter;
import com.kaamkr.kaamkr.model.SectionDataModel;
import com.kaamkr.kaamkr.model.SingleItemModel;

import java.util.ArrayList;

public class HomeMainFragment extends Fragment {


    public HomeMainFragment() { }

    RecyclerView recyclerView;
    ArrayList<SectionDataModel> allSampleData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v =  inflater.inflate(R.layout.fragment_home_main, container, false);
        allSampleData = new ArrayList<>();
        recyclerView = v.findViewById(R.id.home_recycler_view);
        createDummyData();

        recyclerView.setHasFixedSize(true);

        HomeCardRecyclerAdapter adapter = new HomeCardRecyclerAdapter(getContext(), allSampleData);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);

       return v;
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 1; j <= 6; j++) {
                singleItem.add(new SingleItemModel((j-1)+"0:0" + j+" left", "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }
}
