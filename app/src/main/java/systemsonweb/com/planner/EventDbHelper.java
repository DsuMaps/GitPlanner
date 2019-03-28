package systemsonweb.com.planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EventDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EVENTINFO.DB";
    private static final int DATABASE_VER =1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+UserContract.NewEventInfo.TABLE_NAME+"("+UserContract.NewEventInfo.EVENT_NAME+" TEXT,"+
                    UserContract.NewEventInfo.DUE_DATE+" TEXT,"+UserContract.NewEventInfo.HOURS+" TEXT,"+
                    UserContract.NewEventInfo.SESSIONS+" TEXT)";
    public EventDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VER);
        Log.e("DATABASE OPERATIONS","Database Created...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table Created...");

    }
    public void addInfo(String name,String date,String hours, String sessions,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewEventInfo.EVENT_NAME,name);
        contentValues.put(UserContract.NewEventInfo.DUE_DATE,date);
        contentValues.put(UserContract.NewEventInfo.HOURS,hours);
        contentValues.put(UserContract.NewEventInfo.SESSIONS,sessions);
        db.insert(UserContract.NewEventInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One row inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + UserContract.NewEventInfo.TABLE_NAME, null);
        return data;
    }
    
}
