package com.example.enefte.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class NftFavDB extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "CoffeeDB";
    private static String TABLE_NAME = "FavNftTable";
    public static String NFT_ID = "id";
    public static String NFT_NAME = "nftName";
    public static  String NFT_ARTIST = "nftArtist";
    public static String NFT_CATEGORY = "nftCategory";
    public static String NFT_IMAGE = "nftImage";
    public static String NFT_FAVOURITE_STATUS = "nftFavStatus";

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + NFT_ID + " TEXT," + NFT_NAME + " TEXT,"
            + NFT_ARTIST + " TEXT," + NFT_CATEGORY + " TEXT,"
            + NFT_IMAGE + " TEXT," + NFT_FAVOURITE_STATUS +" TEXT)";


    public NftFavDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // create empty table
    public void insertEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // enter your value
        for (int x = 1; x < 11; x++) {
            cv.put(NFT_ID, x);
            cv.put(NFT_FAVOURITE_STATUS, "0");

            db.insert(TABLE_NAME,null, cv);
        }
    }

    // insert data into database
    public void insertIntoTheDatabase(String nftName, String nftArtist, String nftCategory, String id, int nftImage, String favStatus) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NFT_NAME, nftName);
        cv.put(NFT_ARTIST, nftArtist);
        cv.put(NFT_CATEGORY, nftCategory);
        cv.put(NFT_CATEGORY, nftCategory);
        cv.put(NFT_ID, id);
        cv.put(NFT_IMAGE, nftImage);
        cv.put(NFT_FAVOURITE_STATUS, favStatus);
        db.insert(TABLE_NAME,null, cv);
        Log.d("FavDB Status", nftName + ", favstatus - "+favStatus+" - . " + cv);
    }

    // read all data
    public Cursor read_all_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + NFT_ID+"="+id+"";
        return db.rawQuery(sql,null,null);
    }

    // remove line from database
    public void remove_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  "+ NFT_FAVOURITE_STATUS+" ='0' WHERE "+NFT_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());

    }

    // select all favorite list

    public Cursor select_all_favorite_list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+NFT_FAVOURITE_STATUS+" ='1'";
        return db.rawQuery(sql,null,null);
    }
}
