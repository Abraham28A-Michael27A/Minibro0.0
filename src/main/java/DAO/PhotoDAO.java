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
import objectmini.Photo;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class PhotoDAO {
    
    
     ConnectionDBM mon = new ConnectionDBM();
    String[] str = new String[30];
    Photo[] ct=new Photo[10];
    
    public Photo[] listPhoto() throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Photo");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
            DBObject query =null;
            

            
            cursor = table.find();
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String avatar = String.valueOf(obj.get("avatar"));
                        String description = String.valueOf(obj.get("description"));
                        
                        ct[a]=new Photo(id, avatar, description);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }
    
    
    
    
    
     public Photo[] findPhoto(String nm) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Photo");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
             DBObject query =
            QueryBuilder.start().or(
                    QueryBuilder.start("avatar").regex(Pattern.compile(nm)).get()
            ).get();

            
            cursor = table.find(query);
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                  DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String avatar = String.valueOf(obj.get("avatar"));
                        String description = String.valueOf(obj.get("description"));
                        
                        ct[a]=new Photo(id, avatar, description);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }

    

    


    public void insertPhoto(String n, String des) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Photo");
            BasicDBObject document = new BasicDBObject();
            document.put("avatar", n);
            document.put("description", des);
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void deletePhoto(String nm) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Photo");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("avatar", nm);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    
}
