import java.sql.*;


public class DataBaseOperations {

	String email;
	String password;
	String fullname;
	String user;
	String DataBaseName;
	Connection con;
	//constructor for login users
	public DataBaseOperations(String e,String p,String u) throws ClassNotFoundException, SQLException
	{
		this.email=e;
		this.password=p;
		this.user=u;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClothingManagementSystem","root","Hello_123") ;
		
		 
	}
	//constructor for sign in users
	public DataBaseOperations(String n,String e,String p,String u,String uid) throws ClassNotFoundException, SQLException
	{
		this.email=e;
		this.password=p;
		this.fullname=n;
		this.user=u;
		this.DataBaseName=uid;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClothingManagementSystem","root","Hello_123") ;
	}
	
	//checks wheather user entered valid credentials
	public boolean isValidUser() throws ClassNotFoundException, SQLException {
	
		String sql = "select * from "+user+" where email = "+"'"+ email +"'"+ " and password = " +"'"+password+"'";	
		
		
		
		 Statement st = con.createStatement();
		 
		 ResultSet rs =  st.executeQuery(sql);
		
		 if(rs.next())
		 {
			 if(user.equals("Agent"))
			 {
			   this.DataBaseName=rs.getNString("userid");
			 }
			 return true;
		 }
		 
		return false;
		
	}
	//inserts new user in our database and also creates a database for him if he is an agent
	public boolean signin() throws ClassNotFoundException, SQLException
	{
		
		if(!this.isAlreadyPresent())
		{
			String sql = "insert into "+user+" values('"+fullname+"',"+"'"+email+"',"+"'"+password+"'," +"'"+DataBaseName+"')";
			
			
			 Statement st = con.createStatement();
			 st.execute(sql);
			 
			 st.close();
			 con.close();
			 
			 //Creating database for the Agent and checking using session attribute user
			 if(user.equals("Agent"))
			 {
			 String db = "create database "+DataBaseName;
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Hello_123") ;
			 Statement s = c.createStatement();
			 s.execute(db);
			 }
			
			return true;
		}
		
		return false;
	}
	//checks whether user with a particular email and userid is already present in our database
	
	private boolean isAlreadyPresent() throws ClassNotFoundException, SQLException
	{
		String sql = "select * from " +user +" where email = '"+email+"'";
		
		
		 Statement st = con.createStatement();
		 
		 ResultSet rs =  st.executeQuery(sql);
		 
		 if(rs.next())
		 {
			 return true;
		 }
		
		return false;
	}
	
	

}
	

