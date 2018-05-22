package com.example.a16022635.taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> al;
    ArrayAdapter aa;
    ListView lv;
    Button btnAddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = (Button) this.findViewById(R.id.btnAddTask);
        lv = (ListView) this.findViewById(R.id.lv);
        al = new ArrayList<Task>();

        DBHelper db = new DBHelper(MainActivity.this);
        al.clear();
        al.addAll(db.getAllTasks());

        aa = new TasksArrayAdapter(MainActivity.this, R.layout.activity_row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToAddActivity = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(moveToAddActivity, 9);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            lv = (ListView)findViewById(R.id.lv);
            al = new ArrayList<Task>();
            DBHelper dbh = new DBHelper(MainActivity.this);
            al.clear();
            al.addAll(dbh.getAllTasks());
            dbh.close();
            aa = new TasksArrayAdapter(this, R.layout.activity_row, al);

            lv.setAdapter(aa);
        }
    }
}
