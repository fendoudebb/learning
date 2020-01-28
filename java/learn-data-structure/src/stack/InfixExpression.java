package stack;

import java.util.Stack;

/**
 * 中缀表达式：正常的算术表达式 3+2*6-2
 */
public class InfixExpression {
    public static void main(String[] args) {
        String expression = "9+3*5+2";
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        //遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            // 如果是数字，就入数栈
            // 如果是符号，分两种
            // 1. 符号栈为空，则直接入栈
            // 2. 符号栈不为空，则对比：
            // 2.1 当前操作符的优先级小于或等于栈中的操作符，需从数栈中pop出两个数，再从符号栈中pop出一个符号，进行运算，入数栈，当前操作符入操作符栈
            // 2.2 当前操作符的优先级大于栈中的操作符，就直接入符号栈
            char c = expression.charAt(i);
            int unicodePoint = expression.codePointAt(i);
            if (unicodePoint < 48 || unicodePoint > 57) {
                //符号
                if (operatorStack.empty() || operatorPriority(c) > operatorPriority(operatorStack.peek())) {
                    operatorStack.add(c);
                } else {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    char operator = operatorStack.pop();
                    int calc = calc(num2, num1, operator);
                    numStack.add(calc);
                    operatorStack.add(c);
                }
            } else {
                numStack.add(Integer.valueOf(String.valueOf(c)));
            }
        }

        // 表达式扫描完毕，就顺序从数栈和符号栈中pop出相应的数和符号，并运行。
        // 最后一个数栈的数字就是结果
        while (!operatorStack.empty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char operator = operatorStack.pop();
            int calc = calc(num2, num1, operator);
            numStack.add(calc);
        }
        System.out.println("result=" + numStack.peek());

    }

    public static int calc(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new RuntimeException("invalid operator");
        }
    }

    public static int operatorPriority(char operator) {
        int result = 0;
        switch (operator) {
            case '+':
            case '-':
                result = 1;
                break;
            case '*':
            case '/':
                result = 2;
                break;
        }
        return result;
    }
}
