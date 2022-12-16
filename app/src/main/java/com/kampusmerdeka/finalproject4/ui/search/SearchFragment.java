package com.kampusmerdeka.finalproject4.ui.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.kampusmerdeka.finalproject4.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private Spinner spDeparture;
    private ArrayList<String> arrayCities;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        arrayCities = new ArrayList<>();
        arrayCities.add("Dago");
        arrayCities.add("Setiabudi");
        arrayCities.add("Pasteur");
        arrayCities.add("Asia Afrika");
        arrayCities.add("Tamansari");
        arrayCities.add("Cikutra");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayCities);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spDeparture.setAdapter(adapter);
        spDeparture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),adapter.getItem(i),Toast.LENGTH_SHORT).show();
            }
        });

        return inflater.inflate(R.layout.fragment_search,container, false);
    }
}