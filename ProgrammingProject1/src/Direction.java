public class Direction
{
    private String playerName;
    private boolean drill;
    private double drillCost;
    private double barrels;


    public Direction(String playerName, boolean drill,double drillCost, double barrels)
    {
        this.playerName = playerName;
        this.drill = drill;
        this.barrels = barrels;
        this.drillCost = drillCost;
    }
         
    //getters
  
    public String getplayerName(){
        return playerName;
    }
    
 
    public boolean getDrill(){
        return drill;
    }

    public double getDrillCost(){
    	return drillCost;
    }
    
    public double getBarrels() {
		return barrels;
	}


    //setters

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setDrill(boolean drill) {
		this.drill = drill;
	}
	
	public void setDrillCost(int drillCost){
		this.drillCost = drillCost;
	}
	
	public void setBarrels(int barrels) {
		this.barrels = barrels;
	}


    public String toString()
    {
        return "Player Name: " + playerName
             + ", Drill Y/N: " + drill
             +", Drill Cost: " + drillCost
             + ", Barrels of oil: " + barrels;
    }

}
