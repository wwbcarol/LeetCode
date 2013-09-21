package util;

import java.util.Arrays;

public class MathTest {

	public static void main(String[] args) {
		int[] a = new int[]{3,2,5};
		
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}

}
