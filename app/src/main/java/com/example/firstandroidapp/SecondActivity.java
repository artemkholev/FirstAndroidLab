package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView message = findViewById(R.id.message);
        editName = findViewById(R.id.input);
        Button submitButton = findViewById(R.id.buttonCloseSecondActivity);

        String greeting = getIntent().getStringExtra("message");
        message.setText(greeting);

        submitButton.setOnClickListener(v -> {
            String name = editName.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}