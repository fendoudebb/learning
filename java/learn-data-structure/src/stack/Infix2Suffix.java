package stack;

import java.util.Stack;

/**
 * 中缀表达式转后缀表达式(逆波兰表达式)
 *
 */
public class Infix2Suffix {

    public static void main(String[] args) {
        String infixExpression = "1+((2+3)*4)-5";

        // 初始化两个栈：运算符栈s1和储存中间结果的栈s2
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        // 从左至右扫描中缀表达式
        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);
            String item = String.valueOf(c);
            if (item.matches("\\d")) {
                // 遇到数字时，将其压s2
                s2.add(c);
            } else if (item.equals("(")){
                s1.add(c);
            } else if (item.equals(")")) {
                while (!String.valueOf(s1.peek()).equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (!s1.empty() && operatorPriority(s1.peek()) >= operatorPriority(c)) {
                    s2.add(s1.pop());
                }
                s1.push(c);
            }
            // 遇到运算符时，比较其与s1栈顶运算符的优先级
            // 1. 若s1为空，或栈顶运算符为左括号"("，或优先级比栈顶运算符的高，则直接将此运算压入s1中
            // 2. 否则，将符号栈栈顶的运算符弹出并压入到s2中，再次转到(1)与s1中新的栈顶运算符相比较


            //遇到括号时：
            // 1. 如果是左括号"("，则直接压入s1
            // 2. 如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
        }
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        System.out.println(s2.toString());
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
