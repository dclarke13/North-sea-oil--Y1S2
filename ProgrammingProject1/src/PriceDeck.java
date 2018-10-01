import java.util.ArrayList;
import java.util.Collections;

public class PriceDeck {

	private ArrayList<PriceCards> priceCards;
	private int currentCard;
	
	public PriceDeck(){
		priceCards = new ArrayList<PriceCards>();
		fillPriceDeck();
		shuffleDeck();
	}
	
	public void addPrice (PriceCards priceCard){
		priceCards.add(priceCard); 
    }
	
	public ArrayList<PriceCards> getPriceCards()
    {
    	return priceCards;
    }
	
	public void fillPriceDeck() {
   	 PriceCards card1 = new PriceCards(4);
   	 PriceCards card2 = new PriceCards(10);
   	 PriceCards card3 = new PriceCards(20);
        
        addPrice(card1);
        addPrice(card2);
        addPrice(card3);        
   }
	
	public void moveToNextCard() {
    	if (currentCard < priceCards.size()-1){
        	currentCard++;
    	}
    	else{
    		currentCard = 0;
    		shuffleDeck();
    	}

    }
	
	public PriceCards currentCard(){
 	   return priceCards.get(currentCard);  
 }
	
	public int thisPcard()
    {
    	return currentCard;
    }
	
	 public void shuffleDeck(){
  	   Collections.shuffle(priceCards);
     }
	 
public String listPricecard(){
    	
    	String PriceCard = "";
    	int index = 0;
    	for (PriceCards priceCards : priceCards){
    		PriceCard = PriceCard + index + ": " + priceCards + "\n";
    		index ++;
    }
    	return PriceCard; 
    }
}
