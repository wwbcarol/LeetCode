package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram a = new LargestRectangleInHistogram();
		System.out.println(a
				.maximalRectangle(new char[][] {"0111".toCharArray(), "1110".toCharArray()}));
	}
	
	public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] his = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    his[i][j] = matrix[i][j]-'0';
                }else{
                    if(matrix[i][j]=='1')his[i][j] = 1 + his[i-1][j];
                    else his[i][j] = 0;
                }
            }
        }
        
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		System.out.print(his[i][j] + " ");
        	}
        	System.out.println("");
        }
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int maxI = largestRectangleArea(his[i]);
            if(maxI>maxArea) maxArea = maxI;
        }
        
        return maxArea;
    }
	public static int largestRectangleArea(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for(int i=0;i<height.length;){
			if(s.isEmpty()||height[i]>=height[s.peek()]){
				s.push(i);
//				System.out.println("push:" + i);
				i++;
			}else{
				int peek = s.pop();
//				System.out.println("pop:" + peek+", height:"+height[peek]);
//				System.out.println("Area:" + height[peek] * (i - peek));
//				System.out.println("Max before: " + maxArea);
				int width = s.isEmpty()?i:i-s.peek()-1;
				maxArea = Math.max(height[peek]*width, maxArea);
			}
		}
		
		while(!s.isEmpty()){
			int peek = s.pop();
//			System.out.println("pop:" + peek+", height:"+height[peek]);
//			System.out.println("Area:" + height[peek] * (height.length - peek));
//			System.out.println("Max before: " + maxArea);
			int width = s.isEmpty()?height.length:height.length-s.peek()-1;
			maxArea = Math.max(height[peek]*width, maxArea);
		}
		
		return maxArea;
    }
	
}
