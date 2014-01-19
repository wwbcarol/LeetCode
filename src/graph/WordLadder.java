package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadder {
	
public int ladderLength(String start, String end, HashSet<String> dict) {
        
        if(!dict.contains(start))dict.add(start);
        if(!dict.contains(end))dict.add(end);
        
        int n = dict.size();
        
        ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();
        String[] v = new String[n];
        
        int st=0, en=1;
        int i=0;
        
        for(String s:dict){
            
            if(s.equals(start)) st = i;
            if(s.equals(end)) en = i;
            v[i++] = s;
            
        }
        
        for(i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                if(i!=j&&isNeighbor(v[i], v[j])){
                    list.add(j);
                }
            }
            edge.add(list);
        }
        
        ArrayList<Integer> queue = new ArrayList<Integer>();
        ArrayList<Integer> length = new ArrayList<Integer>();
        boolean[] isVisit = new boolean[n];
        queue.add(st);
        length.add(0);
        isVisit[st] = true;
    
        while(queue.size()!=0){
            Integer num = queue.get(0);
            Integer level = length.get(0);
            queue.remove(0);
            length.remove(0);
            if(num==en) return level;
            for(Integer index : edge.get(num)){
                if(!isVisit[index]){
                    queue.add(index);
                    length.add(level+1);
                    isVisit[index] = true;
                }
            }
            
        }
        
        return 0;
    }
    
    public static boolean isNeighbor(String s1, String s2){
        int n = s1.length();
        int count = 0;
        for(int i=0;i<n; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count>=2) return false;
            }
        }
        return true;
    }

}
