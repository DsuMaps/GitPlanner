package systemsonweb.com.planner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class Schedule extends AppCompatActivity {

    Queue<String> qe=new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        CreateEvent createEvent = new CreateEvent();
        if(qe.isEmpty()){
            Toast.makeText(this,createEvent.sched,Toast.LENGTH_LONG).show();
        }
        qe.add(createEvent.setSched());
        for(int i=0;i<qe.size();i++){
            LinearLayout layout = findViewById(R.id.schedlayout);
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            btn.setText(qe.poll());
            layout.addView(btn);

        }
    }
}
