package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

public class Sum3 {

	public static void main(String[] args) {
		Sum3 a = new Sum3();
		
		int[] num = new int[]{0,0,0,0};
		ArrayList<ArrayList<Integer>> r = a.threeSum(num);
		
		for (ArrayList<Integer> arrayList : r) {
			for(int i=0;i<arrayList.size();i++){
				System.out.print(arrayList.get(i)+" ");
			}
			System.out.println("");
		}
	}
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		int lastI = 0;
		for(int i=0; i<num.length-2;i++){
			if (i!=0&&num[i] == lastI) {
				continue;
			}
			int left = i+1;
			int right = num.length-1;
			while(left<right){
				if(num[left]+num[right]<-num[i]){
					left++;
				}else if(num[left]+num[right]>-num[i]){
					right--;
				}else{
					
					ArrayList<Integer> aList = new ArrayList<Integer>();
					aList.add(num[i]);
					aList.add(num[left]);
					aList.add(num[right]);
					if(result.size()!=0){
						ArrayList<Integer> lastList = result.get(result.size()-1);
						if (!(lastList.get(1) == num[left] && lastList.get(2) == num[right])) {
							result.add(aList);
						}
					}else{
						result.add(aList);
					}
					left++;
					right--;
				}
			}
			lastI = num[i];
		}
        
		return result;
    }
}
