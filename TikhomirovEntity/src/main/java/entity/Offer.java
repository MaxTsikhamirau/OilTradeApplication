package entity;

public class Offer {
	private int ID;
	private String sellerName;
	private String sortName;
	private int quantity;
	private int price;

	public Offer(int iD, String sellerName, String sortName, int quantity, int price) {
		ID = iD;
		this.sellerName = sellerName;
		this.sortName = sortName;
		this.quantity = quantity;
		this.price = price;
	}

	public Offer() {
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

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Offer [ID=" + ID + ", sellerName=" + sellerName + ", sortName=" + sortName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
