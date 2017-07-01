package controller;

import helper.Connections;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import domain.Sell;

public class SellController {
	
	public void loggingSell(Date sellDate, String companyName, int quantity, double baseSellAmount){
		Sell sell = new Sell();
		if(sellDate==null){
			sell.setSellDate(new Date());
		}else{
			sell.setSellDate(sellDate);
		}
		sell.setCompanyName(companyName);
		sell.setQuantity(quantity);
		sell.setBaseSellAmount(baseSellAmount);
		double pf_lo=calculateProfitOrLoss(quantity,baseSellAmount,companyName);
		if(pf_lo>0){
			sell.setProfit(pf_lo);
		}else{
			sell.setLoss(pf_lo);
		}
		excuteSell(sell);
	}
	private void excuteSell(Sell sell){
		DBCollection collection=Connections.getConnect().getCollection("Buy");
        BasicDBObject query = new BasicDBObject("sellDate", sell.getSellDate()).
                append("companyName", sell.getCompanyName()).
                append("quantity", sell.getQuantity()).
                append("baseSellAmount", sell.getBaseSellAmount()).
                append("profit", sell.getProfit()).
                append("loss", sell.getLoss());
        collection.insert(query);
        TransactionController controller=new TransactionController();
        controller.loggingTransaction(sell.getQuantity()*sell.getBaseSellAmount(), sell.getSellDate(), "Sold "+sell.getQuantity()+" for Company "+sell.getCompanyName());
	}
	
	private double calculateProfitOrLoss(int quantity, double baseSellAmount, String companyName){
		return 0;
	}
}
