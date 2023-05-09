package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lostandfound.data.DatabaseHelper;
import com.example.lostandfound.model.Item;

public class AdPost extends AppCompatActivity {

    DatabaseHelper db;

    RadioGroup radioGroup;
    RadioButton isLost;
    RadioButton isFound;

    Intent goToMain;

    EditText name;
    EditText phoneNum;
    EditText description;
    EditText date;
    EditText location;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_post);

        db = new DatabaseHelper(this);
        radioGroup = findViewById(R.id.radioButtons);
        isLost = radioGroup.findViewById(R.id.radioLost);
        isFound =  radioGroup.findViewById(R.id.radioFound);
        //default state for is lost is true
        isLost.setChecked(true);
        name = findViewById(R.id.nameEntry);
        phoneNum = findViewById(R.id.phoneEntry);
        description = findViewById(R.id.descriptionEntry);
        date = findViewById(R.id.dateEntry);
        location = findViewById(R.id.locationEntry);
        submit = findViewById(R.id.submitButton);


        //intent to go back to MainActivity
        goToMain = new Intent(this, MainActivity.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String postType;
                String descriptionStr;
                //if isLost is checked, assign value "Lost", else assign "Found". Concat post type to start of description for display purposes
                if (isLost.isChecked()) {
                    postType = "Lost";
                    descriptionStr = postType + " " + description.getText().toString().trim();
                }
                else
                {
                    postType = "Found";
                    descriptionStr = postType + " " + description.getText().toString().trim();
                }
                //all other strings received in standard fashion
                String poster = name.getText().toString().trim();
                String phoneNo = phoneNum.getText().toString().trim();
                String dateStr = date.getText().toString().trim();
                String locationStr = location.getText().toString().trim();

                //most basic input validation to ensure empty fields are not passed
                if (poster.equals("") || phoneNo.equals("") || descriptionStr.equals("") || dateStr.equals("") || locationStr.equals("")) {
                    Toast.makeText(AdPost.this, "Fill all input fields", Toast.LENGTH_LONG).show();
                } else
                {
                    //create a new Item object with input values
                    Item item = new Item(postType, poster, phoneNo, descriptionStr, dateStr, locationStr);

                    //insert the new item into the database
                    long result = db.insertItem(item);

                    //check if the item was successfully inserted into the database, toast user with result, return to main if added
                    if (result != -1) {
                        Toast.makeText(AdPost.this, "Item successfully added", Toast.LENGTH_SHORT).show();
                        startActivity(goToMain);
                        //remove current activity from backStack
                        finish();
                    }
                    else
                    {
                        Toast.makeText(AdPost.this, "Failed to post item", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }
}