package string;

public class AddBinary {
	
	public static void main(String[] args) {
		AddBinary a = new AddBinary();
		
		System.out.println(a.addBinary("1", "1"));
	}

	public String addBinary(String a, String b) {
        StringBuffer s = new StringBuffer();
        
        int carry = 0;
        for(int i = a.length()-1,j = b.length()-1;i>=0||j>=0;i--,j--){
        	
        	int n1 = i>=0?a.charAt(i) - '0':0;
        	int n2 = j>=0?b.charAt(j) - '0':0;
        	
        	s.append((n1+n2+carry)%2);
        	carry = (n1+n2+carry)/2;
        	
        }
        if(carry!=0)s.append(carry);
        return s.reverse().toString();
    }
}
