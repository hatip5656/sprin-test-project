package com.formapp;

import java.sql.Date;
import java.util.Calendar;

public class Form {
	
	
	String name;  
	String tc;
	String adres;
	String tel;
	String email;
	Date dt;
	String perakende;
	String sebep;
	String il;
	int miktar;
	String ek;
	 String message="";
	boolean formHata;
	
	
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setTc(String tc){
		this.tc=tc;
	}
	
	public String getTc(){
		return this.tc;
	}
	
	public void setAdres(String adres){
		this.adres=adres;
	}
	
	public String getAdres(){
		return this.adres;
	}
	
	public void setTel(String tel){
		this.tel=tel;
	}
	
	public String getTel(){
		return this.tel;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setDt(Date dt){
		this.dt=dt;
	}
	
	public Date getDt(){
		return this.dt;
	}
	
	
	public void setPerakende(String perakende){
		this.perakende=perakende;
	}
	
	public String getPerakende(){
		return this.perakende;
	}
	
	public void setSebep(String sebep){
		this.sebep=sebep;
	}
	
	public String getSebep(){
		return this.sebep;
	}
	
	public void setIl(String il){
		this.il=il;
	}
	
	public String getIl(){
		return this.il;
	}
	public void setMiktar(int miktar){
		this.miktar=miktar;
	}
	
	public int getMiktar(){
		return this.miktar;
	}
	
	
	public void setEk(String ek){
		this.ek=ek;
	}
	
	public String getEk(){
		return this.ek;
	}
	
	
	
	
	
	
	
	
	public Form get_validated(){
		try{
			 Calendar cal = Calendar.getInstance();
			    cal.setTime(dt);
			    int year = cal.get(Calendar.YEAR);
		
			if(tc.toCharArray().length>11 || tc.toCharArray().length!=11 ||tc.toCharArray().length<11 ){
				message+="Tc doðru girmediniz<br>";
			}
			if(name.isEmpty()){formHata=true;
			   message += "isim boþ olamaz<br>";
			   }
			if(tc.isEmpty()){formHata=true;
			   message += "TC boþ olamaz<br>";
			   }
			if(adres.isEmpty())
			{formHata=true;
			   message += "adres boþ olamaz<br>";
			   }
			if(year==1000)
			{formHata=true;
			
				message += "doðum tarihi ayarlanmadý<br>";
			}
			if(year>2000){formHata=true;
			   message += "yaþ 17'den büyük olmalidir<br>";
			   }
		}catch(NumberFormatException ex){
			ex.printStackTrace();
			
		}
		
		
		return this;
	}
	
}
