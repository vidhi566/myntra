package com.example.mynthree;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static int version=1;
    public static String DBname = "mydatabase.db";

    public DbHelper(@Nullable Context context) {
        super(context, DBname, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCT (P_ID INTEGER PRIMARY KEY AUTOINCREMENT, P_NAME TEXT , PRICE INTEGER , MIN_PRICE INTEGER , IMAGE INTEGER); ");
        db.execSQL("CREATE TABLE CUSTOMER (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , PHONE_NO TEXT , ORDERS INTEGER); ");
    }

    public void insertProdut(Product p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("P_NAME" , p.getName());
        value.put("PRICE" , p.getPrice());
        value.put("MIN_PRICE" , p.getMin_price());
        value.put("IMAGE" , p.getImage());
        db.insert("PRODUCT" ,null,value);
        db.close();
    }

    public void insertCustomer(Customer c){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("NAME" , c.getName());
        value.put("PHONE_NO" , c.getNumber());
        value.put("ORDERS" , c.getOrder_count());
        db.insert("CUSTOMER" ,null,value);
        db.close();
    }

    public void updateCustomer(Customer c){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("ORDERS" , c.getOrder_count()+1);
        db.update("CUSTOMER",value,null,null);
        db.close();
    }

    @SuppressLint("Range")
    public Customer getCustomer(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CUSTOMER;",null);

        if(cursor.moveToFirst()){
            Customer c = new Customer();
            c.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            c.setName(cursor.getString(cursor.getColumnIndex("NAME")));
            c.setNumber(cursor.getString(cursor.getColumnIndex("PHONE_NO")));
            c.setOrder_count(cursor.getInt(cursor.getColumnIndex("ORDERS")));
            return c;
        }

        return null;
    }

    @SuppressLint("Range")
    public Product fetchProductData(int ID){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE P_ID ='" +ID+ "';",null);


        if(cursor.moveToFirst()){
            Product p = new Product();
            p.setId(ID);
            p.setImage(cursor.getLong(cursor.getColumnIndex("IMAGE")));
            p.setName(cursor.getString(cursor.getColumnIndex("P_NAME")));
            p.setPrice(cursor.getInt(cursor.getColumnIndex("PRICE")));
            p.setMin_price(cursor.getInt(cursor.getColumnIndex("MIN_PRICE")));
            return p;
        }

        return null;
    }

    @SuppressLint("Range")
    public int getOrderCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CUSTOMER ",null);


        if(cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex("ORDERS"));
        }

        return 0;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS PRODUCT");
        db.execSQL("DROP TABLE IF EXISTS CUSTOMER");
        onCreate(db);
    }

    public ArrayList<Product> getproductlist(){
        ArrayList<Product> productlist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PRODUCT ",null);
        if(cursor.moveToFirst()){
            do{
                Product p1 = new Product();
                p1.id=cursor.getInt(0);
                p1.name = cursor.getString(1);
                p1.price = cursor.getInt(2);
                p1.min_price=cursor.getInt(3);
                p1.image=cursor.getInt(4);
                productlist.add(p1);
            }
            while(cursor.moveToNext());
        }
        return productlist;
    }

}
