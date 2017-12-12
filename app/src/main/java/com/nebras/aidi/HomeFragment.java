package com.nebras.aidi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mahmoudkamal on 8/29/17.
 */

public class HomeFragment extends Fragment {

    private TextView tvTopGroups,tvRecentJobs;
    private RecyclerView rcTopGroups,rcRecentJobs;

    private LinearLayoutManager hLinearLayoutManager,vLinearLayoutManager;
    private List<Object> jobs = new ArrayList<>();
    private GeneralAdapter jobsAdapter;
    private GeneralAdapter topGroupsAdapter;
    private List<Object> topGroups = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        jobs.add(new Job());
        jobs.add(new Job());
        jobs.add(new Job());
        jobs.add(new Job());
        jobs.add(new Job());
        jobs.add(new Job());

        topGroups.add(new Group());
        topGroups.add(new Group());
        topGroups.add(new Group());
        topGroups.add(new Group());
        topGroups.add(new Group());
        topGroups.add(new Group());

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home,container,false);
       tvTopGroups = (TextView) view.findViewById(R.id.tv_top_groups);
       tvRecentJobs = (TextView) view.findViewById(R.id.tv_rc_jobs_title);
       rcRecentJobs = (RecyclerView) view.findViewById(R.id.rc_recent_jobs);
       rcTopGroups = (RecyclerView) view.findViewById(R.id.rc_top_groups);
       hLinearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true);
       vLinearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
       rcTopGroups.setLayoutManager(hLinearLayoutManager);
       rcRecentJobs.setLayoutManager(vLinearLayoutManager);


        updateAdapters();




       return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void updateAdapters(){


            jobsAdapter = new GeneralAdapter(getActivity(),jobs,"","");
            rcRecentJobs.setAdapter(jobsAdapter);

            topGroupsAdapter = new GeneralAdapter(getActivity(),topGroups,"","");
            rcTopGroups.setAdapter(topGroupsAdapter);

    }



}
