package com.example.kisar.dovizapp.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kisar.dovizapp.Model.Doviz;
import com.example.kisar.dovizapp.Model.SQLiteHelper;
import com.example.kisar.dovizapp.R;

import java.util.List;

/**
 * Created by kisar on 29.06.2019.
 */

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Doviz> dovizList;
    private int fragmentId;
    private Activity activity;

    public CustomAdapter(Activity activity, List<Doviz> dovizList, int fragmentId) {
        layoutInflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dovizList = dovizList;
        this.fragmentId = fragmentId;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return dovizList.size();
    }

    @Override
    public Object getItem(int position) {
        return dovizList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle(R.string.dialogUyarı);
        View v;
        if(convertView==null){
            v=layoutInflater.inflate(R.layout.custom_list_item,null);
        }else {
            v=convertView;
        }
        TextView tvcode= (TextView) v.findViewById(R.id.etcode);
        TextView tvisim= (TextView) v.findViewById(R.id.etisim);
        TextView tvfiyat= (TextView) v.findViewById(R.id.etfiyat);
        TextView tvdegsim= (TextView) v.findViewById(R.id.etdegisim);
        TextView tvtarih= (TextView) v.findViewById(R.id.ettarih);
        ImageButton btnislem= (ImageButton) v.findViewById(R.id.btnislem);


        final Doviz doviz=dovizList.get(position);
        String degisim="%"+doviz.getDailyChangePercentage();
        String fiyat=String.valueOf(doviz.getBuyPrice());
        if(degisim.length()>7){
            degisim=degisim.substring(0,6);
        }
        if(fiyat.length()>7){
            fiyat=fiyat.substring(0,6);
        }

        tvcode.setText(doviz.getCode().toString());
        tvisim.setText(doviz.getName().toString());
        tvdegsim.setText(degisim);
        tvfiyat.setText(fiyat);
        tvtarih.setText(doviz.getLastUpdateDate().toString());
        if(fragmentId==0){
            btnislem.setVisibility(View.INVISIBLE);

        }else if(fragmentId==3){
            btnislem.setImageResource(android.R.drawable.ic_delete);
            tvfiyat.setVisibility(View.INVISIBLE);
            tvtarih.setVisibility(View.INVISIBLE);
            tvdegsim.setVisibility(View.INVISIBLE);
            btnislem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.setMessage(R.string.dialogSil);
                    builder.setPositiveButton(R.string.dialogBtnTmm, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SQLiteHelper db=new SQLiteHelper(activity);
                            long id=db.KayitSil(doviz.getCode().toString());
                            if(id>0){
                                Toast.makeText(activity,R.string.toasSilmebasarili,Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.dialogBtnIptal, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });

        }else if(fragmentId==1){
            btnislem.setImageResource(android.R.drawable.ic_input_add);
            btnislem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.setMessage(R.string.dialogEkle);
                    builder.setPositiveButton(R.string.dialogBtnTmm, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SQLiteHelper db=new SQLiteHelper(activity);
                            long id= db.Kayit(doviz);
                            if(id>0){
                                Toast.makeText(activity,R.string.toasKayitBasarili,Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.dialogBtnIptal, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            });
        }
        return v;
    }
}
