package com.example.travelindiaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ArrayList<DestinationsModel> arrDest=new ArrayList<DestinationsModel>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        //add data in arrayList
        addData();

        //RecyclerView
        RecyclerView recyclerDestinations=view.findViewById(R.id.recyclerDestinations);

        //
        recyclerDestinations.setLayoutManager(new LinearLayoutManager(getActivity()));


        RecyclerDestinationsAdapter recyclerDestinationsAdapter=new RecyclerDestinationsAdapter(arrDest);

        recyclerDestinations.setAdapter(recyclerDestinationsAdapter);

        return view;
    }
    public void addData(){
        arrDest.add(new DestinationsModel(R.drawable.leh,R.string.leh, R.string.leh_shortdesc));
        arrDest.add(new DestinationsModel(R.drawable.goa,R.string.goa, R.string.goa_shortdesc));
        arrDest.add(new DestinationsModel(R.drawable.gokarna,R.string.gokarna, R.string.gokarna_shortdesc));
        arrDest.add(new DestinationsModel(R.drawable.srinagar,R.string.srinagar, R.string.srinagar_shortdesc));
        arrDest.add(new DestinationsModel(R.drawable.lakshadweep,R.string.lakshadweep, R.string.lakshadweep_shortdesc));
        arrDest.add(new DestinationsModel(R.drawable.havelock_island,R.string.havelock_island, R.string.havelock_island_shortdesc));
        /*arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());
        arrDest.add(new DestinationsModel());*/
    }
}