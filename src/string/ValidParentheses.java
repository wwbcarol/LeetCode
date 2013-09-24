package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses a = new ValidParentheses();
		
		System.out.println(a.isValid("([)]"));
	}
	public boolean isValid(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for(int i=0;i<s.length();i++){
        	Character c = s.charAt(i);
        	
        	if(map.containsValue(c)){
        		list.add(c);
        	}else if(map.containsKey(c)&&list.size()>0){
        		if(list.get(list.size()-1) == map.get(c)){
        			list.remove(list.size()-1);
        		}else {
					return false;
				}
        	}else{
        		return false;
        	}
        }
        return list.isEmpty()?true:false;
    }
	
}
