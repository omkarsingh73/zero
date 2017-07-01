package helper;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Connections {
	public static DB getConnect(){
		try{
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         DB db = mongoClient.getDB( "mydb" );
	         System.out.println("Connect to database successfully");
	         return db;
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
		return null;
	}
}
