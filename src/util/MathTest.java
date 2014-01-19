package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MathTest {
	
	public static void main(String[] args) {
		MathTest a = new MathTest();
		int[] num = new int[]{1, 0, -1, 0, -2, 2};
		int target = 0;
		ArrayList<ArrayList<Integer>> res = a.fourSum(num, target);
		for(ArrayList<Integer> list : res){
			for(Integer i : list){
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		
	}
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        ArrayList<pair> pairs = new ArrayList<pair>();
        for(int i=0;i<n-1;i++){
        	for(int j=i+1;j<n;j++){
        		pairs.add(new pair(num[i], num[j], i, j));
        	}
        }
        
        Collections.sort(pairs);
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(pairs.size()-1);
        
        Set<String> pairSet = new HashSet<String>();
        Set<String> ansSet = new HashSet<String>();
        while(!stack.isEmpty()){
        	int r = stack.pop();
        	int l = stack.pop();
        	if(l>=r) continue;
        	String s = "" + l +"_" + r;
        	if(pairSet.contains(s))continue;
        	else pairSet.add(s);
        	
        	pair p1 = pairs.get(l);
        	pair p2 = pairs.get(r);
        	int sum = p1.sum + p2.sum;
        	
        	if(sum > target){
        		stack.push(l);
        		stack.push(r-1);
        	}else if(sum < target){
        		stack.push(l+1);
        		stack.push(r);
        	}else{
        		// sum == target
        		if(p1.index1!=p2.index1&&p1.index1!=p2.index2&&p1.index2!=p2.index1&&p1.index2!=p2.index2){
        			ArrayList<Integer> oneAns = new ArrayList<Integer>();
        			oneAns.add(p1.num1);
        			oneAns.add(p1.num2);
        			oneAns.add(p2.num1);
        			oneAns.add(p2.num2);
        			Collections.sort(oneAns);
        			s = "";
        			for(int k = 0; k<4; k++) s += oneAns.get(k)+"_";
        			if(!ansSet.contains(s)){
        				ans.add(oneAns);
        				ansSet.add(s);
        			}
        		}
        		
        		stack.push(l);
        		stack.push(r-1);
        		stack.push(l+1);
        		stack.push(r);
        	}
        }
        return ans;
    }
    
                    
}

class pair implements Comparable<pair>{

	int num1;
	int num2;
	int index1;
	int index2;
	int sum;
	
	pair(int num1, int num2, int index1, int index2){
		this.num1 = num1;
		this.num2 = num2;
		this.index1 = index1;
		this.index2 = index2;
		this.sum = num1 + num2;
	}
	@Override
	public int compareTo(pair o) {
		if(this.sum<o.sum) return -1;
		if(this.sum>o.sum) return 1;
		return 0;
	}
	
	public String toString(){
		return "["+num1+", "+num2+"]"+" : "+sum+", ("+index1+", "+index2+")";
	}
	
}
