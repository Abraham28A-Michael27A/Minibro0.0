/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmini;

import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class Caractere {
    ObjectId id;
    String nom;
    String description;
    
    public Caractere (ObjectId i, String n, String iu) throws Exception{
	setId(i);
	setNom(n);
	setDescription(iu);     
    }
    
    public void setId( ObjectId i) throws Exception
	{
		id=i;
	}
    public ObjectId getId(){return id;}
	
	
    public void setNom( String eco) throws Exception 
    {
	nom=eco;
    }
    public String getNom(){return nom;}
	
	
    public void setDescription( String ec) throws Exception 
    {
	description=ec;
    }
    public String getDescription(){return description;}
    
}
