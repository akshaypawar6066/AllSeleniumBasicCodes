package demo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JavaMongoDbConnection {
	public static void main(String[] args) {
		/*
		 * Step1-Create mongodb connection
		 */
		// Step1-Create mongodb connection 
      MongoClient mongoClient=new MongoClient("localhost",27017);
      System.out.println("Created mongo connection succesfully");
      
    // Step2-Get a handle to the specific database
      MongoDatabase mydb= mongoClient.getDatabase("mydb");
      System.out.println("Get database is succesful:");
      //Step-3 Create collection in the database and inser document in the created collection
      MongoCollection<Document> myCollection=mydb.getCollection("myCollection");
      System.out.println("Get Collection is succesful:");
      Document document=new Document("name", "Akshay");
      myCollection.insertOne(document);
     System.out.println("Inserted document in the collection");
     System.out.println("*******************");
      
     
      
      for(String databaseName:mongoClient.listDatabaseNames())
      {
    	  System.out.println(databaseName);
      }
      mongoClient.dropDatabase("mydb");
      System.out.println("Dropped database");
      for(String databaseName:mongoClient.listDatabaseNames())
      {
    	  System.out.println(databaseName);
      }
      
      mongoClient.close();
	}
}
