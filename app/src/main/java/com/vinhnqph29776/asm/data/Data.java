package com.vinhnqph29776.asm.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vinhnqph29776.asm.object.ObjKC;
import com.vinhnqph29776.asm.object.ObjKT;
import com.vinhnqph29776.asm.object.ObjLC;
import com.vinhnqph29776.asm.object.ObjLT;

import java.util.ArrayList;
public class Data extends SQLiteOpenHelper {

    SQLiteDatabase db=this.getReadableDatabase();
    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE1 = "Khoanthu";
    private static final String TABLE2 = "Khoanchi";
    private static final String TABLE3 = "Loaithu";
    private static final String TABLE4 = "Loaichi";
    private static final String KEY_ID = "id";
    private static final String KEY_TYPE_ID = "uid";
    private static final String KEY_DATE = "ngay";//ngay thu or chi
    private static final String KEY_NAME = "ten";
    private static final String KEY_LOAI = "loai_thu";//ten khoan chi or thu
    private static final String KEY_PRICES = "giatien";
    private static final String KEY_NOTE = "ghichu";
    private static final String KEY_PER_NAME = "ten_nguoi";//ten nguoi thu or chi


    public Data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String khoanthu = "create table " + TABLE1 +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_TYPE_ID + " text , " +
                KEY_NAME + " text ," +
                KEY_DATE + " text ," +
                KEY_LOAI + " text ,"+
                KEY_PRICES + " text ,"+
                KEY_NOTE + " text ," +
                KEY_PER_NAME + " text " +
                ")";
db.execSQL(khoanthu);
        String khoanchi = "create table " + TABLE2 +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_TYPE_ID + " text  ," +
                KEY_NAME + " text ," +
                KEY_DATE + " text ," +
                KEY_LOAI + " text ,"+
                KEY_PRICES + " text ,"+
                KEY_NOTE + " text , "+
                KEY_PER_NAME + " text " +
                ")";
        db.execSQL(khoanchi);
        String loaithu = "create table " + TABLE3 +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME + " text " +
                ")";
        String loaichi = "create table " + TABLE4 +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME + " text " +
                ")";
        db.execSQL(loaichi);
        db.execSQL(loaithu);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE1);
        db.execSQL("drop table if exists " + TABLE2);
        db.execSQL("drop table if exists " + TABLE3);
        db.execSQL("drop table if exists " + TABLE4);
        onCreate(db);
    }
public void getDataSpinner(){

}

    public ArrayList<ObjLT> getAllLT() {
        Cursor cursor = db.rawQuery("select * from " + TABLE3, null);

        ArrayList<ObjLT> list = new ArrayList<>();
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new ObjLT(cursor.getInt(0),cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        return list;

    }

    public ArrayList<ObjLC> getAllLC() {

        Cursor cursor = db.rawQuery("select * from " + TABLE4, null);

        ArrayList<ObjLC> list = new ArrayList<>();
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new ObjLC(cursor.getString(1),cursor.getInt(0)));
            } while (cursor.moveToNext());
        }
        return list;

    }
    public ArrayList<ObjKC> getAllKC() {

        Cursor cursor = db.rawQuery("select * from " + TABLE2, null);

        ArrayList<ObjKC> list = new ArrayList<>();
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new ObjKC(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return list;

    }
    public ArrayList<ObjKT> getAllKT() {

        Cursor cursor = db.rawQuery("select * from " + TABLE1, null);

        ArrayList<ObjKT> list = new ArrayList<>();
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new ObjKT(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return list;

    }
public  void createKhoan(String id, String tenkhoan,String ngaythu,String loaithu,String sotien,String noidung,String hoten,String loai){
    ContentValues values = new ContentValues();
    values.put(KEY_TYPE_ID, id);
    values.put(KEY_NAME, tenkhoan);
    values.put(KEY_DATE, ngaythu);
    values.put(KEY_LOAI,loaithu);
    values.put(KEY_PRICES, sotien);
    values.put(KEY_NOTE, noidung);
    values.put(KEY_PER_NAME, hoten);
    if(loai=="khoanthu"){
      db.insert(TABLE1,null,values);
    }
    if(loai=="khoanchi"){
     db.insert(TABLE2,null,values);
    }

}

    public void createLoai(String ten,String loai) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, ten);
        if(loai=="loaithu"){
            db.insert(TABLE3, null, values);
        }
     if(loai=="loaichi"){
         db.insert(TABLE4, null, values);
     }

    }

    public void delete(int id,String loai)
    {
        if(loai=="loaithu"){
            db.delete(TABLE3, "id=?", new String[]{String.valueOf(id)});
        }
        if(loai=="loaichi"){
            db.delete(TABLE4,"id=?", new String[]{String.valueOf(id)});

        }
        if(loai=="khoanthu"){
            db.delete(TABLE1,"id=?", new String[]{String.valueOf(id)});

        }
        if(loai=="khoanchi"){
            db.delete(TABLE2,"id=?", new String[]{String.valueOf(id)});

        }

        }
    public void deleteLC(int id) {
        db.delete(TABLE2, "id=?", new String[]{String.valueOf(id)});
    }
    public void update(String name,String loai,int id) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        if(loai=="loaithu"){
            db.update(TABLE3, values, "id=?", new String[]{String.valueOf(id)});
        }
        if(loai=="loaichi"){
            db.update(TABLE4, values, "id=?", new String[]{String.valueOf(id)});
        }

    }
    public void updateKhoan(int id,String uid, String tenkhoan,String ngaythu,String loaithu,String sotien,String noidung,String hoten,String loai) {
        ContentValues values = new ContentValues();
        values.put(KEY_TYPE_ID, uid);
        values.put(KEY_NAME, tenkhoan);
        values.put(KEY_DATE, ngaythu);
        values.put(KEY_LOAI,loaithu);
        values.put(KEY_PRICES, sotien);
        values.put(KEY_NOTE, noidung);
        values.put(KEY_PER_NAME, hoten);
        if(loai=="khoanthu"){
            db.update(TABLE1,values, "id=?", new String[]{String.valueOf(id)});
        }
        if(loai=="khoanchi"){
            db.update(TABLE2,values, "id=?", new String[]{String.valueOf(id)});
        }

    }
    public long updateLoaichi(String name,Double tien,int id) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_NAME, name);
        values.put(KEY_PRICES, tien);
        return  db.update(TABLE2, values, "id=?", new String[]{String.valueOf(id)});
    }
    }



