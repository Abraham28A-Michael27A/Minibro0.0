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
import objectmini.Avatar;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class AvatarDAO {
    
    ConnectionDBM mon = new ConnectionDBM();
    String[] str = new String[30];
    Avatar[] ct=new Avatar[10];
    
    public Avatar[] listAvatar() throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
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
                        String user = String.valueOf(obj.get("user"));
                        String gout = String.valueOf(obj.get("gout"));
                        String caractere = String.valueOf(obj.get("caractere"));
                        String message = String.valueOf(obj.get("message"));
                        String requete = String.valueOf(obj.get("requete"));
                        Double humeur = (Double)(obj.get("humeur"));
                        Double attention = (Double)(obj.get("attention"));
                        Double pa = (Double)(obj.get("pa"));
                        Double img = (Double)(obj.get("img"));
                        
                        ct[a]=new Avatar(id, nom, user, gout, caractere, message, requete, humeur, attention, pa, img);
                        a++;
                    
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }
    
    
    
    
    
     public Avatar[] findAvatar(String nm) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
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
                        String user = String.valueOf(obj.get("user"));
                        String gout = String.valueOf(obj.get("gout"));
                        String caractere = String.valueOf(obj.get("caractere"));
                        String message = String.valueOf(obj.get("message"));
                        String requete = String.valueOf(obj.get("requete"));
                        Double humeur = (Double)(obj.get("humeur"));
                        Double attention = (Double)(obj.get("attention"));
                        Double pa = (Double)(obj.get("pa"));
                        Double img = (Double)(obj.get("img"));
                        
                        ct[a]=new Avatar(id, nom, user, gout, caractere, message, requete, humeur, attention, pa, img);
                        a++;
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct;
    }

    

    
     public Avatar findAvatarOne(String nm) throws Exception {
        DBCursor cursor = null; DBCursor cursor1 = null;
        Avatar ct1=new Avatar();
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
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
                        String user = String.valueOf(obj.get("user"));
                        String gout = String.valueOf(obj.get("gout"));
                        String caractere = String.valueOf(obj.get("caractere"));
                        String message = String.valueOf(obj.get("message"));
                        String requete = String.valueOf(obj.get("requete"));
                        Double humeur = (Double)(obj.get("humeur"));
                        Double attention = (Double)(obj.get("attention"));
                        Double pa = (Double)(obj.get("pa"));
                        Double img = (Double)(obj.get("img"));
                        
                        ct1=new Avatar(id, nom, user, gout, caractere, message, requete, humeur, attention, pa, img);
                        a++;
            }
            
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return ct1;
    }
     


    public void insertAvatar(String n, String ur, String gt, String ctr, String mss, String req, Double hum, Double att, Double pp, Double img) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
            BasicDBObject document = new BasicDBObject();
            document.put("nom", n);
            document.put("user", ur);
            document.put("gout", gt);
            document.put("caractere", ctr);
            document.put("message", mss);
            document.put("requete", req);
            document.put("humeur", hum);
            document.put("attention", att);
            document.put("pa", pp);
            document.put("img", img);
            table.insert(document);
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void updateAvatarH(String n, Double hum, Double pp) throws Exception {
        
        Avatar aa=findAvatarOne(n);
        
        try {
            
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
            BasicDBObject document = new BasicDBObject();
            document.put("humeur", hum);
            document.put("pa", pp);
            
            BasicDBObject document2 = new BasicDBObject();
            document2.put("nom", aa.getNom());
            document.put("nom", aa.getNom());
            document2.put("user", aa.getUser());            
            document.put("user", aa.getUser());
            document2.put("gout", aa.getGout());            
            document.put("gout", aa.getGout());
            document2.put("caractere", aa.getCaractere());            
            document.put("caractere", aa.getCaractere());
            document2.put("message", aa.getMessage());            
            document.put("message", aa.getMessage());
            document2.put("requete", aa.getRequete());            
            document.put("requete", aa.getRequete());
            document2.put("humeur", aa.getHumeur());
            document2.put("attention", aa.getAttention());            
            document.put("attention", aa.getAttention());
            document2.put("pa", aa.getPa());
            document.put("img", aa.getImg());
            document2.put("img", aa.getImg());
            
            table.update(document2, document);
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAvatarA(String n, Double hum, Double pp) throws Exception {
        
        Avatar aa=findAvatarOne(n);
        
        try {
            
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
            BasicDBObject document = new BasicDBObject();
            document.put("attention", hum);
            document.put("pa", pp);
            
            BasicDBObject document2 = new BasicDBObject();
            document2.put("nom", aa.getNom());
            document.put("nom", aa.getNom());
            document2.put("user", aa.getUser());            
            document.put("user", aa.getUser());
            document2.put("gout", aa.getGout());            
            document.put("gout", aa.getGout());
            document2.put("caractere", aa.getCaractere());            
            document.put("caractere", aa.getCaractere());
            document2.put("message", aa.getMessage());            
            document.put("message", aa.getMessage());
            document2.put("requete", aa.getRequete());            
            document.put("requete", aa.getRequete());
            document.put("humeur", aa.getHumeur());
            document2.put("humeur", aa.getHumeur());
            document2.put("attention", aa.getAttention());   
            document2.put("pa", aa.getPa());
            document.put("img", aa.getImg());
            document2.put("img", aa.getImg());
            
            table.update(document2, document);
            
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAvatar(String nm) throws Exception {
        try {
            DB db = mon.getcon();
            DBCollection table = db.getCollection("Avatar");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("nom", nm);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    
}
