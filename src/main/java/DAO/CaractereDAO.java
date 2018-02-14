/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import connectdbm.ConnectionDBM;
import java.util.regex.Pattern;
import objectmini.Caractere;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class CaractereDAO {
    
        
    ConnectionDBM mon = new ConnectionDBM();
    String[] str = new String[30];
    Caractere[] ct=new Caractere[10];
    
    public Caractere[] listCaractere() throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Caractere");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
            DBObject query =null;
            

            
            cursor = table.find();
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String nom = String.valueOf(obj.get("nom"));
                        String description = String.valueOf(obj.get("description"));
                        
                        ct[a]=new Caractere(id, nom, description);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }
    
    
    
    
    
     public Caractere[] findCaractere(String nm) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Caractere");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
             DBObject query =
            QueryBuilder.start().or(
                    QueryBuilder.start("nom").regex(Pattern.compile(nm)).get()
            ).get();

            
            cursor = table.find(query);
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                  DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String nom = String.valueOf(obj.get("nom"));
                        String description = String.valueOf(obj.get("description"));
                        
                        ct[a]=new Caractere(id, nom, description);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }

    

    


    public void insertCaractere(String n, String des) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Caractere");
            BasicDBObject document = new BasicDBObject();
            document.put("nom", n);
            document.put("description", des);
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void deleteCaractere(String nm) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Caractere");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("nom", nm);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    
}
