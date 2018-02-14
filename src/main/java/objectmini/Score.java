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
public class Score {
    ObjectId id;
    String avatar;
    int hgagne;
    int agagne;
    
    public Score (ObjectId i, String n, int h, int a) throws Exception{
	setId(i);
	setAvatar(n);
	setHgagne(h);
        setAgagne(h);     
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
	
	
    public void setHgagne( int qq2) throws Exception
	{
		hgagne=qq2;
	}
    public int getHgagne(){return hgagne;}
    
    public void setAgagne( int qq2) throws Exception
	{
		agagne=qq2;
	}
    public int getAgagne(){return agagne;}
}
