import java.util.ArrayList;

public class Store {
	private int currentPlayer;
	private ArrayList<Player> players;
	
	public Store(){
		players = new ArrayList<Player>();
        currentPlayer = 0;
	}
	
	public void add (Player player){
        players.add (player); 
    }
	

    public ArrayList<Player> getPlayers()
    {
    	return players;
    }
    
    public void moveToNextPlayer() {
    	if (currentPlayer < players.size()-1){
        	currentPlayer++;
    	}
    	else{
    		currentPlayer = 0;
    	}

    }

       public Player currentPlayer(){
    	   return players.get(currentPlayer);  
    }
    
       public int thisPlayer()
       {
       	return currentPlayer;
       }
    
	public String listPlayers(){
		if (players.size() == 0){
			return "No players";
		}
		else{
			String listOfPlayers = "";
			int index = 0;
			for (Player player : players){
				listOfPlayers = listOfPlayers + index + ": " + player + "\n";
				index ++;
			}
			return listOfPlayers;
		} 
	}

	

}
