
public class PriceCards {
	private double price;
	
	public PriceCards(double price){
		this.price = price;
	}
	
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price) {
		this.price = price;
	}
    
    public String toString() {
		return "Price: $" + price +" International dollars per barrel \n";
	}

}
