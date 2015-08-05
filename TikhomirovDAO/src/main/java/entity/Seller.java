package entity;

public class Seller {
	private int ID;
	private String sellerName;
	private String sellerCountry;
	private int sellerAccount;
	
	public Seller(int iD, String sellerName, String sellerCountry, int sellerAccount) {
				ID = iD;
		this.sellerName = sellerName;
		this.sellerCountry = sellerCountry;
		this.sellerAccount = sellerAccount;
	}
	public Seller() {
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerCountry() {
		return sellerCountry;
	}
	public void setSellerCountry(String sellerCountry) {
		this.sellerCountry = sellerCountry;
	}
	public int getSellerAccount() {
		return sellerAccount;
	}
	public void setSellerAccount(int sellerAccount) {
		this.sellerAccount = sellerAccount;
	}
	@Override
	public String toString() {
		return "Seller [sellerName=" + sellerName + ", sellerCountry=" + sellerCountry + ", sellerAccount="
				+ sellerAccount + "]";
	}

}
