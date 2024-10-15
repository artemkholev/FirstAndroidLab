package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewGreeting = findViewById(R.id.textViewGreeting);
        editTextName = findViewById(R.id.editTextName);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        // Получаем приветствие из первой активити
        Intent intent = getIntent();
        String greeting = intent.getStringExtra("greeting");
        textViewGreeting.setText(greeting);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();

            // Передаем результат обратно в первую активити
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            setResult(RESULT_OK, resultIntent);
            finish(); // Закрываем текущую активити
        });
    }
}