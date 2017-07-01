package controller;

import helper.Connections;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import domain.Buy;

public class BuyController {

	public void loggingBuy(Date purchaseDate, String companyName, int quantity, double basePurAmount){
		Buy buy=new Buy();
		if(purchaseDate==null){
			buy.setPurchaseDate(new Date());
		}else{
			buy.setPurchaseDate(purchaseDate);
		}
		buy.setCompanyName(companyName);
		buy.setQuantity(quantity);
		buy.setBasePurAmount(basePurAmount);
		buy.setStatus("onhold");
		buy.setAvlAmount(calculateAvlAmount(quantity,basePurAmount));
		excuteBuy(buy);
	}
	private void excuteBuy(Buy buy){
		DBCollection collection=Connections.getConnect().getCollection("Buy");
        BasicDBObject query = new BasicDBObject("purchaseDate", buy.getPurchaseDate()).
                append("companyName", buy.getCompanyName()).
                append("quantity", buy.getQuantity()).
                append("basePurAmount", buy.getBasePurAmount()).
                append("avlAmount", buy.getAvlAmount()).
                append("status", buy.getStatus());
        collection.insert(query);
        TransactionController controller=new TransactionController();
        controller.loggingTransaction(buy.getQuantity()*buy.getBasePurAmount(), buy.getPurchaseDate(), "Buy "+buy.getQuantity()+" for Company "+buy.getCompanyName());
	}
	private double calculateAvlAmount(int quantity, double basePurAmount){
		double currentValue = quantity*basePurAmount;
		return TransactionController.getCurrentAmount()-currentValue;
	}
}
