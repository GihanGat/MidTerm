package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.view.View.OnKeyListener;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.TextView.OnEditorActionListener;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EditText textViewCalcScreen;
    private TextView textViewHistory;
    private Button button1,button2,button3,button4,button5;
    private Button button6,button7,button8,button9,button0;
    private Button buttonEqual, buttonAddition,buttonSubtraction;
    private Button buttonMultiplication,buttonClear,buttonDivision;
    private Button buttonDecimal;

    Double calcvalueFirst = Double.NaN;
    Double calcvalueSecond;

    static final char ADDITION = '+';
    static final char SUBSTRACTION = '-';
    static final char MULITPLICATION = '*';
    static final char DIVISION  = '/';

    //String[] separator=new String[]{"+","-","/","*"};
    public char currentOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCalcScreen = (EditText) findViewById(R.id.textViewCalcScreen);
        textViewHistory = (TextView) findViewById(R.id.textViewHistory);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDecimal = (Button) findViewById(R.id.buttonDecimal);

        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSubtraction = (Button) findViewById(R.id.buttonSubtraction);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);

        buttonEqual.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button0:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "0");
                break;
            case R.id.button1:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "1");
                break;
            case R.id.button2:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "2");
                break;
            case R.id.button3:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "3");
                break;
            case R.id.button4:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "4");
                break;
            case R.id.button5:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "5");
                break;
            case R.id.button6:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "6");
                break;
            case R.id.button7:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "7");
                break;
            case R.id.button8:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "8");
                break;
            case R.id.button9:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + "9");
                break;
            case R.id.buttonDecimal:
                textViewCalcScreen.setText(textViewCalcScreen.getText() + ".");
                break;
            case R.id.buttonEqual:
                calcvalueSecond = Double.parseDouble(textViewCalcScreen.getText().toString());
                textViewCalcScreen.setText("");
                Calculate(calcvalueFirst,calcvalueSecond, currentOperator);
                //Double val1 = 0.0;
                //Double val2 = 0.0;
                //String readValues= textViewCalcScreen.getText().toString();
                //String[] readValues= textViewCalcScreen.getText().toString().split("[-+*/=]");
                //String[] parts = readValues.split("[-+*/=]");
                //displayMessage(parts[0] + parts[1]);

                //Double val = Double.parseDouble(readValues[0]);
                //char op = readValues[1].charAt(0);
                //textViewCalcScreen.setText(readValues[0]+ "---" + readValues[1]);

                //String readValue =  textViewCalcScreen.getText().toString().replaceAll("[^0-9]", "");
                //char operator = textViewCalcScreen.getText().toString().replaceAll("[^A-Z]", "");
                break;
            case R.id.buttonAddition:
                calcvalueFirst = Double.parseDouble(textViewCalcScreen.getText().toString());
                currentOperator = ADDITION;
                textViewCalcScreen.setText("");
                break;
            case R.id.buttonSubtraction:
                calcvalueFirst = Double.parseDouble(textViewCalcScreen.getText().toString());
                currentOperator = SUBSTRACTION;
                textViewCalcScreen.setText("");
                break;
            case R.id.buttonMultiplication:
                calcvalueFirst = Double.parseDouble(textViewCalcScreen.getText().toString());
                currentOperator = MULITPLICATION;
                textViewCalcScreen.setText("");
                break;
            case R.id.buttonDivision:
                calcvalueFirst = Double.parseDouble(textViewCalcScreen.getText().toString());
                currentOperator = DIVISION;
                textViewCalcScreen.setText("");
                break;
            case R.id.buttonClear:
                textViewCalcScreen.setText("");
                textViewHistory.setText("");
                break;
        }
    }

    public void Calculate(Double firstValue, Double secondValue , char oprator){
        Double result;
        switch  (oprator) {
            case ADDITION:
                 result = firstValue + secondValue;
                textViewCalcScreen.setText(result.toString());
                textViewHistory.setText(firstValue.toString()+ " " + Character.toString(oprator)+" "+ secondValue.toString());
                    break;
            case SUBSTRACTION:
                 result = firstValue - secondValue;
                textViewCalcScreen.setText(result.toString());
                textViewHistory.setText(firstValue.toString()+ " " + Character.toString(oprator)+" "+ secondValue.toString());
                break;
            case MULITPLICATION:
                 result = firstValue * secondValue;
                textViewCalcScreen.setText(result.toString());
                textViewHistory.setText(firstValue.toString()+ " " + Character.toString(oprator)+" "+ secondValue.toString());
                break;
            case DIVISION:
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                }else {
                    result = 0.0;
                }
                textViewCalcScreen.setText(result.toString());
                textViewHistory.setText(firstValue.toString()+ " " + Character.toString(oprator)+" "+ secondValue.toString());
                break;
        }
    }

        public void displayMessage(String message){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
