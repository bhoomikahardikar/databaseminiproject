package com.example.databaseminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class iActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Id, UserName, Phone_number, UserAge;
    Button insertionbtn;
    DBHELP db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iactivity);

        Id = findViewById(R.id.id);
        UserName = findViewById(R.id.name);
        Phone_number = findViewById(R.id.phno);
        UserAge = findViewById(R.id.age);

        db = new DBHELP(this);

        insertionbtn = findViewById(R.id.button_insert);
        insertionbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String id = Id.getText().toString();
            String name = UserName.getText().toString();
            String Phno = Phone_number.getText().toString();
            String age = UserAge.getText().toString();
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setUPhone(Phno);
            user.setAge(age);
            db.insertdata(user);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        } catch (Exception E) {
            Toast.makeText(this, "Error in Entering Data", Toast.LENGTH_SHORT).show();
        }
    }
}