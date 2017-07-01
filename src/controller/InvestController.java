package controller;

import helper.Connections;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import domain.InvestAmount;

public class InvestController {
	private int tax=9;
	
	public void loggingInvest(double amountAdded, Date tranDate){
		InvestAmount amount = new InvestAmount();
		if(tranDate==null){
			amount.setTranDate(new Date());
		}else{
			amount.setTranDate(tranDate);
		}
		amount.setAmountAdded(amountAdded);
		amount.setTaxAmount(tax*1.15);
		amount.setTotalAmount(getTotalAmount()+(amountAdded-tax*1.15));
		excuteInvest(amount);
	}
	
	private static double getTotalAmount(){
		double currentAmount=0.0;
		DBCollection collection= Connections.getConnect().getCollection("InvestAmount");
		DBCursor cursor = collection.find().sort(new BasicDBObject("tranDate",-1)).limit(1);
		while (cursor.hasNext()) { 
			cursor.next();
			currentAmount=(Double) cursor.curr().get("totalAmount");
		}
		return currentAmount;
		
	}
	
	private void excuteInvest(InvestAmount amount){
		DBCollection collection=Connections.getConnect().getCollection("InvestAmount");
        BasicDBObject query = new BasicDBObject("tranDate", amount.getTranDate()).
                append("amountAdded", amount.getAmountAdded()).
                append("taxAmount", amount.getTaxAmount()).
                append("totalAmount", amount.getTotalAmount());
        collection.insert(query);
	}

}
