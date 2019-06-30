package com.example.kisar.dovizapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.R;

import java.util.List;

/**
 * Created by kisar on 29.06.2019.
 */

public class DovizFragment extends Fragment {
    List<Doviz> dovizList;
    ListView lstDoviz;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_doviz, container, false);
        lstDoviz= (ListView) v.findViewById(R.id.listDoviz);
        lstDoviz.setFocusable(false);
        if(getArguments()!=null){
            dovizList= (List<Doviz>) getArguments().getSerializable("list");
            CustomAdapter adapter=new CustomAdapter(getActivity(),dovizList,1);

            lstDoviz.setSelected(true);
            lstDoviz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i =new Intent(getActivity(),DetayActivity.class);
                    i.putExtra("doviz",dovizList.get(position));
                    startActivity(i);
                }
            });

            lstDoviz.setAdapter(adapter);


        }else {
            Log.e("frs","frs");
        }

        return v;
    }
}
