package com.example.calculator0;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class FragmentTranslate extends Fragment{
    private EditText et_two;
    private EditText et_ten;
    private EditText et_sixteen;
    private Button btn_translaten;
    private Button btn_clear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.fragment_translate,container,false);
        et_two=(EditText) view.findViewById(R.id.et_two);
        et_ten=(EditText) view.findViewById(R.id.et_ten);
        et_sixteen=(EditText) view.findViewById(R.id.et_sixteen);
        btn_translaten=(Button) view.findViewById(R.id.btn_translate);
        btn_clear=(Button) view.findViewById(R.id.btn_clear);

        et_two.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE|EditorInfo.TYPE_CLASS_PHONE);
        et_two.setSingleLine(false);
        //et_two.setHorizontallyScrolling(false);
        et_two.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if (count == 1){
                    int length = s.toString().replaceAll(" ", "").length();
                    if (length%4==0){
                        et_two.setText(s + " ");
                        et_two.setSelection(et_two.getText().toString().length());
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        et_two.setKeyListener(new NumberKeyListener() {
            @Override
            protected char[] getAcceptedChars() {
                return new char[] { '1','0' };
            }
            @Override
            public int getInputType() {
                // TODO Auto-generated method stub
                return android.text.InputType.TYPE_CLASS_PHONE;

            }
        });

        et_ten.setInputType(EditorInfo.TYPE_CLASS_PHONE);


        btn_translaten.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str_two=et_two.getText().toString();
                String str_ten=et_ten.getText().toString();
                String str_sixteen=et_sixteen.getText().toString();
                if(str_two.length()!=0&&str_ten.length()==0&&str_sixteen.length()==0){
                    if(isTwo(str_two.replaceAll(" ", ""))){
                        try{
                            Long num=Long.parseLong(str_two.replaceAll(" ", ""),2);
                            et_sixteen.setText(Long.toHexString(num).toUpperCase());
                            et_ten.setText(""+num);
                            et_two.setText(cutTwo(str_two.replaceAll(" ", "")));


                        }catch(Exception ex){
                            Toast.makeText(getActivity(), "对不起，数字超出了所能表示的最大范围", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getActivity(), "只能输入0和1", Toast.LENGTH_SHORT).show();
                    }


                }else if(str_two.length()==0&&str_ten.length()!=0&&str_sixteen.length()==0){
                    if(isTen(str_ten)){
                        try{
                            Long num=Long.parseLong(str_ten, 10);
                            et_two.setText(cutTwo(Long.toBinaryString(num)));
                            et_sixteen.setText(Long.toHexString(num).toUpperCase());
                        }catch(Exception ex){
                            Toast.makeText(getActivity(), "对不起，数字超出了所能表示的最大范围", Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(getActivity(), "只能输入0到9", Toast.LENGTH_SHORT).show();

                    }

                }else if(str_two.length()==0&&str_ten.length()==0&&str_sixteen.length()!=0){
                    if(isSixteen(str_sixteen)){
                        try{
                            Long num=Long.parseLong(str_sixteen,16);
                            et_two.setText(cutTwo(Long.toBinaryString(num)));
                            et_ten.setText(""+num);
                            et_sixteen.setText(str_sixteen.toUpperCase());
                        }catch(Exception ex){
                            Toast.makeText(getActivity(), "对不起，数字超出了所能表示的最大范围", Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(getActivity(), "只能输入0到9和a(A)到f(F)", Toast.LENGTH_SHORT).show();
                    }

                }else if(str_two.length()!=0||str_ten.length()!=0||str_sixteen.length()!=0){
                    Toast.makeText(getActivity(), "只能在一个编辑框内含有数据",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "请查看输入是否正确",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_clear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                et_two.setText("");
                et_ten.setText("");
                et_sixteen.setText("");
            }
        });


        return view;
    }


    public static boolean isTen(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    public static boolean isTwo(String str){
        Pattern pattern = Pattern.compile("[01]*");
        return pattern.matcher(str).matches();
    }
    public static boolean isSixteen(String str){
        Pattern pattern = Pattern.compile("[abcdefABCDEF0-9]*||[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static String cutTwo(String two_old){
        String two_new="";
        int length=two_old.length();
        switch(length%4){
            case 1:
                two_old="000"+two_old;
                break;
            case 2:
                two_old="00"+two_old;
                break;
            case 3:
                two_old="0"+two_old;
                break;
        }
        int count=0;
        for(char a : two_old.toCharArray()){
            two_new+=a;
            count++;
            if(count%4==0){
                two_new+=" ";
            }


        }
        return two_new;
    }

}
