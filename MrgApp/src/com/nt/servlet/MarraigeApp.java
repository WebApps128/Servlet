package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MarraigeApp")
public class MarraigeApp extends HttpServlet {
	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  
		PrintWriter pw = res.getWriter();
		  
		  String pname=null;
		  String page=null;
		  int age=0;
		  String gender;  
		  
		  res.setContentType("text/html");

		  pname=req.getParameter("pname");
		  page=req.getParameter("page");
		  age=Integer.parseInt(page);
		  gender=req.getParameter("gender");
		  
		  // logic
		  
		  if(gender=="male") {

			  if(age>=21)
				  pw.println("you are eligible for marraige");
			  else
				  pw.println("you are  not eligible for marraige");
	   }
		  
		  else
		  {
			  
			  if(age>=18)
				  pw.println("<h1>you are eligible for marraige</h1>");
			  else
				  pw.println("<h1>you are not eligible for marraige</h1>");
		  }
	    	  
		  pw.println("<a href='input.html'><img src='home.png'></a>");
	   pw.close();	  
		
	   
	   
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

}