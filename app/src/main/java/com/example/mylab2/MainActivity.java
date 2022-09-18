package com.example.mylab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

enum CountDropdownOption {
    Words,
    Characters
}

public class MainActivity extends AppCompatActivity {

    EditText textInput;
    Spinner countingModeDropdown;
    TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textInput = findViewById(R.id.textInput);
        this.resultsTextView = findViewById(R.id.resultsTextView);
        this.initCountingModeDropdown();
    }

    public void onCountBtnClick(View view) {

        int count = 0;
        String text = this.textInput.getText().toString();

        if (text.isEmpty()) {
            Util.showToast("Empty input!", getApplicationContext());
            return;
        }

        if (this.countingModeDropdown.getSelectedItem() == CountDropdownOption.Words.toString()) {
            count = Util.countWords(text);
        }
        else {
            count = Util.countChars(text);
        }

        this.resultsTextView.setText(String.valueOf(count));
    }

    private void initCountingModeDropdown() {
        this.countingModeDropdown = findViewById(R.id.countingModeDropdown);

        String[] arraySpinner = new String[] {
                CountDropdownOption.Words.name(), CountDropdownOption.Characters.name()
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countingModeDropdown.setAdapter(adapter);
    }


}