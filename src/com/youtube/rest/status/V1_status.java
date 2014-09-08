package com.youtube.rest.status;

import com.youtube.rest.dao.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;
import java.sql.SQLException;


@Path("/v1/status")
public class V1_status {
	
	//version of the api
	private static final String api_version = "00.01.00";
    
	@GET //by default, this method is executed
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version:  </p>" + api_version;
	}
	
	
	@Path("/database") 
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		java.sql.PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		java.sql.Connection conn = null;
		
		try {  
		    conn = MySqlSchwartz.MySqlSchwartzConn().getConnection();
		    query = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS ') DATETIME" +
		    		"FROM sys.dual");
		    ResultSet rs = query.executeQuery();
		    while (rs.next()) {
		    	myString = rs.getString("DATETIME");
		    }
		    query.close();  // close connection
		    returnString = "<p>Database status " +
		        "<p> Database Date/Time return: " + myString + "</p>";
		}
		catch ( SQLException sqe) {
				sqe.printStackTrace();
		}
		finally {
				
		}
			
		return returnString;		
	}
	
    
}
