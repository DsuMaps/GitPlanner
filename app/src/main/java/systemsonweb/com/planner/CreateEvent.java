package systemsonweb.com.planner;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CreateEvent extends AppCompatActivity {

    DatabaseHelper mDatabase;
    private static final String TAG = "CreateEvent";
    String sched;
    Button submit;
    TextView eventname,duedate,hours,sessions;
    Queue<String> qe=new LinkedList<>();
    Context context = this;
    EventDbHelper eventDbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        eventname= findViewById(R.id.eventname);
        duedate= findViewById(R.id.duedate);
        hours= findViewById(R.id.hours);
        sessions= findViewById(R.id.sessions);
        submit= findViewById(R.id.submitEvent);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(CreateEvent.this,setSched(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(CreateEvent.this,Schedule.class);
                addEvent(v);
//                qe.add(setSched());
//                Iterator iterator = qe.iterator();
//                while(iterator.hasNext()){
//                    String element = (String) iterator.next();
//                    i.putExtra("Queue",element);
                    startActivity(i);
//                //    finish();
//                }
//                String item1 = eventname.getText().toString();
//                String item2 = duedate.getText().toString();
//                String item3 = hours.getText().toString();
//                String item4 = sessions.getText().toString();
//                if(eventname.length()!=0 && duedate.length()!=0 && hours.length()!=0 && sessions.length()!=0){
//                    AddData(item1,item2,item3,item4);
//                    eventname.setText("");
//                    duedate.setText("");
//                    hours.setText("");
//                    sessions.setText("");
//                    startActivity(i);
//                }else{
//                    toastMessage("Fill in ALL text fields");
//                    Log.d(TAG, "Fill in All fields");
//                }


            }
        });


    }

//    public void AddData(String item1,String item2,String item3,String item4){
//        boolean insertData = mDatabase.addData(item1,item2,item3,item4);
//        if(insertData){
//            toastMessage("Data Successful");
//        }else{
//            toastMessage("Something wrong");
//        }
//    }
    public void addEvent(View v) {
        String item1 = eventname.getText().toString();
        String item2 = duedate.getText().toString();
        String item3 = hours.getText().toString();
        String item4 = sessions.getText().toString();
        eventDbHelper = new EventDbHelper(context);
        sqLiteDatabase = eventDbHelper.getWritableDatabase();
        eventDbHelper.addInfo(item1,item2,item3,item4,sqLiteDatabase);
        Toast.makeText(getBaseContext(), "one row data saved",Toast.LENGTH_LONG).show();
        eventDbHelper.close();
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public String setSched() {
        sched = "Event Name: "+eventname.getText().toString()+"\nDue Date: "+duedate.getText().toString()+"\nHours: "+hours.getText().toString()+"\nSessions: "+sessions.getText().toString();
        return sched;
    }
}
