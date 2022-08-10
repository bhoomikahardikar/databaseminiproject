package com.example.databaseminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class uActivity extends AppCompatActivity implements View.OnClickListener {
    EditText UpdateUsername, updatePhno, UpdateAge;
    Button Updatingbtn;
    DBHELP db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uactivity);
        UpdateUsername = findViewById(R.id.updateuname);
        updatePhno = findViewById(R.id.updatePhno);
        UpdateAge = findViewById(R.id.updateage);

        db = new DBHELP(this);

        Updatingbtn = findViewById(R.id.Updatingbtn);
        Updatingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String name = UpdateUsername.getText().toString();
            String Phno = updatePhno.getText().toString();
            String age = UpdateAge.getText().toString();
            User user = new User();
            user.setName(name);
            user.setAge(age);
            user.setUPhone(Phno);
            db.updatedata(user);
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        } catch (Exception E) {
            Toast.makeText(this, "Error in Updating Data", Toast.LENGTH_SHORT).show();
        }
    }
}