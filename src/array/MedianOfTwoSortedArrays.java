package array;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] A = {1, 2};
		int[] B = {1, 2};
		
		System.out.println("final:"+findMedianSortedArrays(A, B));
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        
        if((m+n)%2==0){
            return (findKth(A, 0, B, 0, (m+n)/2) + findKth(A, 0, B, 0, (m+n)/2+1))/2.0;
        }else{
            return (double)findKth(A, 0, B, 0, (int)Math.ceil((m+n)/2));
        }
    }
    
    public static int findKth(int A[], int m, int B[], int n, int k){
    	
        if(A.length-m>B.length-n) return findKth(B, n, A, m, k);
        if(m>=A.length) return B[n+k];
        if(n>=B.length) return A[m+k];
        if(k==0) return Math.min(A[m], B[n]);
        
        int pa = m + Math.min(A.length-1-m, k/2);
//        System.out.println("pa:" + pa);
        int pb = k - (pa-m)+n - 1;
        
        if(A[pa]>B[pb]){
            return findKth(A, m, B, pb+1, k-(pb-n)-1);
        }else{
            return findKth(A, pa+1, B, n, k-(pa-m)-1);
        }
        
        
    }
}
