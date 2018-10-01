import java.util.ArrayList;
import java.util.Collections;

public class Tcard {

	private ArrayList<TaxCards> tcards;
	private int currentCard;
	
	

	public Tcard(){
		tcards = new ArrayList<TaxCards>();
		fillTaxDeck();	
		shuffleDeck();
	}

	public void addTaxCard (TaxCards taxcards){
        tcards.add(taxcards); 
    }
	

    public ArrayList<TaxCards> getTaxCards()
    {
    	return tcards;
    }
    
    public void fillTaxDeck() {
    	 TaxCards card1 = new TaxCards(0,0.25,0.20);
         TaxCards card2 = new TaxCards(0,0.25,0.20);
         TaxCards card3 = new TaxCards(0,0.25,0.20);
         
         addTaxCard(card1);
         addTaxCard(card2);
         addTaxCard(card3);
         
         TaxCards card4 = new TaxCards(0,0.50,0.10);
         TaxCards card5 = new TaxCards(0,0.50,0.10);
         TaxCards card6 = new TaxCards(0,0.50,0.10);
         
         addTaxCard(card4);
         addTaxCard(card5);
         addTaxCard(card6);
         
         TaxCards card7 = new TaxCards(0,0,0.20);
         TaxCards card8 = new TaxCards(0,0,0.20);
         TaxCards card9 = new TaxCards(0,0,0.20);
         
         addTaxCard(card7);
         addTaxCard(card8);
         addTaxCard(card9);
         
         TaxCards card10 = new TaxCards(0,0.25,0.20);
         TaxCards card11 = new TaxCards(0,0.25,0.20);
         TaxCards card12 = new TaxCards(0,0.25,0.20);
         
         addTaxCard(card10);
         addTaxCard(card11);
         addTaxCard(card12);
         
         TaxCards card13 = new TaxCards(0.25,0.25,0.10);
         TaxCards card14 = new TaxCards(0.25,0.25,0.10);
         TaxCards card15 = new TaxCards(0.25,0.25,0.10);
         
         addTaxCard(card13);
         addTaxCard(card14);
         addTaxCard(card15);
         
         TaxCards card16 = new TaxCards(0.25,0.50,0.10);
         TaxCards card17 = new TaxCards(0.25,0.50,0.10);
         TaxCards card18 = new TaxCards(0.25,0.50,0.10);
         
         addTaxCard(card16);
         addTaxCard(card17);
         addTaxCard(card18);
    }

    public void drawNextCard() {
    	if (currentCard < tcards.size()-1){
        	currentCard++;
    	}
    	else{
    		currentCard = 0;
    		shuffleDeck();
    	}

    }

       public TaxCards currenttaxcard(){
    	   return tcards.get(currentCard);  
    }
    
       public int thisTcard()
       {
       	return currentCard;
       }

       public void shuffleDeck(){
    	   Collections.shuffle(tcards);
       }
       
    public String listTcard(){
    	
    	String TaxCard = "";
    	int index = 0;
    	for (TaxCards tcards : tcards){
    		TaxCard = TaxCard + index + ": " + tcards + "\n";
    		index ++;
    }
    	return TaxCard; 
    }
	
	

}
