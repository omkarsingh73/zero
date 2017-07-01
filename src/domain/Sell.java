package domain;

import java.util.Date;

public class Sell {
	private Date sellDate;
    private String companyName;
    private int quantity;
    private double baseSellAmount;
    private double profit;
    private double loss;
	
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
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getLoss() {
		return loss;
	}
	public void setLoss(double loss) {
		this.loss = loss;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public double getBaseSellAmount() {
		return baseSellAmount;
	}
	public void setBaseSellAmount(double baseSellAmount) {
		this.baseSellAmount = baseSellAmount;
	}
}
