package edu.kiet.www.mysqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    Context context;
    final static public String dbname="MyDB";
    final  static public int version=1;
    final static public String table_name="Student";
    final static public String col_1="roll";
    final static public String col_2="name";
    final static public String col_3="branch";
    final static public String query="create table "+table_name+" ( "+col_1+" integer, "+col_2+" text, "+col_3+" text)";
    public MyDatabaseHelper(Context context) {
        super(context, dbname, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+table_name);
        onCreate(db);
    }
    public long insertRecord(int roll, String name, String branch)
    {
        ContentValues cv =new ContentValues();
        cv.put(col_1,roll);
        cv.put(col_2,name);
        cv.put(col_3,branch);
        SQLiteDatabase db = this.getWritableDatabase();
       long check= db.insert(table_name,null,cv);
       return check;
    }
    public Cursor getDisplay()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from "+table_name,null);
        return  cursor;
    }
    public long updateRecord(int roll, String name, String branch)
    {
        ContentValues cv =new ContentValues();
        cv.put(col_1,roll);
        cv.put(col_2,name);
        cv.put(col_3,branch);
        SQLiteDatabase db = this.getWritableDatabase();
        long check=db.update(table_name,cv,col_1+"=?",new String[]{""+roll});
        return check;
    }
    public long deleteRecord(int roll)
    {
        SQLiteDatabase db = this.getWritableDatabase();
       long check= db.delete(table_name,col_1+"=?",new String[]{""+roll});
       return check;
    }
}
