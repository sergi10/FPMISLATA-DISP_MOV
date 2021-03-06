package com.example.yoyo.calculadora;

import android.renderscript.Int3;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int operacion = 0;
    private int operador1 = 0;
    private int operador2 = 0;
    private TextView resultado;
    private String temp = "";
    private boolean pendingOp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //resultado.setText("");
        setContentView(R.layout.activity_main);
        resultado = (TextView) findViewById(R.id.tvResultado);
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonMas = (Button) findViewById(R.id.buttonMas);
        Button buttonMenos = (Button) findViewById(R.id.buttonMenos);
        Button buttonMulti = (Button) findViewById(R.id.buttonMulti);
        Button buttonDivision = (Button) findViewById(R.id.buttonDivision);
        Button buttonIgual = (Button) findViewById(R.id.buttonIgual);
        Button buttonClear = (Button) findViewById(R.id.buttonClear);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "0";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "1";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "2";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "3";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "4";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "5";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "6";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "7";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "8";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "9";
                resultado.setText(temp);
                if ((!pendingOp) & (operacion > 0)) {
                    clearDisplay();
                }
            }
        });
        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador1 = getValue(resultado.getText().toString());
                operacion = 1;

            }
        });
        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador1 = getValue(resultado.getText().toString());
                operacion = 2;
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador1 = getValue(resultado.getText().toString());
                operacion = 3;
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador1 = getValue(resultado.getText().toString());
                operacion = 4;
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                operador1 = 0;
                clearDisplay();

            }
        });
        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp != "") {
                    operador2 = getValue(resultado.getText().toString());
                } else {
                    operador2 = 0;
                }
                int result = 0;
                String resultTxt = "";
                if (1 == operacion) {
                    result = operador1 + operador2;
                } else if (2 == operacion) {
                    result = operador1 - operador2;
                } else if (3 == operacion) {
                    result = operador1 * operador2;
                } else if (4 == operacion) {
                    if (operador2 == 0) {
                        resultTxt = "error";
                    } else {
                        result = operador1 / operador2;
                    }
                } else {
                    result = operador1;
                }
                if (resultTxt != "error") {
                    resultTxt = String.valueOf(result);
                    operador1 = result;
                }
                resultado.setText(resultTxt);
                reset();
            }
        });
    }

    private void clearDisplay() {
        resultado.setText("");
        temp = "";
        if (!pendingOp) {
            operador2 = 0;
        }
    }

    private void reset() {
        operacion = 0;
        //operador1 = 0;
        operador2 = 0;
        pendingOp = false;
        temp = "";
        //resultado.setText("0");

    }

    private int getValue(String num) {
        int res = 0;
        if (num != "") {
            res = Integer.parseInt(num);
            pendingOp = true;
            clearDisplay();
        }
        return res;
    }
}
