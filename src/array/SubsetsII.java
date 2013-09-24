package array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
	
	public static void main(String[] args) {
		SubsetsII a = new SubsetsII();
		int[] S = new int[]{1,2,2,2};
		ArrayList<ArrayList<Integer>> r = a.subsetsWithDup(S);
		
		for(int i=0;i<r.size();i++){
			for(int j=0;j<r.get(i).size();j++){
				System.out.print(r.get(i).get(j)+" ");
			}
			System.out.println("---");
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        
        r.add(new ArrayList<Integer>());
        
        int start = 0;
        for(int i=0;i<num.length;i++){
        	
        	int size = r.size();
        	for(int j=start;j<size;j++){
        		ArrayList<Integer> sub = new ArrayList<Integer>(r.get(j));
        		sub.add(num[i]);
        		r.add(sub);
        	}
        	
        	if(i<num.length-1&&num[i]==num[i+1])
        		start = size;
        	else
        		start = 0;
        	
        }
        
        return r;
        
    }

}
