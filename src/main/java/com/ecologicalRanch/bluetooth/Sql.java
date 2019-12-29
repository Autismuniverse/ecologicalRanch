package com.ecologicalRanch.bluetooth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sql {
	private static Connection ct = null;
	private static java.sql.Statement stmt= null;
	private static ResultSet rs= null;
	
	public void Console() {
		String driverName="com.mysql.cj.jdbc.Driver";
		//String dbURL="jdbc:mysql://localhost:3306/ecological_ranch";
		String dbURL="jdbc:mysql://10.12.9.210:3306/ecological_ranch?serverTimezone=GMT%2B8";
		String userName="root";
	    String userPwd="password";
		try
		{
		    Class.forName(driverName);
		    System.out.println("���������ɹ���");
		}catch(Exception e){
		    e.printStackTrace();
		    System.out.println("��������ʧ�ܣ�");
		}
		try{
			 
		    ct=DriverManager.getConnection(dbURL,userName,userPwd);
		    System.out.println("�������ݿ�ɹ���");
		}catch(Exception e)
		{
		    e.printStackTrace();
		    System.out.print("SQL Server����ʧ�ܣ�");
		}        
	}
	/**
	 * @param sql SQL�洢���
	 * @return  1���ɹ���-1��ʧ��
	 * @throws SQLException
	 */
	public int insertTimeData(String sql) throws SQLException { 
		int row = -1;
		try {            
			stmt = ct.createStatement();                      
			row=stmt.executeUpdate(sql);        
			} 
		catch (SQLException ex) 
			{           
				ex.printStackTrace();        
			}
		finally 
		{            
					stmt.close();        
		} 
		return row;
	}
/**
 * @param sql 
 * SQL��ѯ���
 * @return 
 */
	public ResultSet Query(String sql)
    {
    	try {
    		stmt = ct.createStatement(); 
    		rs=stmt.executeQuery(sql);		
		} catch (Exception e) {
			// TODO: handle exception
            e.printStackTrace();
		}
    	return rs;
    }
	public void  close() throws SQLException {
		if (rs != null) {
            rs.close();
            rs = null;
         }
      if (stmt != null) {
            stmt.close();
            stmt = null;
        }
      if (ct != null) {
            ct.close();
            ct = null;
        }
	}
}
