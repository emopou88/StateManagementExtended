package com.example.statemanagementextended;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private StateViewModel stateViewModel;
    private LinearLayout layout;
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText editText;
    private CheckBox checkboxVisible;
    private TextView textVisible;
    private Switch colorSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        editText = findViewById(R.id.editText);
        colorSwitch = findViewById(R.id.colorSwitch);
        checkboxVisible = findViewById(R.id.checkboxVisible);
        textVisible = findViewById(R.id.textVisible);
        layout = findViewById(R.id.layout);

        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);
        updateCountText();
        changeBackgroundColor();
        changeVisibility(null);

        if(editText.getText().toString().matches("")){
            changeEditText();
        } else {
            stateViewModel.updateEditText(editText.getText().toString().trim());
        };

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.incrementCount();
                updateCountText();
            };
        });

        colorSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.updateSwitchColor(colorSwitch.isChecked());
                changeBackgroundColor();
            };
        });

        checkboxVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.updateCheckboxVisibility(checkboxVisible.isChecked());
                changeVisibility(v);
            };
        });
    };

    private void updateCountText(){
        textViewCount.setText("Licznik: " + stateViewModel.getCount());
    };

    private void changeBackgroundColor(){
        if(stateViewModel.getSwitchColor() == false){
            layout.setBackgroundColor(Color.WHITE);
        } else {
            layout.setBackgroundColor(Color.BLACK);
        };
    };

    private void changeVisibility(View v){
        if(stateViewModel.getCheckboxVisibility() == false){
            textVisible.setVisibility(v.INVISIBLE);
        } else {
            textVisible.setVisibility(v.VISIBLE);
        }
    };
    private void changeEditText(){
        editText.setText(stateViewModel.getEditText());
    }
}
