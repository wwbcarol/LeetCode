package array;

public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] {}));
	}

public static int firstMissingPositive(int[] A) {
        
        for(int i=0;i<A.length;){
            if(A[i] != (i+1) && (A[i]>0&&A[i]<A.length) && A[A[i]-1] != A[i]){
                int tmp = A[i];
                A[i] = A[A[i]-1];
                A[tmp-1] = tmp;
            }else{
            	i++;
            }
            
            System.out.print("i:" + i);
            for(int j=0;j<A.length;j++){
            	System.out.print(A[j]+" ");
            }
            System.out.println("");
        }
        
        for(int j=0;j<A.length;j++){
        	System.out.print(A[j]+" ");
        }
        System.out.println("");
        for(int i=0;i<A.length;i++){
            if(A[i] != (i+1))
                return i+1;
        }
        
        return A.length+1;
    }
}
