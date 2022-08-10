package com.example.databaseminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dActivity extends AppCompatActivity implements View.OnClickListener {
    EditText deleteUser;
    Button Deletingbtn;
    DBHELP db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dactivity);
        deleteUser = findViewById(R.id.DeleteUser);
        Deletingbtn = findViewById(R.id.deletingbtn);

        db = new DBHELP(this);
        Deletingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String name = deleteUser.getText().toString();
            User user = new User();
            user.setName(name);
            db.deletedata(user);
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        } catch (Exception E) {
            Toast.makeText(this, "Error in Deleting Data", Toast.LENGTH_SHORT).show();
        }
    }
}