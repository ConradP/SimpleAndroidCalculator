package com.example.conradp.sscalculator;

import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

/**
 * Created by conradp on 5/3/17.
 */

class Calculator {
    private TextView display;

    Calculator setDisplay(TextView display) {
        this.display = display;
        return this;
    }

    void clearDisplay() {
        display.setText("0");
    }

    void calculate() {
        //TODO: parse text in the display into equation.
        double result = new Expression(display.getText().toString()).calculate();
        display.setText(Double.toString(result));
        if (result == Double.NaN) {
            ErrorNotify();
        }
    }


    private void ErrorNotify() {
        display.setText('E');
    }

    void sendString(String text) {
        if (display.getText().toString().equals("0")) {
            display.setText(text);
        } else {
            display.setText(display.getText() + text);
        }
    }
}

