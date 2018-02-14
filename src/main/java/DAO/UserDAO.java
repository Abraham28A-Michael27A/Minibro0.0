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
import objectmini.Users;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class UserDAO {
    
    
    ConnectionDBM mon = new ConnectionDBM();
    String[] str = new String[30];
    Users[] ct=new Users[10];
    
    public Users[] listUsers() throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("User");
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
                        String prenom = String.valueOf(obj.get("prenom"));
                        String mail = String.valueOf(obj.get("mail"));
                        String pseudo = String.valueOf(obj.get("pseudo"));
                        String mdp = String.valueOf(obj.get("mdp"));
                        String q1 = String.valueOf(obj.get("q1"));
                        //String q2 = String.valueOf(obj.get("q2"));
                        String r1 = String.valueOf(obj.get("r1"));
                        //String r2 = String.valueOf(obj.get("r2"));
                        
                        
                        
                        
                        ct[a]=new Users(id, nom, prenom, mail, pseudo, mdp, q1,  r1);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }
    
    
    
    
    
     public Users[] findUsers(String pse, String md) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("User");
            BasicDBObject searchQuery = new BasicDBObject();
            BasicDBObject searchQuery1 = new BasicDBObject();
             DBObject query =
            QueryBuilder.start().or(
                    QueryBuilder.start("pseudo").regex(Pattern.compile(pse)).get(),
                    QueryBuilder.start("mdp").regex(Pattern.compile(md)).get()
            ).get();

            
            cursor = table.find(query);
            
           int a=0;
          
            while (cursor.hasNext()) 
            {
                DBObject obj = cursor.next();
                
                        ObjectId id  = (ObjectId)(obj.get("_id"));
                        String nom = String.valueOf(obj.get("nom"));
                        String prenom = String.valueOf(obj.get("prenom"));
                        String mail = String.valueOf(obj.get("mail"));
                        String pseudo = String.valueOf(obj.get("pseudo"));
                        String mdp = String.valueOf(obj.get("mdp"));
                        String q1 = String.valueOf(obj.get("q1"));
                        //String q2 = String.valueOf(obj.get("q2"));
                        String r1 = String.valueOf(obj.get("r1"));
                        //String r2 = String.valueOf(obj.get("r2"));
                        
                        Double note = (Double)(obj.get("Note"));
                        
                        
                        ct[a]=new Users(id, nom, prenom, mail, pseudo, mdp, q1,  r1);
                        a++;
                    
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }

    

    


    public void insertUsers(String n, String pr, String mai, String pse, String md, String qq1,  String rr1) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("User");
            BasicDBObject document = new BasicDBObject();
            document.put("nom", n);
            document.put("prenom", pr);
            document.put("mail", mai);
            document.put("pseudo", pse);
            document.put("mdp", md);
            document.put("q1", qq1);
            //document.put("q2", qq2);
            document.put("r1", rr1);
            //document.put("r2", rr2);
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsers(String pse) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("User");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("pseudo", pse);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    
}
