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

public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count";
    private static final Boolean KEY_CHECKBOXVISIBILITY = false;
    private static final Boolean KEY_SWITCHCOLOR = false;
    private static final String KEY_EDITTEXT = "";

    private LinearLayout layout;
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText editText;
    private CheckBox checkbox_visible;
    private TextView text_visible;
    private Switch colorSwitch;

    private int count = 0;
    private Boolean checkbox_visibility;
    private Boolean switch_color;
    private String edit_text;

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

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("KEY_COUNT");
            checkbox_visibility = savedInstanceState.getBoolean("KEY_CHECKBOXVISIBILITY");
            changeVisibility(checkbox_visibility, null);
            switch_color = savedInstanceState.getBoolean("KEY_SWITCHCOLOR");
            changeBackgroundColor(switch_color);
            edit_text = savedInstanceState.getString("KEY_EDITTEXT");
        };

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateCountText();
            };
        });

        colorSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_color = colorSwitch.isChecked();
                changeBackgroundColor(switch_color);
            };
        });

        checkbox_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkbox_visibility = checkbox_visible.isChecked();
                changeVisibility(checkbox_visibility, v);
            };
        });
    };

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("KEY_COUNT", count);
        outState.putBoolean("KEY_CHECKBOXVISIBILITY", checkbox_visibility);
        outState.putBoolean("KEY_SWITCHCOLOR", switch_color);
        outState.putString("KEY_EDITTEXT", edit_text);};

    private void updateCountText(){
        textViewCount.setText("Licznik: " + count);
    };

    private void changeBackgroundColor(Boolean ifTrue){
        if(ifTrue == false){
            layout.setBackgroundColor(Color.WHITE);
        } else {
            layout.setBackgroundColor(Color.BLACK);
        };
    };

    private void changeVisibility(Boolean ifTrue, View v){
        if(ifTrue == false){
            text_visible.setVisibility(v.INVISIBLE);
        } else {
            text_visible.setVisibility(v.VISIBLE);
        }
    };
}
