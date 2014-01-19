package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class test{
	Integer a;
	Integer b;
}

public class Subset {
	
	public static void main(String[] args) {
		int[] s = new int[]{1,2,3};

		Set<Integer> set = new HashSet<Integer>();

		for (int i : s) {
			set.add(i);
		}

		Subset a = new Subset();
//		System.out.println(set.size());
		Set<Set<Integer>> r = a.powerSets(set);
		
//		System.out.println(r.size());
		for (Set<Integer> set2 : r) {
			for (Integer integer : set2) {
				System.out.print(integer + " ");
			}
			System.out.println("");
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		
		Set<Integer> input = new HashSet<Integer>();
		for (Integer integer : S) {
			input.add(integer);
		}
		
		Set<Set<Integer>> result = powerSets(input);
		
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		
		for (Set<Integer> set : result) {
			ArrayList<Integer> subarray	 = new ArrayList<Integer>();
			
			for (Integer integer : set) {
				subarray.add(integer);
			}
			
			r.add(subarray);
		}
		return r;
	}
//	
//	public Set<Set<E>> name() {
//		Integer min = Integer.MIN_VALUE;
//	    public boolean isValidBST(TreeNode root) {
//	        if(root == null) return true;
//	        if(!isValidBST(root.left)) return false;
//	        
//	        if(root.val<=min) return false;
//	        else min = root.val;
//
//	        if(!isValidBST(root.right)) return false;
//	        
//	        return true;
//	    }
//	}
	
	public <E> Set<Set<E>> powerSets(Set<E> input){

		Set<Set<E>> list = new HashSet<Set<E>>();
		if(input.size()==0){
			list.add(new HashSet<E>());
			return list;
		}

		E item = input.iterator().next();
		input.remove(item);

		Set<Set<E>> subSets = powerSets(input);
		
		for(Set<E> sets : subSets){
			
			Set<E> temp = new HashSet<E>();
			for(E element : sets){
				temp.add(element);
			}	
			temp.add(item);
			list.add(temp);
		} 
		list.addAll(subSets);

		return list;

	}

	public <E> void displey(Set<Set<E>> set){
		for (Set<E> set2 : set) {
			for (E e : set2) {
				System.out.print(e + " ");
			}
			System.out.println("");
		}
	}
//	public <E> Set<Set<E>> powerSets(Set<E> set){
//		Set<Set<E>> list = new HashSet<Set<E>>();
//		
//		list.add(new HashSet<E>());
//		for (E element : set) {
//			Set<Set<E>> tmplist = new HashSet<Set<E>>();
//			for (Set<E> subset : list) {
//				Set<E> newSet = new HashSet<E>(subset);
//				newSet.add(element);
//				tmplist.add(newSet);
//			}
//			list.addAll(tmplist);
//		}
//		
//		return list;
//	}
}
