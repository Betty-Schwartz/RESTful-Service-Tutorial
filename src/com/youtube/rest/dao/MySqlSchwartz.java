package com.youtube.rest.dao;

import java.sql.SQLException;

import javax.sql.*;
import javax.naming.*;


public class MySqlSchwartz {
	private static DataSource MySqlSchwartz = null;
	private static Context context = null;
	
	public static DataSource MySqlSchwartzConn() throws Exception {
		try {
			if ( context == null) {
				context = new InitialContext();
			}
			MySqlSchwartz = (DataSource) context.lookup("SchwartzDataSource * defined in Tomcat server");
			
		} catch (Exception sqe) {
			
		}
		
		return MySqlSchwartz;
		
	}

}