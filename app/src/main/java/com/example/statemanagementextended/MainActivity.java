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
    public View view;
    private LinearLayout layout;
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText editText;
    private CheckBox checkbox_visible;
    private TextView text_visible;
    private Switch colorSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        editText = findViewById(R.id.editText);
        colorSwitch = findViewById(R.id.colorSwitch);
        checkbox_visible = findViewById(R.id.checkbox_visible);
        text_visible = findViewById(R.id.text_visible);
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

        checkbox_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.updateCheckboxVisibility(checkbox_visible.isChecked());
                changeVisibility(v);
            };
        });
    };

    private void updateCountText(){
        textViewCount.setText("Licznik: " + stateViewModel.getCount());
    };

    private void changeBackgroundColor(){
        if(stateViewModel.getSwitch_color() == false){
            layout.setBackgroundColor(Color.WHITE);
        } else {
            layout.setBackgroundColor(Color.BLACK);
        };
    };

    private void changeVisibility(View v){
        if(stateViewModel.getCheckbox_visibility() == false){
            text_visible.setVisibility(v.INVISIBLE);
        } else {
            text_visible.setVisibility(v.VISIBLE);
        }
    };
    private void changeEditText(){
        editText.setText(stateViewModel.getEdit_text());
    }
}
