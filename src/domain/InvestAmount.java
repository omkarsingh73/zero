package domain;

import java.util.Date;

public class InvestAmount {
	private Date tranDate;
    private double amountAdded;
    private double taxAmount;
    private double totalAmount;
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public double getAmountAdded() {
		return amountAdded;
	}
	public void setAmountAdded(double amountAdded) {
		this.amountAdded = amountAdded;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
