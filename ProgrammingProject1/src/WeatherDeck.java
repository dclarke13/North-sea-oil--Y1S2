import java.util.ArrayList;
import java.util.*;

public class WeatherDeck {

	private ArrayList<Weather> weatherCards;
	private int currentCard;

	public WeatherDeck(){
		weatherCards = new ArrayList<Weather>();
		fillWeatherDeck();
		shuffleDeck();
		
	}

	public void addWeather (Weather weatherCard){
		weatherCards.add(weatherCard); 
    }
	

    public ArrayList<Weather> getWeatherCards()
    {
    	return weatherCards;
    }
    
    public void fillWeatherDeck() {
    	 Weather card1 = new Weather("SPRING", "GOOD", "GOOD", "GOOD", "GOOD");
    	 Weather card2 = new Weather("SPRING", "ROUGH", "STORM", "ROUGH", "STORM");
    	 Weather card3 = new Weather("SPRING", "ROUGH", "ROUGH", "GOOD", "GOOD");
         
         addWeather(card1);
         addWeather(card2);
         addWeather(card3);
         
         Weather card4 = new Weather("SUMMER", "ROUGH", "STORM", "GOOD", "STORM");
         Weather card5 = new Weather("SUMMER", "GOOD", "GOOD", "GOOD", "GOOD");
         
         addWeather(card4);
         addWeather(card5);
         
         Weather card6 = new Weather("AUTUMN", "GOOD", "GOOD", "GOOD", "GOOD");
         Weather card7 = new Weather("AUTUMN", "GOOD", "ROUGH", "GOOD", "GOOD");
         Weather card8 = new Weather("AUTUMN", "ROUGH", "GOOD", "GOOD", "GOOD");
         
         addWeather(card6);
         addWeather(card7);
         addWeather(card8);
         
         Weather card9 = new Weather("WINTER", "GALE", "ROUGH", "GALE", "ROUGH");
         Weather card10 = new Weather("WINTER", "GALE", "GALE", "STORM", "STORM");
         Weather card11 = new Weather("WINTER", "ROUGH", "GALE", "ROUGH", "GALE");
         Weather card12 = new Weather("WINTER", "GOOD", "GOOD", "GOOD", "GOOD");
         
         addWeather(card9);
         addWeather(card10);
         addWeather(card11);
         addWeather(card12);         
    }

    public void drawNextCard() {
       	if (currentCard < weatherCards.size()-1){
           	currentCard++;
       	}
       	else{
       		currentCard = 0;
       		shuffleDeck();
       	}

    }

       public Weather currentCard(){
    	   return weatherCards.get(currentCard);  
    }
    
       public int thisWeathercard()
       {
       	return currentCard;
       }
       
       public void shuffleDeck(){
    	   Collections.shuffle(weatherCards);
       }
       


      
      

    public String listWeathercard(){
    	
    	String WeatherCard = "";
    	int index = 0;
    	for (Weather weatherCards : weatherCards){
    		WeatherCard = WeatherCard + index + ": " + weatherCards + "\n";
    		index ++;
    }
    	return WeatherCard; 
    }
	
	

}
