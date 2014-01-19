package array;

import java.util.ArrayList;

public class PlusOne {
	public static void main(String[] args) {
		int[] n = new int[]{1, 0};
		PlusOne a = new PlusOne();
		int[] m = a.plusOne(n);
		for(int i=0;i<m.length;i++){
			System.out.print(m[i] + " ");
		}
	}
	public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int carry = 0;
        for(int i=digits.length-1;i>=0;i--){
            if(i==digits.length-1){
                list.add(0,(digits[i]+1)%10);
                carry = ((digits[i]+1)/10);
            }else{
                list.add(0,(digits[i]+carry)%10);
                carry = ((digits[i]+carry)/10);
            }
            
        }
        
        if(carry!=0)list.add(0,carry%10);
        System.out.println(list);
        int[] r = new int[list.size()];
        for(int i=0;i<list.size();i++){
            r[i] = list.get(i);
        }
        return r;
    }

}
