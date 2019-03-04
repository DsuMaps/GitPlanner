package systemsonweb.com.planner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button create,schedule,events,connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        create = findViewById(R.id.createevent);
        schedule = findViewById(R.id.schedule);
        events=findViewById(R.id.events);
        connect = findViewById(R.id.connect);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),CreateEvent.class);
                startActivityForResult(myIntent, 0);

            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),Schedule.class);
                startActivityForResult(myIntent, 0);

            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),ComingSoon.class);
                startActivityForResult(myIntent, 0);

            }
        });

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),ComingSoon.class);
                startActivityForResult(myIntent, 0);

            }
        });
    }
}
