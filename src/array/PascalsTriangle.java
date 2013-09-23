package array;

import java.util.ArrayList;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		PascalsTriangle a = new PascalsTriangle();
		
		ArrayList<ArrayList<Integer>> r = a.generate(3);
		
		for(int i=0;i<r.size();i++){
			
			System.out.print("[");
			for(int j=0;j<r.get(i).size()-1;j++){
				System.out.print(r.get(i).get(j) + ",");
			}
			System.out.println(r.get(i).get(r.get(i).size() - 1) + "]");
		}
		
		
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<numRows;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (i == 0) {
				list.add(1);
				r.add(list);
			}else{
				ArrayList<Integer> lastList = r.get(i-1);
				list.add(1);
				for(int j=0;j<lastList.size()-1;j++){
					list.add(lastList.get(j)+lastList.get(j+1));
				}
				list.add(1);
				r.add(list);
			}
		}
		
		return r;
    }
	
}
