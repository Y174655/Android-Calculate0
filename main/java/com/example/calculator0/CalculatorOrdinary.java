package com.example.calculator0;


import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class CalculatorOrdinary {
    public ArrayList<String> suffixExpression(String str_infix)  {
        char[] array_infix = str_infix.toCharArray();
        ArrayList<String> str_suffix = new ArrayList<String>();
        Stack expression = new Stack();
        boolean bool ;
        String str_temp="";
        expression.push('#');
        for (char a : array_infix) {
            if (Character.isDigit(a)||a=='.'||a=='E'||a=='e') {
                str_temp += a;
            } else {
                if(str_temp.length()!=0){
                    str_suffix.add(str_temp);
                }
                bool=true;

                str_temp="";
                while (bool) {
                    char x1 = (char) expression.peek();
                    switch (a) {
                        case '(':
                            switch (x1) {
                                case '+':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '-':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '*':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '/':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '(':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case ')':

                                    break;
                                case '#':
                                    expression.push(a);
                                    bool = false;
                                    break;
                            }
                            break;
                        case ')':
                            switch (x1) {
                                case '+':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '-':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '*':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '/':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '(':
                                    expression.pop();
                                    bool=false;
                                    break;
                                case ')':
                                    expression.pop();

                                    break;
                                case '#':
                                    break;
                            }
                            break;
                        case '+':
                            switch (x1) {
                                case '+':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '-':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '*':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '/':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '(':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case ')':
                                    expression.pop();

                                    break;
                                case '#':
                                    expression.push(a);
                                    bool = false;
                                    break;
                            }
                            break;
                        case '-':
                            switch (x1) {
                                case '+':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '-':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '*':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '/':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '(':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case ')':
                                    expression.pop();

                                    break;
                                case '#':
                                    expression.push(a);
                                    bool = false;
                                    break;
                            }
                            break;
                        case '*':
                            switch (x1) {
                                case '+':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '-':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '*':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '/':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '(':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case ')':
                                    expression.pop();

                                    break;
                                case '#':
                                    expression.push(a);
                                    bool = false;
                                    break;
                            }
                            break;
                        case '/':
                            switch (x1) {
                                case '+':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '-':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case '*':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '/':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '(':
                                    expression.push(a);
                                    bool = false;
                                    break;
                                case ')':
                                    expression.pop();

                                    break;
                                case '#':
                                    expression.push(a);
                                    bool = false;
                                    break;
                            }
                            break;
                        case '#':

                            x1 = (char) expression.peek();
                            switch (x1) {
                                case '+':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '-':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '*':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '/':
                                    str_suffix.add(""+x1);
                                    expression.pop();

                                    break;
                                case '(':

                                    break;
                                case ')':
                                    expression.pop();

                                    break;
                                case '#':
                                    return str_suffix;

                            }
                            break;

                    }
                }
            }
        }
        return str_suffix;

    }

    public double getResult(ArrayList<String> str_suffix) throws Exception{
        Stack calculate=new Stack();
        double c = 0;
        for(int i=0;i<str_suffix.size();i++){
            if (isNumericDouble(str_suffix.get(i))||isNumericInt(str_suffix.get(i))){
                calculate.push(str_suffix.get(i));
                c=Double.parseDouble(str_suffix.get(i));
            }else{
                double a=Double.parseDouble((String) calculate.peek());
                calculate.pop();
                double b=Double.parseDouble((String) calculate.peek());
                calculate.pop();

                switch(str_suffix.get(i).charAt(0)){
                    case '+':
                        c=a+b;
                        break;
                    case '-':
                        c=b-a;
                        break;
                    case '*':
                        c=a*b;
                        break;
                    case '/':
                        c=b/a;
                        break;
                }
                calculate.push(Double.toString(c));

            }
        }
        calculate.pop();
        if(!calculate.empty()){
            throw new Exception("表达式错误");
        }else{
            return c;
        }

    }

    public  boolean isTrue(String str){
        char[] array_infix = str.toCharArray();
        Stack stack = new Stack();
        for (char a : array_infix) {
            if (a=='(') {
                stack.push(a);
            }
            if(a==')'&&stack.empty()){
                return false;
            }
            if(a==')'&&!stack.empty()&&(char)stack.peek()=='('){
                stack.pop();

            }
            if(a==')'&&!stack.empty()&&(char)stack.peek()==')'){
                stack.push(a);

            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }

    }
    public static boolean isNumericDouble(String str){
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        return pattern.matcher(str).matches();
    }
    public static boolean isNumericInt(String str){
        Pattern pattern = Pattern.compile("-?[0-9]");
        return pattern.matcher(str).matches();
    }
}
