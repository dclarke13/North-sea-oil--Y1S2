import java.util.ArrayList;

public class Map {

	private ArrayList<Direction> NE;
	private ArrayList<Direction> NW;
	private ArrayList<Direction> SE;
	private ArrayList<Direction> SW;


	public Map(){
		NE = new ArrayList<Direction>();
		NW = new ArrayList<Direction>();
		SE = new ArrayList<Direction>();
		SW = new ArrayList<Direction>();
	}

	public Direction addNE (Direction direction){
        NE.add (direction); 
        return direction;
    }
	
	public Direction addNW (Direction direction){
        NW.add (direction); 
        return direction;
    }
	
	public Direction addSE (Direction direction){
        SE.add (direction);
        return direction;
    }
	
	public Direction addSW (Direction direction){
        SW.add (direction);
        return direction;
    }

    public ArrayList<Direction> getMapNE()
    {
    	return NE;
    }
    
	public ArrayList<Direction> getMapNW()
    {
      	return NW;
    }
    
	public ArrayList<Direction> getMapSE()
    {
    	return SE;
    }
	
	public ArrayList<Direction> getMapSW()
    {
    	return SW;
    }
	
	public String listNE(){
		
		String Direction = "";
		int index = 0;
		for (Direction direction : NE){
			Direction = Direction + index + ": " + direction + "\n";
			index ++;
	}
		return Direction; 
}

public String listNW(){
	
	String Direction = "";
	int index = 0;
	for (Direction direction : NW){
		Direction = Direction + index + ": " + direction + "\n";
		index ++;
}
	return Direction; 
}


public String listSE(){
	
	String Direction = "";
	int index = 0;
	for (Direction direction : SE){
		Direction = Direction + index + ": " + direction + "\n";
		index ++;
}
	return Direction; 
}


public String listSW(){
	
	String Direction = "";
	int index = 0;
	for (Direction direction : SW){
		Direction = Direction + index + ": " + direction + "\n";
		index ++;
}
	return Direction; 
}
	
	

}
