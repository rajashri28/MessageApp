package com.example.teslaind1.messageapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teslaind1.messageapp.R;

/**
 * Created by Teslaind 1 on 3/20/2018.
 */

public class FragmentNightSms extends Fragment {
    private RecyclerView mRecyclerView;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_nightsms, null);

        return view;
    }

}