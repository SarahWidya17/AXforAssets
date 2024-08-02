package com.example.axforasset;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView termsText;
    private Button tabTerms, tabConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        termsText = findViewById(R.id.terms_text);
        tabTerms = findViewById(R.id.tab_terms);
        tabConditions = findViewById(R.id.tab_conditions);

        tabTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsText.setText("Terms content goes here.");
            }
        });

        tabConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsText.setText("Condition content goes here.");
            }
        });
    }
}
