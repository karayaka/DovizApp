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
import android.widget.TextView;
import android.widget.Toast;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.Model.JsonHelper;
import com.example.kisar.dovizapp.Model.SQLiteHelper;
import com.example.kisar.dovizapp.Model.TaskComplated;
import com.example.kisar.dovizapp.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kisar on 29.06.2019.
 */

public class HomeFragment extends Fragment  {

    ListView lsthome;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        final List<Doviz> dovizList=new ArrayList<>();
        SQLiteHelper db=new SQLiteHelper(getActivity());
        lsthome= (ListView) view.findViewById(R.id.lsthome);
        if(getArguments()!=null){
            for(Doviz doviz1:(List<Doviz>) getArguments().getSerializable("list")){
                for(Doviz doviz2:db.KayitList()){
                    if(doviz1.getCode().equals(doviz2.getCode().toString())){
                        if(doviz2!=null){
                            dovizList.add(doviz1);
                        }else {
                            Toast.makeText(getActivity(),R.string.toaslisteBos,Toast.LENGTH_LONG).show();
                        }

                    }
                }
            }
            CustomAdapter adapter=new CustomAdapter(getActivity(),dovizList,0);
            lsthome.setAdapter(adapter);
            lsthome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i =new Intent(getActivity(),DetayActivity.class);
                    i.putExtra("doviz",dovizList.get(position));
                    startActivity(i);
                }
            });


        }else {
            Log.e("frs","frs");
        }

        return view;
    }


}
