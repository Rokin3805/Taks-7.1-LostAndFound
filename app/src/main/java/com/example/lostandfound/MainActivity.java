package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button adButton;
    Button listButton;
    Intent goToAdPage;

    Intent goToDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adButton = findViewById(R.id.adButton);
        listButton = findViewById(R.id.listButton);

        //intent to go to AdPost class
        goToAdPage = new Intent(this, AdPost.class);
        goToDB = new Intent(this, ShowDB.class);

    }

    public void goToPost(View view) {
        startActivity(goToAdPage);
    }

    public void goToList(View view) {
        startActivity(goToDB);

    }
}