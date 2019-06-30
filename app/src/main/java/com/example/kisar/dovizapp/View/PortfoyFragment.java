package com.example.kisar.dovizapp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.Model.SQLiteHelper;
import com.example.kisar.dovizapp.R;

import java.util.List;

/**
 * Created by kisar on 29.06.2019.
 */

public class PortfoyFragment extends Fragment {
    ListView lstportfoy;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_porfoy, container, false);
        lstportfoy= (ListView) v.findViewById(R.id.lstportfoy);
        SQLiteHelper db=new SQLiteHelper(getActivity());
        CustomAdapter adapter =new CustomAdapter(getActivity(),db.KayitList(),3);
        lstportfoy.setAdapter(adapter);

        return v;
    }
}
