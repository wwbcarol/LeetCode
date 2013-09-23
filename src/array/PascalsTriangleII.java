package array;

import java.util.ArrayList;

public class PascalsTriangleII {

	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<rowIndex+1;i++){
            if(i==0){
                list.add(1);
            }else{
                int size = list.size();
                list.add(1);
                for(int j=0;j<size-1;j++){
                    list.add(list.get(0)+list.get(1));
                    list.remove(0);
                }
                list.remove(0);
                list.add(1);
            }
        }
        
        return list;
    }
	
}
