//darren clarke
//cian swanson
//kane farrell
//eoin healy

import java.util.ArrayList;
import java.util.Scanner;

public class Driver{
	private Scanner input;
    private Store store;
    private Map map;
    private Player player;
    private Weather weather;
    private TaxCards taxcards;
    private Tcard tcard;
    private WeatherDeck weatherCards;
    private Concession concession;
    private ConcessionDeck concessiondeck;
    private PriceDeck pricedeck;

    public static void main(String[] args) {
		Driver app = new Driver();
	}
    
    public Driver(){
        input = new Scanner(System.in);
        store = new Store();
        map = new Map();
        tcard = new Tcard();
        weatherCards = new WeatherDeck();
        concessiondeck = new ConcessionDeck();
        pricedeck = new PriceDeck();
        runMenu();
    }
    
    
    //display the main menu options
    private int mainMenu()
    { 
        System.out.println("Game Menu");
        System.out.println("---------");     
        System.out.println("  1) Add a Player");    
        System.out.println("  2) List the Players");    
        System.out.println("  3) Update a Player Name"); 
        System.out.println("  4) Delete a Player");
        System.out.println("  5) Start Game"); 
        System.out.println("---------");         
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }

    
    //run the main menu
   private void runMenu()
   {
       int option = mainMenu();
       while (option != 0)
       {
          
           switch (option)
           {
              case 1:    addPlayer();
           	             break;
              case 2:    System.out.println(store.listPlayers());
                         break;
              case 3:    editPlayer();
                         break;
              case 4:    deletePlayer();
              			 break;
              case 5:    runGameMenu();
              			 break;              
              case 6:    System.out.println ("not currently an option");
                         break;
              case 7:    System.out.println ("not currently an option");
                         break;
              case 8:    System.out.print ("not currently an option");
                         break;
             default:    System.out.println("Invalid option entered: " + option);
                         break;
           }
           
           System.out.println("\nPress any key to continue...");
           input.nextLine();
           input.nextLine();
           
           
           option = mainMenu();
       }
      
       //if option 0 is picked exit game
       System.out.println("Exiting Game...");
       System.exit(0);
   }
   //display game menu options
   private int gameMenu()
   { 
       System.out.println("Game Menu");
	   System.out.println(store.currentPlayer());
       System.out.println("---------");    
       System.out.println("  1) Borrow Money");        
       System.out.println("  2) Test next concession ");      
       System.out.println("  3) Buy Drill");    
       System.out.println("  4) Sell Drill"); 
       System.out.println("  5) Transfer Drill");
       System.out.println("  6) Sell Concession"); 
       System.out.println("  7) Check Season");
       System.out.println("  8) Check Map"); 
       System.out.println("  9) Pay Back Loan");
       System.out.println("---------");         
       System.out.println("  0) End Turn");
       System.out.print("==>> ");
       int selection = input.nextInt();
       return selection;
	
	   }
	   
   
   //run the game menu
   private void runGameMenu()
   {
       int option = gameMenu();
      
          
           switch (option)
           {
              case 1:    borrowMoney();
           	             break;
              case 2:    addMap();
                         break;
              case 3:    buyDrill();
              			 break;
              case 4:    sellDrill();
              			 break;              
              case 5:    transferDrill();
                         break;
              case 6:    TaxCalculation();
              		     break;
              case 7:    checkSeason();
              			 break;
              case 8:    System.out.println("NE");
              			 System.out.println(map.listNE());
              			 System.out.println("NW");
              			 System.out.println(map.listNW());
              			 System.out.println("SE");
              			 System.out.println(map.listSE());
              			 System.out.println("SW");
              			 System.out.println(map.listSW());
   			 			 break;
              case 9:    payBackLoan();
              			 break;
              case 0:    store.moveToNextPlayer();
              			 break;
             default:    System.out.println("Invalid option entered: " + option);
                         break;
           }
           
           System.out.println("\nPress any key to continue...");
           input.nextLine();
           input.nextLine();  
           //display the game menu again
           runGameMenu();
       }
      
   
    //add a new player to the array
    private void addPlayer(){  
    	if (store.getPlayers().size()<6){
    	input.nextLine();
    	System.out.print("Enter Player Name:  ");
        String playerName = input.nextLine();
    	System.out.print("Press Enter Twice to Confirm");
    	
    	store.add(new Player(playerName, 0, 0));
    	}
    	else {
    		System.out.println("only 6 players max allowed");
    	}
    	}
    //remove player from the array
    private void deletePlayer(){
    	System.out.println(store.listPlayers());
    	
    	if(store.getPlayers().size() !=0){
    	
    	System.out.print("Index of player to delete ==>");
    	int index = input.nextInt();
    	
    	if(index < store.getPlayers().size()){
    	store.getPlayers().remove(index);
    	System.out.println("player deleted.");
    	}
    	
    	else{
    		System.out.println("there is no player for this index number");
    	}
    	}
    	
    }
   //change players name
   public void editPlayer(){
	   
	   System.out.println(store.listPlayers());
	   
	   if(store.getPlayers().size() !=0){
		   
	   
	   System.out.print("Index of player name to edit ==>");
	   int index = input.nextInt();
	   
	   if(index < store.getPlayers().size()){

	   System.out.print("Enter a new player name: ");
	   String name = input.nextLine();
	   name = input.nextLine();
	   System.out.print("Press Enter Twice to Confirm");
	   int total = 0;
	   int borrowed = 0;

	   Player player = store.getPlayers().get(index);
	   player.setPlayerName(name);
	   player.setTotalMoney(total);
	   player.setMoneyBorrowed(borrowed);
   }
	   
    
	   else
	   {
		   System.out.println("there is no player for this index number");
	   }
	   }
   }
   
