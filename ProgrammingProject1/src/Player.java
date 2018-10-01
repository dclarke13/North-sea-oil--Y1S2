public class Player
{
    private String playerName;
    private double totalMoney;
    private double moneyBorrowed;


    public Player(String playerName, double totalMoney, double moneyBorrowed)
    {
        this.playerName = playerName;
        this.totalMoney = totalMoney;
        this.moneyBorrowed = moneyBorrowed;
    }
         
    //getters

    public String getplayerName(){
        return playerName;
    }
    
    public double getTotalMoney(){
        return totalMoney;
    }
    
    public double getMoneyBorrowed() {
		return moneyBorrowed;
	}

    //setters
 
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public void setMoneyBorrowed(double moneyBorrowed) {
		this.moneyBorrowed = moneyBorrowed;
	}


    public String toString()
    {
        return "Player Name: " + playerName
             + ", Total Money: " + totalMoney
             + ", Money Borrowed: " + moneyBorrowed;
    }

}
