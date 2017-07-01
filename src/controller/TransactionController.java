package controller;

import helper.Connections;
import java.util.Date;
import domain.TransactionHistory;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class TransactionController {
	
	public void loggingTransaction(double amount, Date trandate, String comments){
		TransactionHistory history = new TransactionHistory();
		history.setAmount(amount);
		if(trandate==null){
			history.setTranDate(new Date());
		}else{
			history.setTranDate(trandate);
		}
		history.setComments(comments);
		double currentBalance=getCurrentAmount();
		history.setCurrentBalance(currentBalance);
		excuteTransaction(history);
	}
	private void excuteTransaction(TransactionHistory history){
		DBCollection collection=Connections.getConnect().getCollection("TransactionHistory");
        BasicDBObject query = new BasicDBObject("tranDate", history.getTranDate()).
                append("amount", history.getAmount()).
                append("currentBalance", history.getCurrentBalance()).
                append("comments", history.getComments());
        collection.insert(query);
	}
	//public static void main(String[] args) {
//		DBCollection collection=Connections.getConnect().getCollection("TransactionHistory");
//        BasicDBObject query = new BasicDBObject("tranDate", new Date()).
//                append("amount", 2000.00).
//                append("currentBalance", 4489.65).
//                append("comments", "Testing");
//        collection.insert(query);
	//	getCurrentAmount();
	//}
	protected static double getCurrentAmount(){
		double currentAmount=0.0;
		DBCollection collection= Connections.getConnect().getCollection("TransactionHistory");
		DBCursor cursor = collection.find().sort(new BasicDBObject("tranDate",-1)).limit(1);
		while (cursor.hasNext()) { 
			cursor.next();
			currentAmount=(Double) cursor.curr().get("currentBalance");
		}
		return currentAmount;
		
	}
}