   //
   private void addMap(){  
   	   input.nextLine();
   	   System.out.print("Choose Direction, NE, NW, SE, SW:  ");
       String Choice = input.nextLine().toUpperCase();
       System.out.println("Value is: " + Choice);
   
    if (Choice.equals("NE")){
    	if(map.getMapNE().size() < 7) {
    		int cplayer = store.thisPlayer();
    		int ccard = concessiondeck.thisCcard();
    		   Player player = store.getPlayers().get(cplayer);
    		   Concession concession = concessiondeck.getCcards().get(ccard);
    		   double total = player.getTotalMoney();
    		   String playerName =  player.getplayerName();
    		   boolean drill = false;
    		   double drillcost = concession.drillcost();
    		   double barrels = concession.getBarrels();
    		   map.addNE(new Direction(playerName,drill , drillcost, barrels));
    		   concessiondeck.drawNextCard();
    	} else {
 		   System.out.println("Area full");
 		}
    }
    
    else if (Choice.equals("NW")){
    	if(map.getMapNW().size() < 7) {		
    		int cplayer = store.thisPlayer();
    		int ccard = concessiondeck.thisCcard();
    		   Player player = store.getPlayers().get(cplayer);
    		   Concession concession = concessiondeck.getCcards().get(ccard);
    		   double total = player.getTotalMoney();
    		   // double newtotal = total-cost;
    		   //player.setTotalMoney(newtotal);
    		   String playerName =  player.getplayerName();
    		   boolean drill = false;
    		   double drillcost = concession.drillcost();
    		   double barrels = concession.getBarrels();
    		   map.addNW(new Direction(playerName,drill , drillcost, barrels));
    		   concessiondeck.drawNextCard();
 	} else {
		   System.out.println("Area full");
		}
     }
    
    else if (Choice.equals("SE")){
    	if(map.getMapSE().size() < 7) {
		
     		int cplayer = store.thisPlayer();
     		int ccard = concessiondeck.thisCcard();
     		   Player player = store.getPlayers().get(cplayer);
     		   Concession concession = concessiondeck.getCcards().get(ccard);
     		   double total = player.getTotalMoney();
     		   String playerName =  player.getplayerName();
     		   boolean drill = false;
     		   double drillcost = concession.drillcost();
     		   double barrels = concession.getBarrels();
     		   map.addSE(new Direction(playerName,drill , drillcost, barrels));
     		   concessiondeck.drawNextCard();
 	} else {
		   System.out.println("Area full");
		}
     }
    
    else if (Choice.equals("SW")){
    	if(map.getMapSW().size() < 7) {	
     		int cplayer = store.thisPlayer();
     		int ccard = concessiondeck.thisCcard();
     		   Player player = store.getPlayers().get(cplayer);
     		   Concession concession = concessiondeck.getCcards().get(ccard);
     		   double total = player.getTotalMoney();
     		   String playerName =  player.getplayerName();
     		   boolean drill = false;
     		   double drillcost = concession.drillcost();
     		   double barrels = concession.getBarrels();
     		   map.addSW(new Direction(playerName,drill , drillcost, barrels));
     		   concessiondeck.drawNextCard();
		}
     }
    
    else {
    	System.out.println("invalid option");
    }
    
    }
   
