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
public class Photom {
    ObjectId id;
    String avatar;
    String description;
    
    public Photom (ObjectId i, String n, String iu) throws Exception{
	setId(i);
	setAvatar(n);
	setDescription(iu);     
    }
    
    public void setId( ObjectId i) throws Exception
	{
		id=i;
	}
    public ObjectId getId(){return id;}
	
	
    public void setAvatar( String eco) throws Exception 
    {
	avatar=eco;
    }
    public String getAvatar(){return avatar;}
	
	
    public void setDescription( String ec) throws Exception 
    {
	description=ec;
    }
    public String getDescription(){return description;}
}
