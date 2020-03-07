package com.codepath.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ((EditText)findViewById(R.id.editQuestion)).setText(getIntent().getStringExtra("question"));
        ((EditText)findViewById(R.id.editAnswer)).setText(getIntent().getStringExtra("answer"));

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((EditText)findViewById(R.id.editQuestion)).getText().toString().equals("") || ((EditText)findViewById(R.id.editAnswer)).getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Must enter both question and answer", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Intent data = new Intent();
                    data.putExtra("question", ((EditText)findViewById(R.id.editQuestion)).getText().toString());
                    data.putExtra("answer", ((EditText)findViewById(R.id.editAnswer)).getText().toString());
                    setResult(RESULT_OK, data);
                    finish();
                }
            }
        });
    }
}
