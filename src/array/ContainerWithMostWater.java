package array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] n = new int[]{2,5,3};
		ContainerWithMostWater a = new ContainerWithMostWater();
		System.out.println(a.maxArea(n));
	}
	public int maxArea(int[] height) {
		
		int left = 0, right = height.length-1;
		int MaxArea = Math.min(height[left], height[right])*(right-left);
		while(left<right){
			
			int curArea = Math.min(height[left], height[right])*(right-left);
			
			if(curArea>MaxArea)
				MaxArea = curArea;
			
			
			if(height[left]<height[right]){
				
				int curLeft = height[left];
				
				do{
					left++;
					
				}while(height[left]<curLeft);
				
			}else{
				int curRight = height[right];
				
				do{
					right--;
					
				}while(height[right]<curRight);
			}
		}
        return MaxArea;
    }
}
