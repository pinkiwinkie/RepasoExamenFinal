package com.example.repasoexamenfinal;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        ActivityResultLauncher<Intent> someActivityLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {

                        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String name = editText.getText().toString();
                intent.putExtra("name", name);
                someActivityLauncher.launch(intent);
            }
        });
    }
}