package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private TextView textViewGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textViewGreeting = findViewById(R.id.textViewGreeting);
        Button buttonOpenSecondActivity = findViewById(R.id.buttonOpenSecondActivity);

        buttonOpenSecondActivity.setOnClickListener(v -> {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("greeting", "Привет!"); // передаем приветствие
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String greeting = "Привет, " + name + "!";
            textViewGreeting.setText(greeting);
        }
    }
}