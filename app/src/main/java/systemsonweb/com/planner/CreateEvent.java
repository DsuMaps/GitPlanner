package systemsonweb.com.planner;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CreateEvent extends AppCompatActivity {

    String sched;
    Button submit;
    TextView eventname,duedate,hours,sessions;
    Queue<String> qe=new LinkedList<>();


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
                Toast.makeText(CreateEvent.this,setSched(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(CreateEvent.this,Schedule.class);
                qe.add(setSched());
                Iterator iterator = qe.iterator();
                while(iterator.hasNext()){
                    String element = (String) iterator.next();
                    i.putExtra("Queue",element);
                    startActivity(i);
                    finish();
                }


            }
        });


    }

    public String setSched() {
        sched = "Event Name: "+eventname.getText().toString()+"\nDue Date: "+duedate.getText().toString()+"\nHours: "+hours.getText().toString()+"\nSessions: "+sessions.getText().toString();
        return sched;
    }
}
