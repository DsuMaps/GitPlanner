package systemsonweb.com.planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final  String TAG ="DatabaseHelper";
    private static final String TABLE_NAME= "event_info";
    private static final String COL="ID";
    private static final String COL1="name";
    private static final String COL2="date";
    private static final String COL3="hours";
    private static final String COL4="sessions";
    public DatabaseHelper(Context context) {
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL1 +" TEXT," + COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item1,String item2,String item3,String item4){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        ContentValues contentValues2 = new ContentValues();
        ContentValues contentValues3 = new ContentValues();
        ContentValues contentValues4 = new ContentValues();
        contentValues1.put(COL1,item1);
        contentValues2.put(COL2,item2);
        contentValues3.put(COL3,item3);
        contentValues4.put(COL4,item4);

        Log.d(TAG, "addData: Adding "+ item1 +", "+ item2 +", "+ item3 +", "+ item4 + " to "+ TABLE_NAME);
        long result1 = db.insert(TABLE_NAME,null,contentValues1);
        long result2 = db.insert(TABLE_NAME,null,contentValues2);
        long result3 = db.insert(TABLE_NAME,null,contentValues3);
        long result4 = db.insert(TABLE_NAME,null,contentValues4);
        if(result1!=-1 && result2!=-1 && result3!=-1 && result4!=-1){
            return true;
        }else {
            return false;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