   public void TaxCalculation(){

   		for(int i =0; i < store.getPlayers().size(); i++){
   			Player player = store.getPlayers().get(i);
   			TaxCards tcards = tcard.getTaxCards().get(tcard.thisTcard());
   			//capital tax for sold drills or concessions
   			//interest on money borrowed
   			//revenue on profit made
   			//temp values
   			double totalrevenue=0;
   			double totalcapital=0;
   			
   			//double profit = barrels * value * weather;
   			double borrowed = player.getMoneyBorrowed();
   			double interest = tcards.getinterestRates();
   			double totalinterest = borrowed * interest;
   			//double totalrevenue = profit * tcards.getrevenueTaxRates();
   			//double totalcapital = drills and concessionssold * tcards.getcapitalRateTaxes();
   			double taxpayable = totalinterest + totalrevenue +totalcapital;
   			System.out.println("Total interest paid :" + totalinterest);
   			//System.out.println("total revenue tax paid: " + totalrevenue);
   			//System.out.println("Total capital tax paid :" + totalcapital);
   		    double newtotal = player.getTotalMoney() - taxpayable;
   			player.setTotalMoney(newtotal);
   			pricedeck.moveToNextCard();
   			tcard.drawNextCard();
   			weatherCards.drawNextCard();
   			
   		}
   }
   
public void askBid(){
	   
	   ArrayList<Player> players = store.getPlayers();
 
	   //include some form of repetition..while...it will end when all players have 
	   //entered a zero...ie bidding is over.
	   
	        //for (Player player : players)
	        //cycle through each player from the first to the last one. For each player:
   	        //       display the current highest bid. 
	        //       Ask the player how much they want to bid. 
	        //       If the player enters zero, they haven't bid for that particular turn.  
	        //       If a player enters a number greater than zero, check that this
	    //           number is greater than the current highest bid; if it isn't greater or 
	      //         the current player doesn't have enough money, then let player know 
	    //           it is an invalid bid and ask them to enter a new number again.
	    //           If it is a valid bid, store the value as the 
	   //            current highest bid and also store current player in a highestBidPlayer 
	   //           
	   
	   double currentBid = 0;
	   double balance = player.getTotalMoney();
	   

	   for(Player player: players){
		   int index = store.thisPlayer();
		   Player playerx = store.getPlayers().get(index);
		   System.out.print("How much would you like to bid?");
		   double totalBid = input.nextDouble();
	   
		   if(totalBid == 0){ 
	    	 store.moveToNextPlayer();
		   }
		   else if (totalBid < currentBid||totalBid > balance)
		   {
			   System.out.print("This is an invalid bid");
		   }
		   else
		   {
			   totalBid = currentBid;
			   store.moveToNextPlayer();
		   }
	   }
	   
		   if (currentBid != 0){
			   player.setTotalMoney(balance - currentBid);
		   }
		   else{
			   System.out.print("Bidding has ended");
		   }
	   
	   //     When bidding is over...check the current bid.  
	    //         If it is zero...noone has bid.
	    //         If it is > 0, there is a successful bid i.e. some bought the 
	    //         square.  Over the direction (passed as a parameter) set the player to the
	    //         player stored in the current player local variable.  Then take the money
	    //         in the current bid from the players balance.
	    //         when cards class becomes available, turn over the card on the land. 
	 
   }            
   
   
   public void borrowMoney(){
	     
	   System.out.println("How Much Would you like to borrow");
	   System.out.println("1- 500000");
	   System.out.println("2- 1000000");
	   int option = input.nextInt();
	   
	   if(option == 1){
	   int index = store.thisPlayer();
	   Player player = store.getPlayers().get(index);
	   double newtotal = player.getTotalMoney() + 500000;
	   double newborrowed = player.getMoneyBorrowed()  + 500000;

	   player.setTotalMoney(newtotal);
	   player.setMoneyBorrowed(newborrowed);
   }
	   
    
	      else if (option == 2)
	   {
		   int index = store.thisPlayer();   
		   Player player = store.getPlayers().get(index);
		   double newtotal = player.getTotalMoney() + 1000000;
		   double newborrowed = player.getMoneyBorrowed()  + 1000000;

		   player.setTotalMoney(newtotal);
		   player.setMoneyBorrowed(newborrowed);
	   }
	   
	   else {
		   System.out.println("invalid entry");
	   }
   }
   
