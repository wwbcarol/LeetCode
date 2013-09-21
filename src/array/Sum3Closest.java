package array;

import java.util.Arrays;

public class Sum3Closest {

	public static void main(String[] args) {
		Sum3Closest a = new Sum3Closest();
		
		int[] num = new int[]{1, -3, 3, 5, 4, 1};
		int r = a.threeSumClosest(num, 1);
		
		System.out.println(r);
	}
	
	public int threeSumClosest(int[] num, int target) {
        
		Arrays.sort(num);
		int minSum = num[0]+num[1]+num[2];
		int minOffset = Math.abs(target - minSum);
		for(int i=0;i<num.length-2;i++){
			
			int left = i+1;
			int right = num.length-1;
			while(left<right){
				
				int sum = num[i]+num[left]+num[right];
				int offset = Math.abs(target - sum);
				if(offset<minOffset){
					System.out.println(offset + "," + minOffset);
					System.out.println("---(" + num[i] + "," + num[left] + ","
							+ num[right] + ")");
					minSum = sum;
					minOffset = offset;
				}
				
				if(num[i]+num[left]+num[right]<target){
					left++;
				}else if(num[i]+num[left]+num[right]>target){
					right--;
				}else{
					return target;
				}
				

				
			}
		}
		
		return minSum;
        
    }
}
