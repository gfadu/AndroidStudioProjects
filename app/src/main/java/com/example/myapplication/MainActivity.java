package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import java.time.Year;
import java.util.Calendar;

//hi
public class MainActivity extends AppCompatActivity {

    EditText Day ;
    EditText Month ;
    EditText Year;

    public void Valentine(View view) {

        Calendar calendar = Calendar.getInstance();
        int c_year = calendar.get(Calendar.YEAR);
        int c_month = calendar.get(Calendar.MONTH);
        int c_day = calendar.get(Calendar.DATE);
        c_month = c_month + 1;
        try {
            Day = findViewById(R.id.Day);
            Month = findViewById(R.id.Month);
            Year = findViewById(R.id.Year);
            EditText D_month = findViewById(R.id.D_month);
            EditText D_day = findViewById(R.id.D_day);
            EditText D_hour = findViewById(R.id.D_hour);
            EditText D_min = findViewById(R.id.D_min);
            //Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show();

            String V_day = Day.getText().toString();
            int vi_day = Integer.parseInt(V_day);


            String V_year = Year.getText().toString();
            int vi_year = Integer.parseInt(V_year);


        String V_Month = Month.getText().toString();
        int Vi_month = Integer.parseInt(V_Month);

        int Vi_day = Integer.parseInt(V_day);

            if(vi_day>31){
                Toast.makeText(this, "No month has more than 31 days", Toast.LENGTH_LONG).show();
                rollback();}
            else if(Vi_month>12){
                Toast.makeText(this, "No year has more than 12 months", Toast.LENGTH_LONG).show();
                rollback();}
            else if(Vi_month==2 && vi_day>28 ){
                Toast.makeText(this, "February has 28 days", Toast.LENGTH_LONG).show();
                rollback();}
            else if (vi_year > c_year ){
                Toast.makeText(this, "You cannot go to the future", Toast.LENGTH_LONG).show();
                rollback();}
                else if(vi_day<=0 || Vi_month<=0 || vi_year<=0) {
                Toast.makeText(this, "Calender does not have negetive numbers", Toast.LENGTH_LONG).show();
                rollback();
            }

         else {
                int d_year = c_year - vi_year;
                int d_month = d_year * 12;
                if (Vi_month > c_month) {
                    d_month = d_month - (Vi_month - c_month);
                } else {
                    d_month = d_month + (Vi_month - c_month);
                }
                int d_month1 = Math.abs(d_month);
                int d_day;
                if (vi_day > c_day) {
                    d_day = (vi_day - c_day);
                } else {
                    d_day = (c_day - vi_day);
                }

                double d_hour = d_day * 24;
                double d_min = d_hour * 60;
                String temp2 = String.valueOf(d_day);
                String temp3 = String.valueOf(d_hour);
                String temp4 = String.valueOf(d_min);
                D_month.setVisibility(View.VISIBLE);
                D_day.setVisibility(View.VISIBLE);
                D_hour.setVisibility(View.VISIBLE);
                D_min.setVisibility(View.VISIBLE);
                String temp1 = Integer.toString(d_month1);
                D_month.setText(String.format("%s month", temp1));
                D_day.setText(String.format("%s day", temp2));
                D_hour.setText(String.format("%s hour", temp3));
                D_min.setText(String.format("%s min", temp4));
        }

    }
    catch (Exception e)
        {
            //Toast.makeText(this, "Enter fields correctly", Toast.LENGTH_LONG).show();
            Year.setError("Field cannot be blank");
            Day.setError("Field cannot be blank");
            Month.setError("Field cannot be blank");
        }

}

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void rollback()
        {
            Day.setText("");
         Month.setText("");
        Year.setText("");
    }
    }