   public void buyDrill(){
	   
	   input.nextLine();
   	   System.out.print("Choose Direction, NE, NW, SE, SW:  ");
       String Choice = input.nextLine().toUpperCase();
       System.out.println("Value is: " + Choice);
       
       if(Choice.equals("NE")){     
	   if(map.getMapNE().size() !=0){
		   
	   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listNE());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapNE().size())){

	   System.out.print("Press Enter to Confirm");
	   boolean drill = true;
	   Direction direction = map.getMapNE().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
    
	   else
	   {
		   System.out.println("there is no player for this index number");
	   }
	   }
   }
       
       else if(Choice.equals("NW")){
  	     
	   if(map.getMapNW().size() !=0){

	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listNW());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapNW().size())){

	   System.out.print("Press Enter to Confirm");
	   boolean drill = true;
	   
	   Direction direction = map.getMapNW().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
    
	   else
	   {
		   System.out.println("there is no concession for this index number");
	   }
	   }
   }
       else if(Choice.equals("SE")){
  	     
	   if(map.getMapSE().size() !=0){
		   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listSE());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapSE().size())){

	   System.out.print("Press Enter to Confirm");
	   boolean drill = true;
	   
	   Direction direction = map.getMapSE().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
	   else
	   {
		   System.out.println("there is no Concession For this index number");
	   }
	   }
   }
       else if(Choice.equals("SW")){
  	     
	   if(map.getMapSW().size() !=0){
		   
	   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listSW());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapSW().size())){

	   System.out.print("Press Enter to Confirm");
	   boolean drill = true;
	   
	   Direction direction = map.getMapSW().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
	   else
	   {
		   System.out.println("there is no concession for this index number");
	   }
	   }
   }
       
       else{
    	   System.out.println("invalid option");
       }
   }
   
   
   public void sellDrill(){
	   
	   input.nextLine();
   	   System.out.print("Choose Direction, NE, NW, SE, SW:  ");
       String Choice = input.nextLine().toUpperCase();
       System.out.println("Value is: " + Choice);
       
       if(Choice.equals("NE")){     
	   if(map.getMapNE().size() !=0){
		   
	   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listNE());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapNE().size())){

	   System.out.print("Press Enter to Confirm");
	   boolean drill = false;
	   
	   Direction direction = map.getMapNE().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() + direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
    
	   else
	   {
		   System.out.println("there is no concession for this index number");
	   }
	   }
   }
       
       else if(Choice.equals("NW")){
  	     
	   if(map.getMapNW().size() !=0){
		   
	   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listNW());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapNW().size())){

	
	   System.out.print("Press Enter to Confirm");
	   boolean drill = false;
	   
	   Direction direction = map.getMapNW().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() + direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
    
	   else
	   {
		   System.out.println("there is no concession for this index number");
	   }
	   }
   }
       else if(Choice.equals("SE")){
  	     
	   if(map.getMapSE().size() !=0){
		   
	   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listSE());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapSE().size())){

	
	   System.out.print("Press Enter to Confirm");
	   boolean drill = false;
	   
	   Direction direction = map.getMapSE().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() + direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
    
	   else
	   {
		   System.out.println("there is no Concession For this index number");
	   }
	   }
   }
       else if(Choice.equals("SW")){
  	     
	   if(map.getMapSW().size() !=0){
		   
	   
	   System.out.print("Index of Concession to buy drill for ==>");
	   System.out.println(map.listSW());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapSW().size())){

	
	   System.out.print("Press Enter to Confirm");
	   boolean drill = false;
	   
	   Direction direction = map.getMapSW().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() + direction.getDrillCost();
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
   }
	   
    
	   else
	   {
		   System.out.println("there is no concession for this index number");
	   }
	   }
   }
       
       else{
    	   System.out.println("invalid option");
       }
   }
   
   public void payBackLoan(){
	   input.nextLine();
   	   System.out.print("Choose Amount to Pay Back:  ");
       double Choice = input.nextDouble();
       System.out.println("Value is: " + Choice);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - Choice;
	   double borrowed = player.getMoneyBorrowed() - Choice;
	   player.setTotalMoney(total);
	   player.setMoneyBorrowed(borrowed);
   }
   
   public void checkSeason(){
	   int index = weatherCards.thisWeathercard();
	   Weather weather  = weatherCards.getWeatherCards().get(index);
	   String season = weather.getSeason();
	   System.out.println("season is: " + season);
   }
   
