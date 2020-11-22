package com.example.calculator0;

import java.math.BigDecimal;
import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentOrdinary extends Fragment implements OnClickListener {
    private Button btn_zero;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_mul;
    private Button btn_div;
    private Button btn_dot;
    private Button btn_clear;
    private Button btn_delete;
    private EditText et_result;
    private Button btn_left_par;
    private Button btn_right_par;
    private Button btn_equal;
    private String str_result = "";
    private String str_result_trans = "";

    private boolean bool_click = true; // 防止运算符出现两次
    private boolean bool_dot = true; // 防止小数点出现多次
    private boolean bool_end = false; // 结果直接进行运算
    private boolean bool_kuo = false; // 防止括号里不输入东西
    private CalculatorOrdinary result = new CalculatorOrdinary();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_ordinary, container, false);
        btn_zero = (Button) view.findViewById(R.id.btn_zero);
        btn_one = (Button) view.findViewById(R.id.btn_one);
        btn_two = (Button) view.findViewById(R.id.btn_two);
        btn_three = (Button) view.findViewById(R.id.btn_three);
        btn_four = (Button) view.findViewById(R.id.btn_four);
        btn_five = (Button) view.findViewById(R.id.btn_five);
        btn_six = (Button) view.findViewById(R.id.btn_six);
        btn_seven = (Button) view.findViewById(R.id.btn_seven);
        btn_eight = (Button) view.findViewById(R.id.btn_eight);
        btn_nine = (Button) view.findViewById(R.id.btn_nine);
        btn_add = (Button) view.findViewById(R.id.btn_add);
        btn_mul = (Button) view.findViewById(R.id.btn_mul);
        btn_div = (Button) view.findViewById(R.id.btn_div);
        btn_sub = (Button) view.findViewById(R.id.btn_sub);
        btn_dot = (Button) view.findViewById(R.id.btn_dot);
        btn_clear = (Button) view.findViewById(R.id.btn_clear);
        btn_delete = (Button) view.findViewById(R.id.btn_delete);
        btn_left_par = (Button) view.findViewById(R.id.btn_left_par);
        btn_right_par = (Button) view.findViewById(R.id.btn_right_par);
        btn_equal = (Button) view.findViewById(R.id.btn_equal);
        et_result = (EditText) view.findViewById(R.id.et_result);
        et_result.setSelection(et_result.getText().toString().length());
        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_left_par.setOnClickListener(this);
        btn_right_par.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {
            case R.id.btn_zero:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                if (str_result_trans.length() != 0) {
                    if (str_result_trans.charAt(str_result_trans.length() - 1) != '/') {
                        str_result += '0';
                        str_result_trans += '0';
                        et_result.setText(str_result);
                        et_result.setSelection(et_result.getText().toString().length());
                    } else {
                        Toast.makeText(getActivity(), "老师好像说0不能做除数哦 ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    str_result += '0';
                    str_result_trans += '0';
                    et_result.setText(str_result);
                    et_result.setSelection(et_result.getText().toString().length());
                }

                break;
            case R.id.btn_one:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '1';
                str_result_trans += '1';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_two:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '2';
                str_result_trans += '2';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_three:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '3';
                str_result_trans += '3';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_four:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '4';
                str_result_trans += '4';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_five:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '5';
                str_result_trans += '5';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_six:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '6';
                str_result_trans += '6';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_seven:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '7';
                str_result_trans += '7';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_eight:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '8';
                str_result_trans += '8';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_nine:
                bool_kuo = false;
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                str_result += '9';
                str_result_trans += '9';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_add:
                if (str_result_trans.length() != 0) {
                    bool_dot = true;
                    bool_end = false;
                    char char_end = str_result_trans.charAt(str_result_trans.length() - 1);
                    if (char_end != '+' && char_end != '-' && char_end != '*' && char_end != '/') {
                        str_result += '+';
                        str_result_trans += '+';
                        et_result.setText(str_result);
                        et_result.setSelection(et_result.getText().toString().length());
                    }
                }

                break;
            case R.id.btn_sub:
                bool_end = false;
                if (str_result_trans.length() != 0) {
                    bool_dot = true;

                    char char_end = str_result_trans.charAt(str_result_trans.length() - 1);
                    if (char_end != '+' && char_end != '-' && char_end != '*' && char_end != '/') {

                        if (Character.isDigit(char_end)) {
                            str_result_trans += "+0-";
                            str_result += '-';
                            et_result.setText(str_result);
                            et_result.setSelection(et_result.getText().toString().length());
                        } else {
                            str_result_trans += "0-";
                            str_result += "-";
                            et_result.setText(str_result);
                            et_result.setSelection(et_result.getText().toString().length());
                        }

                    }

                } else {
                    str_result_trans += "0-";
                    str_result += "-";
                    et_result.setText(str_result);
                    et_result.setSelection(et_result.getText().toString().length());
                }

                break;
            case R.id.btn_mul:
                if (str_result_trans.length() != 0) {
                    bool_dot = true;
                    bool_end = false;
                    char char_end = str_result_trans.charAt(str_result_trans.length() - 1);
                    if (char_end != '+' && char_end != '-' && char_end != '*' && char_end != '/') {
                        str_result_trans += '*';
                        str_result += '*';
                        et_result.setText(str_result);
                        et_result.setSelection(et_result.getText().toString().length());
                    }
                }
                break;
            case R.id.btn_div:
                if (str_result_trans.length() != 0) {
                    bool_dot = true;
                    bool_end = false;
                    char char_end = str_result_trans.charAt(str_result_trans.length() - 1);
                    if (char_end != '+' && char_end != '-' && char_end != '*' && char_end != '/') {
                        str_result += '/';
                        str_result_trans += '/';
                        et_result.setText(str_result);
                        et_result.setSelection(et_result.getText().toString().length());
                    }
                }
                break;
            case R.id.btn_dot:
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                if (bool_dot) {
                    if (str_result.length() != 0) {
                        if (str_result.charAt(str_result.length() - 1) == '+'
                                || str_result.charAt(str_result.length() - 1) == '-'
                                || str_result.charAt(str_result.length() - 1) == '*'
                                || str_result.charAt(str_result.length() - 1) == '/') {
                            str_result += '0';
                            str_result_trans += '0';
                        }
                    } else {
                        str_result += '0';
                        str_result_trans += '0';
                    }

                    str_result += '.';
                    str_result_trans += '.';
                    et_result.setText(str_result);
                    et_result.setSelection(et_result.getText().toString().length());
                    bool_dot = false;
                }

                break;
            case R.id.btn_clear:
                str_result = "";
                str_result_trans = "";
                et_result.setText(str_result);
                bool_dot = true;
                break;
            case R.id.btn_delete:
                if (str_result.length() != 0) {
                    if (str_result.charAt(str_result.length() - 1) == '.') {
                        bool_dot = true;
                    }
                    str_result = str_result.substring(0, str_result.length() - 1);
                    str_result_trans = str_result_trans.substring(0, str_result_trans.length() - 1);
                    et_result.setText(str_result);
                    et_result.setSelection(et_result.getText().toString().length());
                }

                break;
            case R.id.btn_left_par:
                if (bool_end) {
                    str_result = "";
                    str_result_trans = "";
                    bool_end = false;
                }
                bool_kuo = true;
                str_result += '(';
                str_result_trans += '(';
                et_result.setText(str_result);
                et_result.setSelection(et_result.getText().toString().length());
                break;
            case R.id.btn_right_par:
                if (!bool_kuo) {
                    if (bool_end) {
                        str_result = "";
                        str_result_trans = "";
                        bool_end = false;
                    }
                    str_result += ')';
                    str_result_trans += ')';
                    et_result.setText(str_result);
                    et_result.setSelection(et_result.getText().toString().length());
                }

                break;
            case R.id.btn_equal:
                try {
                    if (str_result_trans.length() != 0) {
                        bool_dot = true;
                        char char_end = str_result_trans.charAt(str_result_trans.length() - 1);
                        if (char_end != '+' && char_end != '-' && char_end != '*' && char_end != '/') {
                            if (result.isTrue(str_result_trans)) {
                                ArrayList<String> str = result.suffixExpression(str_result_trans + '#');
                                double double_result = result.getResult(str);
                                double_result = new BigDecimal(double_result).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue(); // 保留8位小数
                                et_result.setText(Double.toString(double_result));
                                bool_end = true;
                                et_result.setSelection(et_result.getText().toString().length());
                                if (double_result >= 0) {
                                    str_result = Double.toString(double_result);
                                    str_result_trans = Double.toString(double_result);
                                } else {
                                    str_result = Double.toString(double_result);
                                    str_result_trans = "0" + Double.toString(double_result);
                                }
                            } else {
                                Toast.makeText(getActivity(), "亲，检查一下你输对了么", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                } catch (Exception ex) {
                    Toast.makeText(getActivity(), "亲，检查一下你输对了么", Toast.LENGTH_SHORT).show();
                }

        }
    }

}

