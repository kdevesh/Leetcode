import java.util.*;
public class InfixToPostFix {
    public static String infixToPostFix(String s){
        String exp = "";
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            if(isNumeric(s.charAt(i)+"")) {
                if(count==0)
                    exp += " "+s.charAt(i);
                else
                    exp += s.charAt(i) + "";
                count++;
            }
            else if(s.charAt(i)=='(') {
                st.push(s.charAt(i));
                count=0;
            }
            else if(isOperator(s.charAt(i))) {
                while(!st.isEmpty()&&isOperator(st.peek()))
                    exp+=" "+st.pop();
                st.push(s.charAt(i));
                count=0;
            }
            else if(s.charAt(i)==')')
            {
                while(!st.isEmpty()&&st.peek()!='(')
                    exp+=" "+st.pop();
                st.pop();
                count=0;
            }
        }
        while(!st.isEmpty())
            exp+=" "+st.pop();
        return exp;
    }
    public static boolean isNumeric(String num){
        try{
            Integer.parseInt(num);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
    public static boolean isOperator(char ch){
        if(ch=='+' || ch=='-')
            return true;
        return false;
    }
    public static int calculate(String s) {
        String exp = infixToPostFix(s);
        if(!exp.contains("+")&&!exp.contains("-"))
            return Integer.parseInt(exp);
        else
            return evalRPN(infixToPostFix(s).split(" "));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(isNumeric(tokens[i])){
                st.push(Integer.parseInt(tokens[i]));
            }
            if(!isNumeric(tokens[i])&&!tokens[i].isEmpty()){
                int x = st.pop();
                int y = st.pop();
                if(tokens[i].equals("+"))
                    st.push(y+x);
                else
                    st.push(y-x);
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        System.out.println(InfixToPostFix.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(InfixToPostFix.calculate("1-11+12-8+90"));
    }
}
