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
import objectmini.ActiviteC;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class ActiviteCDAO {
    
       ConnectionDBM mon = new ConnectionDBM();
    String[] str = new String[30];
    ActiviteC[] ct=new ActiviteC[10];
    
    public ActiviteC[] listActiviteC() throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteC");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
            DBObject query =null;
            

            
            cursor = table.find();
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String caractere = String.valueOf(obj.get("caractere"));
                        String description = String.valueOf(obj.get("description"));
                        int point = Integer.parseInt(String.valueOf(obj.get("point")));
                        
                        
                        ct[a]=new ActiviteC(id, caractere, description, point);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }
    
    
    
    
    
     public ActiviteC[] findActiviteC(String nm) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteC");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
             DBObject query =
            QueryBuilder.start().or(
                    QueryBuilder.start("caractere").regex(Pattern.compile(nm)).get()
            ).get();

            
            cursor = table.find(query);
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                  DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String caractere = String.valueOf(obj.get("caractere"));
                        String description = String.valueOf(obj.get("description"));
                        int point = Integer.parseInt(String.valueOf(obj.get("point")));
                        
                        ct[a]=new ActiviteC(id, caractere, description, point);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }

    

    


    public void insertActiviteC(String n, String des, int poi) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteC");
            BasicDBObject document = new BasicDBObject();
            document.put("caractere", n);
            document.put("description", des);
            document.put("point", poi);
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void deleteActiviteC(String nm) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteC");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("caractere", nm);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    
}
