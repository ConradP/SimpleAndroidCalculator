package com.example.conradp.sscalculator;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText display = (EditText) findViewById(R.id.displayText);
        Calculator calculator = new Calculator().setDisplay(display);
        init(calculator);
    }

    private void init(final Calculator calculator) {
           ConstraintLayout container = (ConstraintLayout) findViewById(R.id.ButtonLayout);
        for(int i = 0; i < container.getChildCount(); i++) {
            container.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button)v;
                    if(button.getText().toString().equals("AC")){
                        calculator.clearDisplay();
                    }
                    else if(button.getText().toString().equals("=")){
                        calculator.calculate();
                    }
                    else{
                        calculator.sendString(button.getText().toString());
                    }
                }
            });
        }
    }
}
