public class TaxCards 
{
	private double capitalRateTaxes;
	private double revenueTaxRates;
	private double interestRates;
	
	
	
	public TaxCards(double capitalRateTaxes, double revenueTaxRates, double interestRates)
    {
        this.capitalRateTaxes = capitalRateTaxes;
        this.revenueTaxRates = revenueTaxRates;
        this.interestRates = interestRates;
    }
	

    //getters
  
    public double getcapitalRateTaxes(){
        return capitalRateTaxes;
    }
    
    public double getrevenueTaxRates(){
    	return revenueTaxRates;
    }
    
    public double getinterestRates(){
    	return interestRates;
    }
    

    //setters
   
	public void setcapitalRateTaxes(double capitalRateTaxes) {
		this.capitalRateTaxes = capitalRateTaxes;
	}
	
	public void setrevenueTaxRates(double revenueTaxRates) {
		this.revenueTaxRates = revenueTaxRates;
	}
	
	public void setinterestRates(double interestRates) {
		this.interestRates = interestRates;
	}

	public String toString() {
		return "TaxCards [capitalRateTaxes= " + capitalRateTaxes + ", revenueTaxRates= " + revenueTaxRates
				+ ", interestRates= " + interestRates +"\n";
	}
	
}
