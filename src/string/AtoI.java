package string;

public class AtoI {

	public static void main(String[] args) {
		AtoI atoI = new AtoI();
		System.out.println(atoI.atoi("   +1+"));
		
	}
	public int atoi(String str) {
		
		boolean isStart = false;
		boolean isNegative = false;
		boolean isNumber = false;
		long num = 0;
		for(int i=0;i<str.length();i++){
			while(isStart==false&&str.charAt(i)==' ')i++;
			isStart = true;
			if(isNumber == true){
				if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
					num = num*10 + str.charAt(i)-'0';
				}else{
					break;
				}
			}else{
				if (str.charAt(i)=='-') {
					isNegative = true;
					isNumber = true;
				}else if(str.charAt(i) == '+'){
					isNegative = false;
					isNumber = true;
				}else{
					if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
						num = num*10 + str.charAt(i)-'0';
					}else{
						break;
					}
				}
			}
		}
		
		if (isNegative) {
			num = -num;
		}
		if(num>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(num<Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
        return (int)num;
    }
}
