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
public class Message {
    ObjectId id;
    String avatard;
    String avatara;
    String description;
    
    public Message (ObjectId i, String n, String n2, String iu) throws Exception{
	setId(i);
	setAvatard(n);
        setAvatara(n2);
	setDescription(iu);     
    }
    
    public void setId( ObjectId i) throws Exception
	{
		id=i;
	}
    public ObjectId getId(){return id;}
	
	
    public void setAvatard( String eco) throws Exception 
    {
	avatard=eco;
    }
    public String getAvatard(){return avatard;}
    
    public void setAvatara( String eco) throws Exception 
    {
	avatara=eco;
    }
    public String getAvatara(){return avatara;}
	
	
    public void setDescription( String ec) throws Exception 
    {
	description=ec;
    }
    public String getDescription(){return description;}
    
}
