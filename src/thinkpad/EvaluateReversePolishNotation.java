package thinkpad;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public static void main(String[] args) {
		String[] s = new String[]{"0", "3", "/"};
		System.out.println(evalRPN(s));
	}

	public static int evalRPN(String[] tokens) {
Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(s=="+"||s=="-"||s=="*"||s=="/"){
                int n1 = stack.pop();
                int n2 = stack.pop();
                if(s=="+")stack.push(n1+n2);
				if(s=="-")stack.push(n2-n1);
				if(s=="*")stack.push(n1*n2);
				if(s=="/")stack.push(n2/n1);
            }else stack.push(Integer.parseInt(s));
        }
        
        return stack.peek();
    }
}
