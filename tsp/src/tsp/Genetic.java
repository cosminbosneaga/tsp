package tsp;

import java.util.ArrayList;
import java.util.Random;

public class Genetic {
	
	private static double sigma;
	private static int success, step, size;
	private static ArrayList<Double> newPopulation = new ArrayList<Double>();
	private static ArrayList<Double> currentPopulation = new ArrayList<Double>();
	private static ArrayList<Double> deviation = new ArrayList<Double>();
	
	public static void evolutionary(int n){
		
		// step 1, generate random population
		Genetic.generateCurrentPopulation(4,0,500);
		
		initialize();
		do{
			// step 2+3
			Genetic.generateNewPopulation();
			
			// step 4
			successful();
			
			//step 5 
			adaptStepSize();
			
			n--;
		}while(n>0);
		
		
	}
	
	public static void initialize(){
		sigma = 1;
		step = 0;
		success = 0;
		size = currentPopulation.size();
	}
	
	public static void generateCurrentPopulation(int n,int min, int max){
		for(int i=0;i<n*2;i++){
			Random rnd = new Random();
			double var = min + (max-min)*rnd.nextDouble();
			currentPopulation.add(var);
		}
		System.out.println("generated:"+currentPopulation.toString());
	}
	
	public static void generateDeviations(int n){
		for(int i=0;i<size;i++){
			Random rnd = new Random();
			deviation.add(rnd.nextGaussian());
		}
	}
	
	public static void generateNewPopulation(){
		for(int i=0;i<size;i++){
			Random rnd = new Random();
			double deviation = rnd.nextGaussian();
			newPopulation.add(currentPopulation.get(i)+deviation*sigma);
		}
		step++;
		System.out.println("deviated:"+newPopulation.toString());
	}
	
	public static void successful(){
		if( fitness(newPopulation) >= fitness(currentPopulation)){
			//copy newPopulation as current
			currentPopulation = new ArrayList<Double>(newPopulation);
			newPopulation = new ArrayList<Double>();
			System.out.println("Fitness good");
			success++;
		}else{
			newPopulation = new ArrayList<Double>();
		}
	}
	
	public static void adaptStepSize(){
		if( step == size ){
			step = 0;
			if( success/size > 1/5 ){
				sigma*=2;
				System.out.println("step size double");
			}
			else{
				sigma/=2;
				System.out.println("step size half");
			}
			success = 0;
		}
	}
	
	public static double fitness(ArrayList<Double> population){
		double heuristic=0, optimal =0;
		
		NodeList.removeAll();
		for(int i=0;i<size;i+=2){
			//System.out.println(population.get(i)+","+population.get(i+1));
			Node city = new Node(population.get(i), population.get(i+1));
	        NodeList.addNode(city);
		}
		
		// Create distance matrix
		Adjacency.createMatrix();
		// Calculate path using nearest neighbour first method
		NNF.findPath();
		heuristic = Tour.printTour();
		
		ArrayList<Integer> set = new ArrayList<Integer>(); //Create an ArrayList
        for(int i=0;i<NodeList.size();i++){
        	set.add(i);
        }
        set.remove(0);
		optimal = new Min(1, set).getMin();
		//calculate heuristic
		//calculate optimal
		System.out.println("heuristic:"+heuristic+"...optimal:"+optimal);
		return heuristic-optimal;
	}
	

}
