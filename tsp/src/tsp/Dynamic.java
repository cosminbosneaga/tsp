package tsp;

import java.util.ArrayList;

public class Dynamic {

	static int size = NodeList.size();
	private static ArrayList<Integer> subset = new ArrayList<Integer>();
	private static ArrayList<Integer> set = new ArrayList<Integer>();
	private static ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public static void findPath(){
		
		int subsetSize = 2;
		for( int i = 0; i<size ; i++){
			for( int j = 0; j<size; j++){
				
			}
		}
		
		int start = 0;
		int end = size-1;
	}
	public static double min=9999;
	
	public static double dinam(int first, ArrayList<Integer> set, double total){
		
		if( set.size() > 0){
			
			for(int j=0;j<set.size();j++){
				
				ArrayList<Integer> newset = new ArrayList<Integer>(set);
				System.out.println("f("+first+",{"+set.toString()+"})");
				total += Node.edge(NodeList.findNode(first), NodeList.findNode(newset.get(j)));
				
				int first1 = newset.get(j);
				newset.remove(j);
				System.out.println("total is:"+total);
				total+=dinam(first1,newset,total);
				
			}
		}
		else{
			total += Node.edge(NodeList.findNode(first), NodeList.findNode(0));
			System.out.println("f("+first+",{"+set.toString()+"})");
			System.out.println("total is:"+total);
			if(total<min){
				min=total;
				total=0;
			}
		}
		
		return 0;
		
	}
	
	public static void autoSet(int start, int end){
		subset = new ArrayList<Integer>();
		for(int i=start; i<= end; i++){
			subset.add(i);
		}
		
		
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set, int n) {

        ArrayList<ArrayList<Integer>> allsubsets =
        new ArrayList<ArrayList<Integer>>();
        //int max = 1 << set.size();             //arithmetic shift
        int max = (int) Math.pow(2, set.size());
        System.out.println(max);
        for (int i = 1; i < max; i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 1; j < set.size(); j++) {
                if ( (( (i / (int)(Math.pow(2,j))) ) & 1) == 1) {
            	//if( (i / (int)(Math.pow(2,j)))  == 1){
                    subset.add(set.get(j));
                }
            }
            
           // if(subset.size()==n){
            	allsubsets.add(subset);
           // }
            
        }
        return allsubsets;
    }
	
	public static void pri(ArrayList<Integer> set){
		int n=set.size(),k;
		for(int i =0; i<n;i++){
			set.add(i);
		}
		
		for(int i=0;i<n;i++){
			subset.add(set.get(i));
			k = subset.size();
			
			do{
				System.out.println();
				for(int j=0;j<subset.size();j++){
					System.out.print(subset.get(j)+" ");
				}
			}while(combinations(set,subset,n,k));
		}
	}
	
	public static boolean combinations(ArrayList<Integer> set, ArrayList<Integer> subset, int n, int k){
		
		boolean finished=false, changed=false;
		int i,j,h;
		for( i = k-1 ; !finished && !changed ; i--){
			
			if(subset.get(i) < set.get(i+(n-k))){
				
				for( j = 0; set.get(j) <= subset.get(i); j++);
				subset.set(i, set.get(j));
					
				if( i < k-1 ){
					for( h = i+1, j=j+1; h<k ; h++, j++){
						subset.set(h,set.get(j));
					}
				}
					
				changed = true;
			}
			
			if(i == 0){
				finished = true;
			}
		}
		
		if( !changed ){
			for( i=0; i<k ;i++){
				subset.set(i,set.get(i));
			}
		}
		
		return changed;
	}
	
	public static void rec(int start, int end, int position, int subsetSize){
		
		if(subset.size() == subsetSize){
			
			for(int i = 0; i<subset.size();i++){
	    		System.out.print(subset.get(i));
	    	}
			System.out.println();
			subset.remove(subsetSize-1);
		}
		
		if( end+1 < size){
			end++;
			subset.add(end);
			rec(start,end,position,subsetSize);
		}
		else{
			if( start+2 < size){
				start++;
				end=start+1;
				autoSet(start,end);
				
				rec(start,end,position,subsetSize);
			}
			else{
				
				if( subsetSize+1 != size ){
				
					subsetSize++;
				
					autoSet(0,subsetSize-1);
					rec(start,subsetSize-1,position,subsetSize);
				}
			}
		}
		
	}
	
	
}
