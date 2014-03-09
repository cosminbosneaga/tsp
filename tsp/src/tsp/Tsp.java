package tsp;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Tsp {

	public static void main(String[] args) {
		
		Node n = new Node(47,15);
		NodeList.addNode(n);
		
		Node n1 = new Node(35,26);
		NodeList.addNode(n1);
		
		Node n2 = new Node(12,30);
		NodeList.addNode(n2);
		
		Node n3 = new Node(1,60);
		NodeList.addNode(n3);
		/*
		Node n4 = new Node(15,68);
		NodeList.addNode(n4);
		
		Node n5 = new Node(56,55);
		NodeList.addNode(n5);
		
		Node n6 = new Node(94,80);
		NodeList.addNode(n6);
		*/
		
		/*
		Node city = new Node(60, 200);
        NodeList.addNode(city);
        Node city2 = new Node(180, 200);
        NodeList.addNode(city2);
        Node city3 = new Node(80, 180);
        NodeList.addNode(city3);
        Node city4 = new Node(140, 180);
        NodeList.addNode(city4);
        Node city5 = new Node(20, 160);
        NodeList.addNode(city5);
        Node city6 = new Node(100, 160);
        NodeList.addNode(city6);
        Node city7 = new Node(200, 160);
        NodeList.addNode(city7);
        Node city8 = new Node(140, 140);
        NodeList.addNode(city8);
        Node city9 = new Node(40, 120);
        NodeList.addNode(city9);
        Node city10 = new Node(100, 120);
        NodeList.addNode(city10);
        Node city11 = new Node(180, 100);
        NodeList.addNode(city11);
        Node city12 = new Node(60, 80);
        NodeList.addNode(city12);
        Node city13 = new Node(120, 80);
        NodeList.addNode(city13);
        Node city14 = new Node(180, 60);
        NodeList.addNode(city14);
        Node city15 = new Node(20, 40);
        NodeList.addNode(city15);
        Node city16 = new Node(100, 40);
        NodeList.addNode(city16);
        Node city17 = new Node(200, 40);
        NodeList.addNode(city17);
        Node city18 = new Node(20, 20);
        NodeList.addNode(city18);
        Node city19 = new Node(60, 20);
        NodeList.addNode(city19);
        Node city20 = new Node(160, 20);
        NodeList.addNode(city20);
		*/
		
		Adjacency.createMatrix();
		
		Adjacency.printMatrix();
		
		NNF.findPath();
		
		Tour.printTour();
		//Dynamic.autoSet(0,1);
		//Dynamic.rec(0,1,1,2);
		
		//Dynamic.pri();
		
		ArrayList<Integer> set = new ArrayList<Integer>(); //Create an ArrayList
        for(int i=0;i<NodeList.size();i++){
        	set.add(i);
        }
        set.remove(0);
        System.out.println(set.toString());
        //System.out.println(Dynamic.getSubsets2(set,1));
        
        //int first = set.get(0);
		//set.remove(0);
        //Dynamic.dinam(first,set,0);
        //System.out.print(Dynamic.min);
        
        //Dynamic.pri(set);
        
        HashMap<String, ArrayList> seturi = new HashMap<String, ArrayList>();
        HashMap<String, ArrayList> seturi2 = new HashMap<String, ArrayList>();
        for(int i=0;i<set.size();i++){
        	ArrayList<Integer> subset = new ArrayList<Integer>();
        	subset.add(set.get(i));
        	seturi.put("f("+set.get(i)+")",subset);
        }
        
        System.out.println(seturi.toString());
        
        for(int i=0;i<set.size();i++){
        	ArrayList<Integer> subset = new ArrayList<Integer>();
        	
        	for(java.util.Map.Entry<String, ArrayList> entry : seturi.entrySet()) {
        	    String key = entry.getKey();
        	    ArrayList<Integer> value = entry.getValue();
        	    if(!value.contains(set.get(i))){
        	    	subset = new ArrayList<Integer>(value);
        	    	subset.add(0,set.get(i));
        	    	 System.out.println(subset.toString());
        	    	String functionName = "";
        	    	for(int k=0;k<subset.size();k++){
        	    		functionName = functionName + subset.get(k);
        	    	}
        	    	 System.out.println(functionName);
        	    	seturi2.put("f("+functionName+")",subset);
        	    }
        	}
        	
        }
        System.out.println(seturi2.toString());
        /*
        int size=2;
        int repeat=2;
        boolean found = false;
        ArrayList<ArrayList> subs = new ArrayList<ArrayList>();
        int j=set.get(0);
        System.out.println("set size:"+set.size());
        for ( int i = 0; i <set.size(); i++){
        	//System.out.print(set.get(i)+"-");
        	//int j=set.get(0);
        	repeat = 2;
        	while(repeat>0){
        		ArrayList<Integer> subset = new ArrayList<Integer>();
        		System.out.println("set: "+subset.toString());
        		System.out.println("j: "+j);
        		for( int k=0; k<size;k++){
        			found = false;
        			//ArrayList<Integer> subset = new ArrayList<Integer>();
        		
        			while(!found){
        				//System.out.println(set.get(i)+"_"+set.get(j)+"_"+subset.contains(new Integer(set.get(j))));
        				if(set.get(i)!=j && !subset.contains(new Integer(j))){
        					subset.add(j);
        					System.out.println("set: "+subset.toString());
        	        		System.out.println("j: "+j);
        					//System.out.println(set.get(i)+"="+j);
        					found = true;
        				}
        				j++;
        				
                		System.out.println("j: "+j);
        				if(j>set.size()){
        					j=set.get(0);
        				}
        				
                		System.out.println("j: "+j);
        				//System.out.println("da");
        			}
        			
        			if( subset.size() == size && !subs.contains(subset)){
        				System.out.println(set.get(i)+" "+subset.toString());
        				subs.add(subset);
        			}else
        			if( subset.size() ==size ){ 
        				k=0;
        				subset = new ArrayList<Integer>();
        			}
        	
        		}
        		System.out.println(subset.toString());
    			
        		if(!subs.contains(subset)){
    				System.out.println(set.get(i)+" "+subset.toString());
    				subs.add(subset);
    			}
        		repeat--;System.out.print("s");
        	}
        	
        	System.out.println();
        }
        */
        //System.out.println(subs.toString());
	}
}
