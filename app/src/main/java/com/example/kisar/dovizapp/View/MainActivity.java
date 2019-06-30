package com.example.kisar.dovizapp.View;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.Model.JsonHelper;
import com.example.kisar.dovizapp.Model.TaskComplated;
import com.example.kisar.dovizapp.R;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskComplated {
        boolean calisti;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment= homeFragment;
                    break;

                case R.id.navigation_dashboard:
                    selectedFragment=dovizFragment;
                    break;


                case R.id.navigation_notifications:
                    selectedFragment=madenFragment;
                    break;

                case R.id.navigation_portfoy:
                    selectedFragment=portfoyFragment;
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.content,selectedFragment).commit();
            //new JsonHelper(MainActivity.this).execute("https://api.canlidoviz.com/web/items?marketId=1&type=0");

            return true;
        }

    };
    HomeFragment homeFragment = new HomeFragment();
    DovizFragment dovizFragment = new DovizFragment();
    MadenFragment madenFragment = new MadenFragment();
    PortfoyFragment portfoyFragment=new PortfoyFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calisti=true;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        new JsonHelper(MainActivity.this).execute("https://api.canlidoviz.com/web/items?marketId=1&type=0");


    }


    @Override
    public void onTaskCoplated(List<Doviz> dovizList) {
        Bundle args=new Bundle();
        args.putSerializable("list", (Serializable) dovizList);
        Log.e("task",dovizList.get(0).getName().toString());
        homeFragment.setArguments(args);
        madenFragment.setArguments(args);
        dovizFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.content,homeFragment).commit();
    }
}
