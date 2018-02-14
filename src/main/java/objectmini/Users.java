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
public class Users {
    ObjectId id;
    String nom;
    String prenom;
    String mail;
    String pseudo;
    String motdepasse;
    String q1;
    //String q2;
    String r1;
    //String r2;
    
    public Users (ObjectId i, String n, String p, String m, String ps, String mdp, String qq1,  String rr1) throws Exception{
	setId(i);
	setNom(n);
	setPrenom(p);
        setMail(m);
        setPseudo(ps);
        setMdp(mdp);
        setQ1(qq1);
        //setQ2(qq2);
        setR1(rr1);
        //setR2(rr2);
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
	
	
	public void setPrenom( String ec) throws Exception 
	{
		prenom=ec;
	}
	public String getPrenom(){return prenom;}
        
        public void setMail( String mai) throws Exception 
	{
		mail=mai;
	}
	public String getMail(){return mail;}
        
        public void setPseudo( String ps) throws Exception 
	{
		pseudo=ps;
	}
	public String getPseudo(){return pseudo;}
        
        public void setMdp( String md) throws Exception 
	{
		motdepasse=md;
	}
	public String getMdp(){return motdepasse;}
        
        public void setQ1( String qq1) throws Exception
	{
		q1=qq1;
	}
	public String getQ1(){return q1;}
        
        
        /*public void setQ2( String qq2) throws Exception
	{
		q2=qq2;
	}
	public String getQ2(){return q2;}
        */
        public void setR1( String rr1) throws Exception
	{
		r1=rr1;
	}
	public String getR1(){return r1;}
        
        /*public void setR2( String rr2) throws Exception
	{
		r2=rr2;
	}
	public String getR2(){return r2;}*/
    
}
