package com.example.kisar.dovizapp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.R;

import java.util.List;

/**
 * Created by kisar on 29.06.2019.
 */

public class MadenFragment extends Fragment {
    TextView tv;
    List<Doviz> dovizList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_maden, container, false);
        tv= (TextView) v.findViewById(R.id.textView);
        if(getArguments()!=null){
            dovizList= (List<Doviz>) getArguments().getSerializable("list");
        }else {
            Log.e("frs","frs");
        }
        tv.setText(dovizList.get(0).getName().toString());
        return v;
    }
}
