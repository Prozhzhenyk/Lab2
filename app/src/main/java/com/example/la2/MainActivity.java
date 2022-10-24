package com.example.la2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.la2.utils.TextCounter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Word/s counter");
        arrayList.add("Char/s counter");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        this.button = findViewById(R.id.Button);
        this.editText = findViewById(R.id.editText);
        this.textView = findViewById(R.id.textView);
    }


    public void onBtnClick(View view) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Line is empty!", Toast.LENGTH_SHORT).show();
        } else {
            if (spinner.getSelectedItem().toString().equals("Word/s counter")) {
                String phrase = this.editText.getText().toString();
                int charsCounter = TextCounter.getWordsCount(phrase);
                String fromattedResult = String.valueOf(charsCounter);
                this.textView.setText(fromattedResult);
            }
            else {
                String phrase = this.editText.getText().toString();
                int wordsCount = TextCounter.getCharsCount(phrase);
                String fromattedResult = String.valueOf(wordsCount);
                this.textView.setText(fromattedResult);
            }
        }
    }
}

