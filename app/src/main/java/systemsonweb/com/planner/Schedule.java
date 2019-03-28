package systemsonweb.com.planner;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Schedule extends AppCompatActivity {

    private ListView listView;
    private static final String TAG = "Schedule";
    EventDbHelper databaseHelper;
    String stringg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        listView = findViewById(R.id.lv);
        databaseHelper = new EventDbHelper(this);

        populateList();

//        stringg=getIntent().getExtras().getString("Queue");
//        if(textView==null) {
//            textView.setText(stringg);
//        }else {
//            textView.setText(textView.getText()+"\n"+stringg);
//        }
    }

    private void populateList() {
        Log.d(TAG,"populateList: Displaying data in the listview");
        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(0));
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                Log.e(TAG,"You clicked on "+name);
            }
        });
    }
}
