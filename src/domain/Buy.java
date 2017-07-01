package domain;

import java.util.Date;

public class Buy {
	private Date purchaseDate;
    private String companyName;
    private int quantity;
    private double basePurAmount;
    private double avlAmount;
    private String status;
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getBasePurAmount() {
		return basePurAmount;
	}
	public void setBasePurAmount(double basePurAmount) {
		this.basePurAmount = basePurAmount;
	}
	public double getAvlAmount() {
		return avlAmount;
	}
	public void setAvlAmount(double avlAmount) {
		this.avlAmount = avlAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
