package systemsonweb.com.planner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class Schedule extends AppCompatActivity {

    TextView textView;
    String stringg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        textView = findViewById(R.id.tv);

        stringg=getIntent().getExtras().getString("Queue");
        if(textView==null) {
            textView.setText(stringg);
        }else {
            textView.setText(textView.getText()+"\n"+stringg);
        }
    }
}
