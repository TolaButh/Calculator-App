package tolabuth.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5
            ,btn6,btn7,btn8,btn9,btnDivide,btnMultiply,btnAdd,btnSubtract,btnC,btnSign
            ,btnPercent,btnDot,btnEqual;
    private TextView tvResult;
    private double a=0,b=0,c=0;
    private String op="",result=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        match();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("1");


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber("9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("+");
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("-");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("*");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("/");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == null){
                    result = "0.";
                }else {
                    if(result.indexOf(".") == -1)
                        result = result+".";
                }
                tvResult.setText(result);
            }
        });
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result != null){
                    if (result.charAt(0) == '-'){
                        result = result.substring(1);
                    }else {
                        result = "-"+result;
                    }
                }else if (result==null && b != 0){

                    result = c+"";
                    if (result.charAt(0) == '-'){
                        result = result.substring(1);
                    }else {
                        result = "-"+result;
                    }
                }
                tvResult.setText(result);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result != null){
                    result = result+"0";
                    tvResult.setText(result);
                }

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result != null) {
                    b = Double.parseDouble(result);
                    switch (op) {
                        case "+":
                            c = a + b;
                            break;
                        case "-":
                            c = a - b;
                            break;
                        case "*":
                            c = a * b;
                            break;
                        case "/":
                            c = a / b;
                            break;
                    }
                    if ((int) c == c) {
                        DecimalFormat df = new DecimalFormat("#.##");
                        String ref = df.format(c);

                        tvResult.setText(ref);
                    } else {
                        tvResult.setText(String.format("%.2f", c));
                    }
                    a =c;
                    result = null;
                    Log.d("number", "onClick"+a);




                }

            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result != null) {
                    a = Double.parseDouble(result);
                }

                c = a/100;
                tvResult.setText(String.valueOf(c));
                a = c;
                result = null;


            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = null;
                tvResult.setText("0");
            }
        });




    }

    private void setOperator(String s) {
        op = s;
        if (result != null)
            a = Double.parseDouble(result);
        result = null;
    }

    private void AddNumber(String s) {
        if(result == null){
            result = s;
        }else {
            result = result + s;
        }
        tvResult.setText(result);
    }

    private void match() {
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnSign = findViewById(R.id.btn_sign);
        btnC = findViewById(R.id.btn_C);
        btnPercent = findViewById(R.id.btn_percent);
        btnDot = findViewById(R.id.btn_dot);
        btnEqual = findViewById(R.id.btn_equal);
        tvResult = findViewById(R.id.tv_result);

    }
}