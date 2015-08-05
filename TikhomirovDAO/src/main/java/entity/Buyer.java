package entity;

public class Buyer {
	private String buyerName;
	private String buyerCountry;
	private int buyerAccount;
	public Buyer(String buyerName, String buyerCountry, int buyerAccount) {
	    this.buyerName = buyerName;
		this.buyerCountry = buyerCountry;
		this.buyerAccount = buyerAccount;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerCountry() {
		return buyerCountry;
	}
	public void setBuyerCountry(String buyerCountry) {
		this.buyerCountry = buyerCountry;
	}
	public int getBuyerAccount() {
		return buyerAccount;
	}
	public void setBuyerAccount(int buyerAccount) {
		this.buyerAccount = buyerAccount;
	}
	@Override
	public String toString() {
		return "Buyer [buyerName=" + buyerName + ", buyerCountry=" + buyerCountry + ", buyerAccount=" + buyerAccount
				+ "]";
	}
	
	
}
