public class Concession 
{
	private String type;
	private double barrels;
	private boolean drill;
	private double drillcost;
	
	
	
	public Concession(String type, double barrels, boolean drill, double drillcost)
    {
        this.type = type;
        this.barrels = barrels;
        this.drill = drill;
        this.drillcost = drillcost;
    }
	

    //getters
  
    public String getType(){
        return type;
    }
    
    public double getBarrels(){
    	return barrels;
    }
    
    public boolean drill(){
    	return drill;
    }
    
    public double drillcost(){
    	return drillcost;
    }
    
 
    //setters
    
	public void setType(String type) {
		this.type = type;
	}
	
	public void setBarrels(double barrels) {
		this.barrels = barrels;
	}
	
	public void setDrill(boolean drill) {
		this.drill = drill;
	}
	
	public void setDrillCost(Double drillcost) {
		this.drillcost = drillcost;
	}

	public String toString() {
		return "Concession Cards [Type= " + type + ", barrels= " + barrels
				+ ", Drill y/n= " + drill + ", drill cost"+ drillcost;
	}
	
}
