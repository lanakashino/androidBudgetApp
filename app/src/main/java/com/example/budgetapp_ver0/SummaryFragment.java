package com.example.budgetapp_ver0;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SummaryFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

//        recyclerView = view.findViewById(R.id.recycler_view);
//        movieList = new ArrayList<>();
//        mAdapter = new StoreAdapter(getActivity(), movieList);
//
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//        recyclerView.setNestedScrollingEnabled(false);
//
//        fetchStoreItems();

        FloatingActionButton addButton = view.findViewById(R.id.addEntryButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEntry(view);
            }
        });

        return view;
    }

    public void addNewEntry (View view) {
        Intent intent = new Intent(getActivity(), CreateNewEntryActivity.class);
        startActivity(intent);
    }

}
