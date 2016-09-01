package com.example.supervisor.jamvercalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public double firstNumber = 0;
    public double secondNumber = 0;
    public double result;
    public boolean wasSet;
    public String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NumberClick(View v){
        TextView txtView = (TextView) findViewById(R.id.textView);
        Button btn = (Button) findViewById(v.getId());

        if(txtView.getText().equals("error ;-;") || txtView.getText().equals("0") || txtView.getText().equals("Jamver Calc") || wasSet){
            txtView.setText(btn.getText());
            wasSet = false;
        } else{
            txtView.setText(txtView.getText()+ "" + btn.getText());
        }
    }

    public void DotClick(View v){
        TextView txtView = (TextView) findViewById(R.id.textView);
        Button btn = (Button) findViewById(v.getId());

        if(!DotValidation(txtView.getText().toString()) && btn.getText().equals(".") && (txtView.getText().equals("error ;-;") || txtView.getText().equals("Jamver Calc") || wasSet)){
            txtView.setText("0.");
            wasSet = false;
        } else if(!DotValidation(txtView.getText().toString())){
            txtView.setText(txtView.getText()+ "" + btn.getText());
        }
    }
    
    public void OperatorClick(View v){
        TextView txtView = (TextView) findViewById(R.id.textView);
        TextView otherView = (TextView) findViewById(R.id.textView2);
        Button btn = (Button) findViewById(v.getId());
        String i = btn.getText().toString();
        String s;

        switch(i){
            case "+":
                operation = "+";
                break;
            case "-":
                operation = "-";
                break;
            case "*":
                operation = "*";
                break;
            case "/":
                operation = "/";
                break;
            case "%":
                operation = "%";
                break;
            case "√":
                result = Math.sqrt(Double.parseDouble(txtView.getText().toString()));
                s = (long) result == result ? "" + (long) result : "" + result;
                wasSet = true;
                operation = "";
                firstNumber = 0;
                secondNumber = 0;
                txtView.setText(s);
                otherView.setText("");
                break;
            case "1/x":
                result = 1 / Double.parseDouble(txtView.getText().toString());
                wasSet = true;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                break;
            case "±":
                result = Double.parseDouble(txtView.getText().toString()) * -1;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                break;
        }

        switch (operation){
            case "+":
                firstNumber = Double.parseDouble(txtView.getText().toString());
                s = (long) firstNumber == firstNumber ? "" + (long) firstNumber : "" + firstNumber;
                txtView.setText("0");
                otherView.setText(s + " " + operation);
                break;
            case "-":
                firstNumber = Double.parseDouble(txtView.getText().toString());
                s = (long) firstNumber == firstNumber ? "" + (long) firstNumber : "" + firstNumber;
                txtView.setText("0");
                otherView.setText(s + " " + operation);
                break;
            case "*":
                firstNumber = Double.parseDouble(txtView.getText().toString());
                s = (long) firstNumber == firstNumber ? "" + (long) firstNumber : "" + firstNumber;
                txtView.setText("0");
                otherView.setText(s + " " + operation);
                break;
            case "/":
                firstNumber = Double.parseDouble(txtView.getText().toString());
                s = (long) firstNumber == firstNumber ? "" + (long) firstNumber : "" + firstNumber;
                txtView.setText("0");
                otherView.setText(s + " " + operation);
                break;
            case "%":
                firstNumber = Double.parseDouble(txtView.getText().toString());
                s = (long) firstNumber == firstNumber ? "" + (long) firstNumber : "" + firstNumber;
                txtView.setText("0");
                otherView.setText(s + operation);
                break;
        }
    }

    public void Result(View v){
        TextView txtView = (TextView) findViewById(R.id.textView);
        TextView otherView = (TextView) findViewById(R.id.textView2);
        String s;

        switch (operation){
            case "+":
                secondNumber = Double.parseDouble(txtView.getText().toString());
                result = firstNumber + secondNumber;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                otherView.setText("");
                wasSet = true;
                break;
            case "-":
                secondNumber = Double.parseDouble(txtView.getText().toString());
                result = firstNumber - secondNumber;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                otherView.setText("");
                wasSet = true;
                break;
            case "*":
                secondNumber = Double.parseDouble(txtView.getText().toString());
                result = firstNumber * secondNumber;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                otherView.setText("");
                wasSet = true;
                break;
            case "/":
                secondNumber = Double.parseDouble(txtView.getText().toString());
                result = firstNumber / secondNumber;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                otherView.setText("");
                wasSet = true;
                break;
            case "%":
                secondNumber = Double.parseDouble(txtView.getText().toString());
                result = (firstNumber /100) * secondNumber;
                s = (long) result == result ? "" + (long) result : "" + result;
                txtView.setText(s);
                otherView.setText("");
                wasSet = true;
                break;
            default:
                txtView.setText("error ;-;");
                break;
        }
        operation = "";
    }

    public void Erase(View v){
        TextView txtView = (TextView) findViewById(R.id.textView);
        TextView otherView = (TextView) findViewById(R.id.textView2);
        Button btn = (Button) findViewById(v.getId());
        String i = btn.getText().toString();

        switch (i){
            case "C":
                firstNumber = 0;
                secondNumber = 0;
                operation = "";
                txtView.setText("0");
                otherView.setText("");
                break;
            case "CE":
                if (operation.equals("")){
                    firstNumber = 0;
                    operation = "";
                    txtView.setText("0");
                } else {
                    secondNumber = 0;
                    txtView.setText("0");
                }
                break;
            case "<-":
                txtView.setText(txtView.getText().toString().substring(0,txtView.length() - 1));
                break;
            default:
                break;
        }
    }

    public boolean DotValidation(String number) {
        for (int i = 0; i < number.length(); i++){
            if (number.charAt(i) == '.'){
                return true;
            }
        }

        return false;
    }
}