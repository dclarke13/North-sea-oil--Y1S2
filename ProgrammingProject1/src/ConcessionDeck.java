import java.util.ArrayList;
import java.util.Collections;

public class ConcessionDeck {

	private ArrayList<Concession> ccards;
	private int currentCard;
	
	

	public ConcessionDeck(){
		ccards = new ArrayList<Concession>();
		fillConcessionDeck();		
	}

	public void addConcession (Concession concession){
        ccards.add(concession); 
    }
	

    public ArrayList<Concession> getCcards()
    {
    	return ccards;
    }
    
    public void fillConcessionDeck() {
    	 Concession card1 = new Concession("SHALLOW",0,false, 50000);
    	 Concession card2 = new Concession("SHALLOW",20000,false, 50000);
    	 Concession card3 = new Concession("SHALLOW",40000,false, 50000);
         
         addConcession(card1);
         addConcession(card2);
         addConcession(card3);
         
    	 Concession card4 = new Concession("REEF",0,false, 150000);
    	 Concession card5 = new Concession("REEF",20000,false, 150000);
    	 Concession card6 = new Concession("REEF",40000,false, 150000);
    	 Concession card7 = new Concession("REEF",100000,false, 150000);
   
         
    	 addConcession(card4);
         addConcession(card5);
         addConcession(card6);
         addConcession(card7);
         
    	 Concession card8 = new Concession("DEEP",0,false, 300000);
    	 Concession card9 = new Concession("DEEP",20000,false, 300000);
    	 Concession card10 = new Concession("DEEP",40000,false, 300000);
    	 Concession card11= new Concession("DEEP",0,false, 300000);
         
    	 addConcession(card8);
         addConcession(card9);
         addConcession(card10);
         addConcession(card11);
    }
    
    public void shuffleDeck(){
 	   Collections.shuffle(ccards);
    }
    
    public void drawNextCard() {
       	if (currentCard < ccards.size()-1){
           	currentCard++;
       	}
       	else{
       		currentCard = 0;
       		shuffleDeck();
       	}

    }

       public Concession currentCard(){
    	   return ccards.get(currentCard);  
    }
    
       public int thisCcard()
       {
       	return currentCard;
       }

    public String listCcard(){
    	
    	String Ccard = "";
    	int index = 0;
    	for (Concession ccards : ccards){
    		Ccard = Ccard + index + ": " + ccards + "\n";
    		index ++;
    }
    	return Ccard; 
    }
	
	

}
