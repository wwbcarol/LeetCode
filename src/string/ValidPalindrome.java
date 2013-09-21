package string;

import java.util.ArrayList;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		ValidPalindrome a = new ValidPalindrome();
		
		System.out
				.println(a.isPalindrome("1a2"));
	}

	public boolean isPalindrome(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        
        for(int i=0;i<s.length();i++){
        	if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
        		list.add(s.charAt(i));
        	}else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
        		list.add((char)(s.charAt(i)-'A'+'a'));
        	}
        }
        
//        for(int i=0;i<list.size();i++){
//        	System.out.print(list.get(i));
//        }
//        System.out.println("");
        
        for(int i=0;i<list.size()/2;i++){
        	if(list.get(i) != list.get(list.size()-i-1))
        		return false;
        }
        
        return true;
    }
}
