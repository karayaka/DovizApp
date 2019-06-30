package com.example.kisar.dovizapp.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.kisar.dovizapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper extends AsyncTask<String,Integer,List<Doviz>> {
//Kaynak: http://instinctcoder.com/android-studio-asynctask-return-value-to-caller/;
    private Context context;
    ProgressDialog dialog;
    private TaskComplated mCallback;

    public JsonHelper(Context context) {
        this.context = context;
        this.mCallback=(TaskComplated)context;
    }

    @Override
    protected void onPreExecute() {
        dialog=new ProgressDialog(context);
        dialog.setTitle(R.string.dialogBaslik);
        dialog.setMessage("Lütfen Bekleyin");
        dialog.show();
    }

    @Override
    protected List<Doviz> doInBackground(String... params) {
        try {
            StringBuilder sb = new StringBuilder();
            URL uri = null;
            uri = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String inputLine;
            while ((inputLine = bin.readLine()) != null) {
               // Thread.sleep(3000);
                sb.append(inputLine);
            }
            Gson gson=new Gson();
            Type DovizModelTyp = new TypeToken<ArrayList<Doviz>>(){}.getType();
            List<Doviz> dovizList = gson.fromJson(sb.toString(), DovizModelTyp);

            return dovizList;

        } catch (MalformedURLException e) {

            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } /*catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }*/catch (Exception e){
            Log.e("Hata2",e.getMessage());
            return null;
        }


    }
    @Override
    protected void onPostExecute(List<Doviz> s) {
        mCallback.onTaskCoplated(s);
        dialog.dismiss();
        //Log.e("HATA",dovizList.get(0).getName().toString());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
