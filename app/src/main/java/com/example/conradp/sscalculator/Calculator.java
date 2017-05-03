package com.example.conradp.sscalculator;

import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

/**
 * Created by conradp on 5/3/17.
 */

class Calculator {
    private EditText display;

    public Calculator setDisplay(EditText display){
        this.display = display;
        return this;
    }

    public void clearDisplay(){
        display.setText("");
    }

    public void calculate(){
        //TODO: parse text in the display into equation.
        double result = new Expression(display.getText().toString()).calculate();
        display.setText(Double.toString(result));
    }


    private void ErrorNotify(){
        display.setText('E');
    }

    public void sendString(String text) {
        if (text.length()>1) ErrorNotify();
        else display.setText(display.getText()+text);
    }
}

