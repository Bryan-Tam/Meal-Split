// Bryan Tam Meal Splitter
package com.example.bryantam.splitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText total;
    EditText people;
    TextView cost;

    Button split;


    @Override   //like interrupt
    protected void onCreate(Bundle savedInstanceState) {
       /*
          Remove Title Bar (kinda doesnt work)
        */
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        /*
          Remove notification bar
        */
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //this.setContentView(R.layout.activity_main);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
          store widgets into objects
          not sure why "R"
        */
        total = findViewById(R.id.editText_totalprice);
        people = findViewById(R.id.editText_people);
        cost = findViewById(R.id.textView_cost);
        split = findViewById(R.id.button_split);

        cost.setText("$0");
        total.setText("0");
        people.setText("0");
    }


    // Button functionality
    // OnClick set in activity_main.xml, replaces OnClickListener (an interface)
    // xml OnClick limited to single argument function
    public void splitIt(View view){
        double total_price = Double.parseDouble(total.getText().toString());
        int numPeople = Integer.parseInt(people.getText().toString());

        DecimalFormat df = new DecimalFormat("###.##");
        String cost_per_person = df.format(total_price/numPeople);
        cost.setText("$" + cost_per_person);
    }
}
