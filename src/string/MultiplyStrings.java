package string;

import java.math.BigDecimal;

public class MultiplyStrings {

	public static void main(String[] args) {
		String s = multiply("0", "0");
		System.out.println(s);
	}
	public static String multiply(String num1, String num2){
		if (num1.length()>num2.length())
			return multiplyOrder(num1, num2);
		else
			return multiplyOrder(num2, num1);
	}
	
	
	public static String multiplyOrder(String num1, String num2){
		StringBuffer s = new StringBuffer();
		StringBuffer n1 = new StringBuffer(num1);
		int Ncount = 0;
		if(num1.charAt(0) == '-'){
			Ncount++;
			n1.deleteCharAt(0);
		}
		for(int i=0;i<num2.length();i++){
			if(num2.charAt(i) == '-')
				Ncount++;
			else{
				StringBuffer tmp = new StringBuffer(multiplyOne(n1.toString(), num2.charAt(i)));
				s.append(0);
				s = new StringBuffer(add(tmp.toString(),s.toString()));
			}
		}
		return Ncount%2==0?s.toString():s.insert(0, '-').toString();
	}
	
	public static String multiplyOne(String num, char c){
		StringBuffer s = new StringBuffer();
		int m = c-'0';
		if(m==0||num.equals("0"))return "0";
		int carry = 0;
		for(int i=num.length()-1;i>=0;i--){
			int n = num.charAt(i)-'0';
			s.append((n*m+carry)%10);
			carry = (n*m+carry)/10;
		}
		if(carry!=0)s.append(carry);
		return s.reverse().toString();
	}
	public static String add(String num1, String num2){
		
		StringBuffer s = new StringBuffer();
		int carry = 0;
		for(int i = num1.length()-1,j = num2.length()-1;i>=0||j>=0;i--,j--){
			int n1 = i<0?0:num1.charAt(i)-'0';
			int n2 = j<0?0:num2.charAt(j)-'0';
			s.append((n1+n2+carry)%10);
			carry = (n1+n2+carry)/10;
		}
		if(carry!=0)s.append(carry);
		return s.reverse().toString();
	}
	
	
//    public static String multiply(String num1, String num2) {
//		
//    	BigDecimal n1 = parse(num1);
//    	BigDecimal n2 = parse(num2);
//    	
//    	return n1.multiply(n2).toString();
//    	
//    }
//    
//    public static BigDecimal parse(String num){
//    	BigDecimal n = BigDecimal.ZERO;
//    	BigDecimal m = BigDecimal.ZERO;
//    	BigDecimal power = BigDecimal.valueOf(0.1);
//    	boolean isIntPart = true;
//    	boolean isNegative = false;
//    	for(int i=0;i<num.length();i++){
//
//			if(num.charAt(i) == '-'){
//				isNegative = true;
////				n = n.multiply(BigDecimal.valueOf(-1));
//			}else if(num.charAt(i) == '.'){
//				isIntPart = false;
//			}else{
//				if(isIntPart == true){
//					n = (n.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(num.charAt(i)-'0'));
//				}else{
//					m = m.add(power.multiply(BigDecimal.valueOf(num.charAt(i)-'0')));
//					power = power.multiply(BigDecimal.valueOf(0.1));
//				}
//			}
//    	}
//    	
//    	if(isNegative == true)
//    		return n.add(m).multiply(BigDecimal.valueOf(-1));
//    	else
//    		return n.add(m);
//    }
	
}
