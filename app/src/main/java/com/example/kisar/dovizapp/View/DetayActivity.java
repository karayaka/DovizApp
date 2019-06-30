package com.example.kisar.dovizapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ColorFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DetayActivity extends AppCompatActivity {
    TextView tvcode,tvname,tvbugunalis,tvbugunsatis,tvbugunendusuk,tvbugunenyuksek,tvbugunendusuksatis,
    tvbugunenyukseksatis,tvduncapanisalis,tvgunsonukapanis,tvgunlukdegisim,gunlukdegisimyüzde,tvtarih ;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //tanımlamar
        tvcode= (TextView) findViewById(R.id.tvcode);
        tvname= (TextView) findViewById(R.id.tvname);
        tvbugunalis= (TextView) findViewById(R.id.tvbugunalis);
        tvbugunsatis= (TextView) findViewById(R.id.tvbugunsatis);
        tvbugunendusuk= (TextView) findViewById(R.id.tvbugunendusuk);
        tvbugunenyuksek= (TextView) findViewById(R.id.tvbugunenyuksek);
        tvbugunendusuksatis= (TextView) findViewById(R.id.tvbugunendusuksatis);
        tvbugunenyukseksatis= (TextView) findViewById(R.id.tvbugunenyukseksatis);
        tvduncapanisalis= (TextView) findViewById(R.id.tvduncapanisalis);
        tvgunsonukapanis= (TextView) findViewById(R.id.tvgunsonukapanis);
        tvgunlukdegisim= (TextView) findViewById(R.id.tvgunlukdegisim);
        gunlukdegisimyüzde= (TextView) findViewById(R.id.gunlukdegisimyüzde);
        tvtarih= (TextView) findViewById(R.id.tvtarih);
        barChart= (BarChart) findViewById(R.id.vchart);
        //veri girişi
        Doviz doviz= (Doviz) getIntent().getSerializableExtra("doviz");


        //textView Doldurma

        tvcode.setText(doviz.getCode().toString());
        tvname.setText(doviz.getName().toString());
        tvbugunalis.setText(String.valueOf(doviz.getBuyPrice()));
        tvbugunsatis.setText(String.valueOf(doviz.getSellPrice()));
        tvbugunendusuk.setText(String.valueOf(doviz.getTodayLowestBuyPrice()));
        tvbugunenyuksek.setText(String.valueOf(doviz.getTodayHighestBuyPrice()));
        tvbugunendusuksatis.setText(String.valueOf(doviz.getTodayLowestSellPrice()));
        tvbugunenyukseksatis.setText(String.valueOf(doviz.getTodayHighestSellPrice()));
        tvduncapanisalis.setText(String.valueOf(doviz.getYesterdayClosingSellPrice()));
        tvgunsonukapanis.setText(String.valueOf(doviz.getYesterdayClosingBuyPrice()));
        tvgunlukdegisim.setText(String.valueOf(doviz.getDailyChange()));
        gunlukdegisimyüzde.setText("%"+String.valueOf(doviz.getDailyChangePercentage()));
        tvtarih.setText(doviz.getLastUpdateDate().toString());
        //chart veileri doldurma

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry((float) doviz.getBuyPrice(),0));
        entries.add(new BarEntry((float) doviz.getSellPrice(),1));
        entries.add(new BarEntry((float) doviz.getTodayLowestBuyPrice(),2));
        entries.add(new BarEntry((float) doviz.getTodayHighestBuyPrice(),3));
        entries.add(new BarEntry((float) doviz.getTodayLowestSellPrice(),4));
        entries.add(new BarEntry((float) doviz.getTodayHighestSellPrice(),5));
        entries.add(new BarEntry((float) doviz.getYesterdayClosingSellPrice(),6));
        entries.add(new BarEntry((float) doviz.getYesterdayClosingBuyPrice(),7));

        BarDataSet barDataSet=new BarDataSet(entries,"Cells");

        ArrayList<String> labels=new ArrayList<>();
        labels.add("1");
        labels.add("2");
        labels.add("3");
        labels.add("4");
        labels.add("5");
        labels.add("6");
        labels.add("7");
        labels.add("8");

        BarData barData=new BarData(labels,barDataSet);
        barChart.setData(barData);
        barChart.setDescription("Tarih/Saat: "+doviz.getLastUpdateDate());
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(2000);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
