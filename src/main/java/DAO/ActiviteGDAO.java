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
import objectmini.ActiviteG;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class ActiviteGDAO {
    
       ConnectionDBM mon = new ConnectionDBM();
    String[] str = new String[30];
    ActiviteG[] ct=new ActiviteG[10];
    
    public ActiviteG[] listActiviteG() throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteG");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
            DBObject query =null;
            

            
            cursor = table.find();
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String gout = String.valueOf(obj.get("gout"));
                        String description = String.valueOf(obj.get("description"));
                        int point = Integer.parseInt(String.valueOf(obj.get("point")));
                        
                        
                        ct[a]=new ActiviteG(id, gout, description, point);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }
    
    
    
    
    
     public ActiviteG[] findActiviteG(String nm) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteG");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
             DBObject query =
            QueryBuilder.start().or(
                    QueryBuilder.start("gout").regex(Pattern.compile(nm)).get()
            ).get();

            
            cursor = table.find(query);
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                  DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String gout = String.valueOf(obj.get("gout"));
                        String description = String.valueOf(obj.get("description"));
                        int point = Integer.parseInt(String.valueOf(obj.get("point")));
                        
                        ct[a]=new ActiviteG(id, gout, description, point);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }

    

    


    public void insertActiviteG(String n, String des, int poi) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteG");
            BasicDBObject document = new BasicDBObject();
            document.put("gout", n);
            document.put("description", des);
            document.put("point", poi);
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void deleteActiviteG(String nm) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("ActiviteG");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("gout", nm);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
