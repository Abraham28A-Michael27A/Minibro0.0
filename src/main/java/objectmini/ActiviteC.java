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
public class ActiviteC {
    ObjectId id;
    String caractere;
    String description;
    int point;
    
    public ActiviteC (ObjectId i, String c, String iu, int p) throws Exception{
	setId(i);
	setCaractere(c);
	setDescription(iu); 
        setPoint(p);
    }
    
    public void setId( ObjectId i) throws Exception
	{
		id=i;
	}
    public ObjectId getId(){return id;}
	
	
    public void setCaractere( String eco) throws Exception 
    {
	caractere=eco;
    }
    public String getCaractere(){return caractere;}
	
	
    public void setDescription( String ec) throws Exception 
    {
	description=ec;
    }
    public String getDescription(){return description;}
    
    public void setPoint( int qq2) throws Exception
	{
		point=qq2;
	}
    public int getPoint(){return point;}
    
}
