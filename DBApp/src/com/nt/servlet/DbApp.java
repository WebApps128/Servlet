package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DbApp extends HttpServlet {
	private static final String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	        
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int eno=0;
		
		try {
		      PrintWriter pw= res.getWriter();
              res.setContentType("text/html");
              eno=Integer.parseInt(req.getParameter("eno"));
          
       //JDBC CODE To connect java program with JDBC
              
            	  //register JDBC driver
            	  Class.forName("oracle.jdbc.driver.OracleDriver");
            	  
            	  //establish connection
            	  
            	  Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
            	  
            	  //Create JDBC Prepared Statement
            	  
            	  PreparedStatement ps1=con1.prepareStatement(query);
            	  
            	  
            	  //SET PARAM VALUE FOR SQL QUERY
            	  
            	  ps1.setInt(1,eno);
            	  
            	  //Execute the SQL query
            	  
            	  ResultSet rs1= ps1.executeQuery();
            	  
            	  //process the result
            	  
            	  if(rs1.next()) {
            		  pw.println("<br>Employ no::"+rs1.getInt(1));
            		  pw.println("<br>Employ Name::"+rs1.getString(2));
            		  pw.println("<br>Employ job::"+rs1.getString(3));
            		  pw.println("<br>Employ sal::"+rs1.getInt(4));
            		  pw.println("<br>Employ deptno::"+rs1.getInt(5));
            	  
            	  }//if end
            	  
            	  else {
            		  pw.println("<br>NO Employee found");
            	  }
            	  
            	  
              }//try End
		      catch(SQLException se) {
		    	  se.printStackTrace();
		          
		      }
		  
		      catch(ClassNotFoundException cnf) {
		    	  cnf.printStackTrace();
		      }
		
		      catch(Exception  e) {
		    	  e.printStackTrace();
		      }
              
              finally {
            	  
            	  try {
            		  if(rs!=null)
            			  rs.close();
            	   }
            	  catch(SQLException se) {
            		  se.printStackTrace();
            	  }
            	  
            	  try {
            		  if(ps!=null)
            	      ps.close(); 
            	  }
            	  catch(SQLException se) {
            		  se.printStackTrace();
            	  }
            	  
            	  try {
            		  if(con!=null)
            	      con.close();
            	  }
            	  catch(SQLException se) {
            		  se.printStackTrace();
            	  }
            	  
              }//finally end
                       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
