package util;

public class SelfRef {

	public static void main(String args[]) {
		int[] A = new int[5];
		search(A);
	}
	
	public static void search(int[] A){
		
		if(isFull(A)){
			for(int j=0;j<A.length;j++) System.out.print(A[j]);
			System.out.println("");
			return;
		}
		
		for(int i=0;i<A.length;i++){
			if(A[i]==0){
				for(int j=1;j<=9;j++){
					A[i] = j;
					if(isValid(A))search(A);
				}
			}
		}
		
	}
	
	public static boolean isValid(int[] A){
		for(int j=0;j<A.length;j++){
			if(A[j]!=j+1&&A[j]!=0) return false;
		}
		return true;
	}
	
	public static boolean isFull(int[] A){
		for(int i=0;i<A.length;i++) if(A[i]==0)return false;
		return true;
	}
}