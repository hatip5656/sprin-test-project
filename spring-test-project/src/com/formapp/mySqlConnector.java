package com.formapp;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.formapp.Form;
public class mySqlConnector {
	Connection con;
	
	public boolean checkDB(){
		String dbName="basvuru_form";

	    try{
	    	Class.forName("com.mysql.jdbc.Driver");

	      
	        con = DriverManager.getConnection("jdbc:mysql://localhost", "root", ""); 

	        ResultSet resultSet = con.getMetaData().getCatalogs();

	        while (resultSet.next()) {

	          String databaseName = resultSet.getString(1);
	            if(databaseName.equals(dbName)){
	                return true;
	            }
	        }
	        resultSet.close();
	        con.close();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return false;
	}
	 public void createDB() throws ClassNotFoundException{
		 try{
		 if(checkDB()==false){
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
					Statement s =con.createStatement();
					 s.executeUpdate("CREATE DATABASE basvuru_form");}
		 con.close();
		 }
		 catch(SQLException ex){
			 ex.printStackTrace();
		 }
	 }
	 public boolean checkTable() throws ClassNotFoundException{
			boolean result=false;
			try{
			Class.forName("com.mysql.jdbc.Driver"); 

		      
	        con = DriverManager.getConnection("jdbc:mysql://localhost/basvuru_form", "root", "");
			DatabaseMetaData dbm = con.getMetaData();
			
			ResultSet tables = dbm.getTables(null, null, "basvuruform", null);
			if (tables.next()) {
			 result=true;
			}
			else {
			result=false;
			}
			 con.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			return result;
		}
	 public void createTable() throws ClassNotFoundException{
		 
		 createDB();
		 if(checkTable()==false){
			 try{
					Class.forName("com.mysql.jdbc.Driver"); 
			        con = DriverManager.getConnection("jdbc:mysql://localhost/basvuru_form?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			        Statement s =con.createStatement();
					 s.executeUpdate("CREATE TABLE `basvuruform` ( `name` varchar(100) NOT NULL, `tc` varchar(11) NOT NULL, `adres` varchar(2000) NOT NULL,`tel` varchar(30) NOT NULL, `email` varchar(1000) NOT NULL, `dt` date NOT NULL, `perakende` varchar(1000) , `sebep` varchar(1000) , `il` varchar(200) , `miktar` int(11) , `ek` varchar(3000), PRIMARY KEY (`tc`), UNIQUE KEY `tc` (`tc`)) ENGINE=InnoDB  CHARSET=utf8 COLLATE utf8_turkish_ci;");
			  con.close();
			 }catch(SQLException ex){ ex.printStackTrace();}
		 }
		 
		 
		 
	 }
	
	 public String addTable(Form Form) throws ClassNotFoundException{
		 
		 String message;
		 try {
			 createTable();
			 
			 
			 Class.forName("com.mysql.jdbc.Driver"); 
		        con = DriverManager.getConnection("jdbc:mysql://localhost/basvuru_form", "root", "");
				
				PreparedStatement statement=
			      con.prepareStatement("INSERT INTO `basvuruform` ( `name`, `tc`, `adres`, `tel`,`email`, `dt`, `perakende`, `sebep`, `il`, `miktar`, `ek`)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?)");
				
				statement.setString(1, Form.getName());		
				statement.setString(2, Form.getTc());
				statement.setString(3, Form.getAdres());
				statement.setString(4, Form.getTel());
				statement.setString(5, Form.getEmail());
				statement.setDate(6, Form.getDt());
				statement.setString(7, Form.getPerakende());
				statement.setString(8,Form.getSebep());
				statement.setString(9, Form.getIl());
				statement.setInt(10, Form.getMiktar());
				statement.setString(11, Form.getEk());
				statement.execute();
				
				con.close();
				message= "Formunuz baþarýlý bir þekilde kaydedilmiþtir.";
			} catch (SQLException e) {
			
				message="bir hata olustu <br>"+e.getMessage();
				e.printStackTrace();}
		 
		return message;
	 }
}
	

