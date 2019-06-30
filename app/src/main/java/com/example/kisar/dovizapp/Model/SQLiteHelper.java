package com.example.kisar.dovizapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kisar on 29.06.2019.
 */



public class SQLiteHelper extends SQLiteOpenHelper {
    //Db bilgileri
    private static final String VERITABANI="urundb";
    private static final int VERSION=3;
    private static final String TABLOADI="portfoy";
    //Tablo bilgileri
    private static final String ID="id";
    private static final String CODE="code";
    private static final String NAME="name";



    public SQLiteHelper(Context context) {
        super(context, VERITABANI, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabloOlustur="CREATE TABLE "+TABLOADI+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                CODE+" TEXT, "+NAME+" TEXT);";
        db.execSQL(tabloOlustur);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLOADI);
        onCreate(db);
    }
    public long Kayit(Doviz doviz){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(CODE,doviz.getCode());
        cv.put(NAME,doviz.getName());
        long id=db.insert(TABLOADI,null,cv);
        return id;
    }
    public List<Doviz> KayitList(){
        SQLiteDatabase db=this.getWritableDatabase();
        String[] kolonlar={ID,CODE,NAME};
        Cursor c=db.query(TABLOADI,kolonlar,null,null,null,null,null);
        int indexOfId=c.getColumnIndex(ID);
        int indexOfCode=c.getColumnIndex(CODE);
        int indexOfName=c.getColumnIndex(NAME);
        List<Doviz> dovizList=new ArrayList<>();
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            Doviz doviz=new Doviz();
            doviz.setCode(c.getString(indexOfCode));
            doviz.setName(c.getString(indexOfName));
            doviz.setLastUpdateDate("");
            doviz.setBuyPrice(0);
            doviz.setDailyChangePercentage(0);
            //hepsi Dolacak mı?
            dovizList.add(doviz);
        }
        return dovizList;
    }
    public long KayitSil(String code){

        SQLiteDatabase db=this.getWritableDatabase();
        long silinenUrunId= db.delete(TABLOADI,CODE+"='"+code+"'",null);
        db.close();
        return silinenUrunId;
    }
}