public void transferDrill(){
	input.nextLine();
	   System.out.print("Choose Direction of drill to remove, NE, NW, SE, SW:  ");
    String Choice = input.nextLine().toUpperCase();
    System.out.println("Value is: " + Choice);
    
    if(Choice.equals("NE")){     
	   if(map.getMapNE().size() !=0){
		   
	   
	   System.out.print("Index of drill to remove ==>");
	   System.out.println(map.listNE());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapNE().size())){

	
	   System.out.print("Press Enter to Confirm");
	   boolean drill = false;
	   
	   Direction direction = map.getMapNE().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - 20000;
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
	   
		input.nextLine();
		   System.out.print("Choose Direction of drill to add, NE, NW, SE, SW:  ");
	    String Choice2 = input.nextLine().toUpperCase();
	    System.out.println("Value is: " + Choice2);
	    
	    if(Choice2.equals("NE")){     
		   if(map.getMapNE().size() !=0){
			   
		   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listNE());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapNE().size())){

		
		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapNE().get(index2);
		   direction2.setDrill(drill2);

		   
		   
	}
		   
	 
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
	    
	    if(Choice2.equals("NW")){     
		   if(map.getMapNW().size() !=0){
			   
		   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listNW());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapNW().size())){

		
		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapNW().get(index2);
		   direction2.setDrill(drill2);  
		   
	}
		   
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
	    
	    if(Choice2.equals("SE")){     
		   if(map.getMapSE().size() !=0){
			   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listSE());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapNE().size())){

		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapSE().get(index2);
		   direction2.setDrill(drill2);
   
		   
	}
		   
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
	    
	    if(Choice2.equals("SW")){     
		   if(map.getMapSW().size() !=0){
			   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listSW());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapSW().size())){

		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapSW().get(index2);
		   direction2.setDrill(drill2);
  
	}
		   
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
}
	   
 
	   else
	   {
		   System.out.println("there is concession for this index number");
	   }
	   }
}
    
    else if(Choice.equals("NW")){     
 	   if(map.getMapNE().size() !=0){
		   
 		   
 		   System.out.print("Index of drill to remove ==>");
 		   System.out.println(map.listNW());
 		   int index = input.nextInt();
 		   
 		   if(index <(map.getMapNW().size())){

 		
 		   System.out.print("Press Enter to Confirm");
 		   boolean drill = false;
 		   
 		   Direction direction = map.getMapNW().get(index);
 		   int cplayer = store.thisPlayer();   
 		   Player player = store.getPlayers().get(cplayer);
 		   double total = player.getTotalMoney() - 20000;
 		   direction.setDrill(drill);
 		   player.setTotalMoney(total);
 		   
 			input.nextLine();
 			   System.out.print("Choose Direction of drill to add, NE, NW, SE, SW:  ");
 		    String Choice2 = input.nextLine().toUpperCase();
 		    System.out.println("Value is: " + Choice2);
 		    
 		    if(Choice2.equals("NE")){     
 			   if(map.getMapNE().size() !=0){
 				   
 			   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listNE());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapNE().size())){

 			
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapNE().get(index2);
 			   direction2.setDrill(drill2);

 			   
 			   
 		}
 			   
 		 
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 		    
 		    if(Choice2.equals("NW")){     
 			   if(map.getMapNW().size() !=0){
 				   
 			   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listNW());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapNW().size())){

 			
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapNW().get(index2);
 			   direction2.setDrill(drill2);

 			   
 			   
 		}
 			   
 		 
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 		    
 		    if(Choice2.equals("SE")){     
 			   if(map.getMapSE().size() !=0){
 				   
 			   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listSE());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapNE().size())){

 			
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapSE().get(index2);
 			   direction2.setDrill(drill2);

 			   
 			   
 		}
 			   
 		 
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 		    
 		    if(Choice2.equals("SW")){     
 			   if(map.getMapSW().size() !=0){
 				   
 			   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listSW());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapSW().size())){

 			
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapSW().get(index2);
 			   direction2.setDrill(drill2);

 			   
 			   
 		}
 			   
 		 
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 	}
 		   
 	 
 		   else
 		   {
 			   System.out.println("there is concession for this index number");
 		   }
 		   }
 	}
    
    
    else if(Choice.equals("SE")){     
	   if(map.getMapSE().size() !=0){
		   
	   
	   System.out.print("Index of drill to remove ==>");
	   System.out.println(map.listSE());
	   int index = input.nextInt();
	   
	   if(index <(map.getMapSE().size())){

	
	   System.out.print("Press Enter to Confirm");
	   boolean drill = false;
	   
	   Direction direction = map.getMapSE().get(index);
	   int cplayer = store.thisPlayer();   
	   Player player = store.getPlayers().get(cplayer);
	   double total = player.getTotalMoney() - 20000;
	   direction.setDrill(drill);
	   player.setTotalMoney(total);
	   
		input.nextLine();
		   System.out.print("Choose Direction of drill to add, NE, NW, SE, SW:  ");
	    String Choice2 = input.nextLine().toUpperCase();
	    System.out.println("Value is: " + Choice2);
	    
	    if(Choice2.equals("NE")){     
		   if(map.getMapNE().size() !=0){
			   
		   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listNE());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapNE().size())){

		
		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapNE().get(index2);
		   direction2.setDrill(drill2);

		   
		   
	}
		   
	 
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
	    
	    if(Choice2.equals("NW")){     
		   if(map.getMapNW().size() !=0){
			   
		   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listNW());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapNW().size())){

		
		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapNW().get(index2);
		   direction2.setDrill(drill2);

		   
		   
	}
		   
	 
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
	    
	    if(Choice2.equals("SE")){     
		   if(map.getMapSE().size() !=0){
			   
		   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listSE());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapNE().size())){

		
		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapSE().get(index2);
		   direction2.setDrill(drill2);

		   
		   
	}
		   
	 
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
	    
	    if(Choice2.equals("SW")){     
		   if(map.getMapSW().size() !=0){
			   
		   
		   System.out.print("Index of drill to add ==>");
		   System.out.println(map.listSW());
		   int index2 = input.nextInt();
		   
		   if(index2 <(map.getMapSW().size())){

		
		   System.out.print("Press Enter to Confirm");
		   boolean drill2 = true;
		   Direction direction2 = map.getMapSW().get(index2);
		   direction2.setDrill(drill2);	   
	}
		   
		   else
		   {
			   System.out.println("there is concession for this index number");
		   }
		   }
	}
}
	   
	   else
	   {
		   System.out.println("there is concession for this index number");
	   }
	   }
}
 
    
    else if(Choice.equals("SW")){     
 	   if(map.getMapSW().size() !=0){
		   
 		   
 		   System.out.print("Index of drill to remove ==>");
 		   System.out.println(map.listSW());
 		   int index = input.nextInt();
 		   
 		   if(index <(map.getMapSW().size())){

 		
 		   System.out.print("Press Enter to Confirm");
 		   boolean drill = false;
 		   
 		   Direction direction = map.getMapSW().get(index);
 		   int cplayer = store.thisPlayer();   
 		   Player player = store.getPlayers().get(cplayer);
 		   double total = player.getTotalMoney() - 20000;
 		   direction.setDrill(drill);
 		   player.setTotalMoney(total);
 		   
 			input.nextLine();
 			   System.out.print("Choose Direction of drill to add, NE, NW, SE, SW:  ");
 		    String Choice2 = input.nextLine().toUpperCase();
 		    System.out.println("Value is: " + Choice2);
 		    
 		    if(Choice2.equals("NE")){     
 			   if(map.getMapNE().size() !=0){
 				   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listNE());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapNE().size())){
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapNE().get(index2);
 			   direction2.setDrill(drill2);
 			   
 		}		 
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 		    
 		    if(Choice2.equals("NW")){     
 			   if(map.getMapNW().size() !=0){
 				   			   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listNW());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapNW().size())){
 			
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapNW().get(index2);
 			   direction2.setDrill(drill2);	    			   
 		}
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 		    
 		    if(Choice2.equals("SE")){     
 			   if(map.getMapSE().size() !=0){
 				    			   
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listSE());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapNE().size())){
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapSE().get(index2);
 			   direction2.setDrill(drill2);
 		}
 			   
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 		    
 		    if(Choice2.equals("SW")){     
 			   if(map.getMapSW().size() !=0){
 			   System.out.print("Index of drill to add ==>");
 			   System.out.println(map.listSW());
 			   int index2 = input.nextInt();
 			   
 			   if(index2 <(map.getMapSW().size())){
 			   System.out.print("Press Enter to Confirm");
 			   boolean drill2 = true;
 			   Direction direction2 = map.getMapSW().get(index2);
 			   direction2.setDrill(drill2);	   
 		}
 			   else
 			   {
 				   System.out.println("there is concession for this index number");
 			   }
 			   }
 		}
 	}	    	 
 		   else
 		   {
 			   System.out.println("there is concession for this index number");
 		   }
 		   }
 	}
    else{
 	   System.out.println("invalid option");
    }
	}	   
}
