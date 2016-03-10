package org.agromart.helper;

import java.util.Map;

import org.apache.log4j.Logger;







import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DbConnectionHelper
{
	private static Logger logger = Logger.getLogger(DbConnectionHelper.class);
	private static DB db = null;
	private static DbConnectionHelper instance = new DbConnectionHelper();
	
	private DbConnectionHelper(){}
	public static DbConnectionHelper getInstance(){
	
			if (db == null) {
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			db=mongoClient.getDB("TESTDB");
			 

			}
			 //MongoDatabase database = mongoClient.getDatabase("TESTDB");
			 //System.out.println("Connection test"+database.getName());
			
				
	      
		return instance;

	}
	
	public DBCursor getDocuments(String collectionName) {
		/*DBCollection coll = db.getCollection(collectionName);
		DBObject keys = new BasicDBObject();
		for (Map.Entry<String,Object> entry: fieldMap.entrySet()) {
			keys.put(entry.getKey(), entry.getValue());
		}
		DBObject object = coll.findOne(keys);
		return object== null ? null : object.toString();
		*/
		
		 DBCollection dbCollection = db.getCollection(collectionName);
			//DBObject keys = new BasicDBObject();
			//keys.put("name", "Dhondu");
			BasicDBObject query = new BasicDBObject("name", "Dhondu"); 
			BasicDBObject fields = new BasicDBObject("items",1).append("_id",false);
			DBCursor curs = dbCollection.find(query, fields);
			
			return curs;
	}
}