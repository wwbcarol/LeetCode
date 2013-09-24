package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	
	public static void main(String[] args) {
		Subsets a = new Subsets();
		int[] S = new int[]{1,2,3};
		ArrayList<ArrayList<Integer>> r = a.subsets(S);
		
		for(int i=0;i<r.size();i++){
			for(int j=0;j<r.get(i).size();j++){
				System.out.print(r.get(i).get(j)+" ");
			}
			System.out.println("");
		}
	}
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsets(S, 0);
    }
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S, int beginindex) {
        
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (beginindex==S.length-1) {
			ArrayList<Integer> listForOne = new ArrayList<Integer>();
			listForOne.add(S[beginindex]);
			lists.add(listForOne);
			lists.add(new ArrayList<Integer>());
		}else{
			// add [1 + subsets[n-1]]
			ArrayList<ArrayList<Integer>> listsFromRecursion = subsets(S, beginindex+1);
			if (listsFromRecursion!=null) {
				for(int i=0;i<listsFromRecursion.size();i++){
					@SuppressWarnings("unchecked")
					ArrayList<Integer> listFromRecursion = (ArrayList<Integer>) listsFromRecursion.get(i).clone();
					lists.add(listsFromRecursion.get(i));
					listFromRecursion.add(0, S[beginindex]);
					lists.add(listFromRecursion);
				}
			}
			
			
		}
		
		return lists;
        
    }
}
