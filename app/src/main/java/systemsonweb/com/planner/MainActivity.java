package systemsonweb.com.planner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("************************* 5");

        setContentView(R.layout.activity_main);
 //       setContentView(R.layout.activity_login);

        System.out.println("************************* 6");

        login = findViewById(R.id.login);
        System.out.println("************************* 7");
        signup = findViewById(R.id.signup);
        System.out.println("************************* 8");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),Login.class);
                startActivityForResult(myIntent, 0);

            }
        });
        System.out.println("************************* 2");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(v.getContext(),ComingSoon.class);
                startActivityForResult(myIntent2, 0);


            }
        });
        System.out.println("************************* 3");

    }


}
