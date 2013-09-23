package string;

public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber a = new ValidNumber();
		double aa = 1e1;
		String string = ".";
		System.out.println(string+": "+a.isNumber(string));
	}
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length()<1) return false;
		boolean start = false;
		boolean isPoint = false;
		boolean isEx = false;
		boolean hasNum = false;
		boolean ExNum = false;
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(start==false){
        		if (c == '.') {
        			if(isPoint == true||isEx == true) return false;
					isPoint = true;
					start = true;
				}
        		else if(c=='+'||c=='-'){
        			start = true;
        		}
        		else if(c>='0'&&c<='9'){
        			if(isEx == true) ExNum = true;
        			start = true;
        			hasNum = true;
        		}
        		else return false;
        	}else{
        		if(c>='0'&&c<='9'){
        			if(isEx == true)ExNum = true;
        			hasNum = true;
        		}else if(c == '.'){
        			if(isPoint == true||isEx == true) return false;
        			isPoint = true;
        		}else if(c == 'e'){
        			if(hasNum==false||isEx == true) return false;
        			else{
        				isEx = true;
        				start = false;
        			}
        		}else{
        			return false;
        		}
        	}
        }
        
        if(hasNum==false)return false;
        if(isEx == true&&ExNum==false){
        	return false;
        }
        return true;
		
    }
}
