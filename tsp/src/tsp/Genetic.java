package tsp;

import java.util.ArrayList;
import java.util.Random;

public class Genetic {
	
	private static double sigma;
	private static int success, step, size;
	private static ArrayList<Double> newPopulation = new ArrayList<Double>();
	private static ArrayList<Double> currentPopulation = new ArrayList<Double>();
	private static ArrayList<Double> deviation = new ArrayList<Double>();
	private static Random rnd;
	
	public static void initialize(){
		sigma = 1;
		step = 0;
		success = 0;
		size = currentPopulation.size()*2;
	}
	
	public static void generateCurrentPopulation(int n){
		for(int i=0;i<n*2;i++){
			currentPopulation.add(rnd.nextDouble());
		}
	}
	
	public static void generateDeviations(int n){
		for(int i=0;i<size;i++){
			deviation.add(rnd.nextGaussian());
		}
	}
	
	public static void generateNewPopulation(){
		for(int i=0;i<size;i++){
			double deviation = rnd.nextGaussian();
			newPopulation.add(currentPopulation.get(i)+deviation*sigma);
		}
	}
	
	public static void successful(){
		if( fitness(newPopulation) >= fitness(currentPopulation)){
			//copy newPopulation as current
			success++;
		}
	}
	
	public static void adaptStepSize(){
		if( step == size ){
			step = 0;
			if( success/size > 1/5 ){
				sigma*=2;
			}
			else{
				sigma/=2;
			}
			success = 0;
		}
	}
	
	public static double fitness(ArrayList<Double> population){
		double heuristic=0, optimal =0;
		
		//calculate heuristic
		//calculate optimal
		
		return heuristic-optimal;
	}
	

}
