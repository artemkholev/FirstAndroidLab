package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private TextView message;
    private ActivityResultLauncher<Intent> activity;
    String messageHello = "Привет";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        message = findViewById(R.id.messageView);
        Button openSecondActivityButton = findViewById(R.id.buttonOpenSecondActivity);

        openSecondActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("message", messageHello);
            activity.launch(intent);
        });

        activity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String name = data.getStringExtra("name");
                        String greeting = "Сообщение - " + messageHello + " " + name;
                        message.setText(greeting);
                    }
                }
            });
    }
}