package com.example.databaseminiproject;

import android.database.Cursor;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class vActivity extends AppCompatActivity implements View.OnClickListener{

    TextView DataView;
    DBHELP db = new DBHELP(this);
    Button buttonView;
    StringBuilder sb = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vactivity);
        DataView = findViewById(R.id.DataView);
        buttonView = findViewById(R.id.buttonView);
        buttonView.setOnClickListener(this);

        Cursor cursor = db.getdata();

        while (cursor.moveToNext()) {
            sb.append("Id:" + cursor.getString(0)+"\n");
            sb.append("UserName:" + cursor.getString(1)+"\n");
            sb.append("PhoneNumber:" + cursor.getString(2)+"\n");
            sb.append("UserAge :" + cursor.getString(3)+"\n\n");

        }

        DataView.setMovementMethod(new ScrollingMovementMethod());
    }


    @Override
    public void onClick(View view) {
        if(view.equals(buttonView))
            DataView.setText(sb);
    }
}
