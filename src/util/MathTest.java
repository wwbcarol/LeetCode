package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;



public class MathTest {
	
//	HashMap<Integer, String> b;

	
	public static void main(String[] args) {
		MathTest a = new MathTest();
		System.out.println(a.divide(-1010369383, -2147483648));
		
	}
	
	public int divide(int dividend, int divisor) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        long a;
        long b;
        boolean isN = false;
        if(dividend<0){
            a = -(long)dividend;
            isN = !isN;
        }else
            a = dividend;
        
        System.out.println("a:"+a);;
        if(divisor<0){
        	System.out.println("ss");
            b = -(long)divisor;
            isN = !isN;
        }else
            b = divisor;
        System.out.println("b:"+b);
        
        if(isN) return -divideHelp(a, b);
        else return divideHelp(a, b);
    }
    
    public int divideHelp(long dividend, long divisor){
    	
    	System.out.println(dividend + "," + divisor);
        if(dividend<divisor) return 0;
        long tmp = divisor;
        long pre = divisor;
        int n = 1;
        int pren = n;
        
        while(dividend>=divisor){
            pre = divisor;
            divisor = divisor << 1;
            pren = n;
            n = n << 1;
        }
        System.out.println(pren);
        return pren + divideHelp(dividend-pre, tmp);
    }
}

