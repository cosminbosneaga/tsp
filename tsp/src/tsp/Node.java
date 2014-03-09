package tsp;

public class Node {
	
	int x;
    int y;
    
    // create a random new node
    public Node(){
    	this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // create a new node at location
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // get x coordinate
    public int getX(){
        return this.x;
    }
    
    // get y coordinate
    public int getY(){
        return this.y;
    }
    
    public static double edge(Node n1, Node n2){
    	int dx = n1.getX() - n2.getX();
    	int dy = n1.getY() - n2.getY();
    	
    	return Math.sqrt(dx*dx+dy*dy);
    }
    
}
