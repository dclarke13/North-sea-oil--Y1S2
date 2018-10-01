public class Weather 
{
	private String season;
	private String NE;
	private String NW;
	private String SE;
	private String SW;
	
	
	
	public Weather(String season, String NE, String NW, String SE, String SW)
    {
        this.season = season;
        this.NE = NE;
        this.NW = NW;
        this.SE = SE;
        this.SW = SW;
    }
	
    //getters
   
    public String getSeason(){
        return season;
    }
    
    public String getNE(){
    	return NE;
    }
    
    public String getNW(){
    	return NW;
    }
    
    public String getSE(){
    	return SE;
    }
    
    public String getSW(){
    	return SW;
    }
    

    //setters

	public void setSeason(String season) {
		this.season = season;
	}
	
	public void setNE(String NE) {
		this.NE = NE;
	}
	
	public void setNW(String NW) {
		this.NW = NW;
	}
	
	public void setSE(String SE) {
		this.SE = SE;
	}
	
	public void setSW(String SW) {
		this.SW = SW;
	}


	public String toString() {
		return "Weather [Season: " + season + ", NE:  " + NE+ ", NW: " + NW + ", SE: " + SE
				+ ", SW: " + SW +"\n";
	}
	
}
