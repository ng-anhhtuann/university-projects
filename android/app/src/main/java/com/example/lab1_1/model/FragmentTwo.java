package com.example.lab1_1.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lab1_1.R;

public class FragmentTwo extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, viewGroup, false);
        TextView output= (TextView)view.findViewById(R.id.msg2);
        output.setText("Fragment Two");
        return view;
    }
}
