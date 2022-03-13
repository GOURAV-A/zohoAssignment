package Login.check;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class welcome extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String uemail=request.getParameter("uemail");
		String upass=request.getParameter("upass");
		
		System.out.println(uemail+" "+upass);
		
		Connection connection=ConnectionProvider.getConn();
		try {
			PreparedStatement pq=connection.prepareStatement("select * from elogin where email=? and password=?");
		
			pq.setString(1,uemail);
			pq.setString(2,upass);
			ResultSet rs=pq.executeQuery();
			if(rs.next()) {
				response.sendRedirect("welcome.html");
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("newreg.html");
				response.getWriter().println("Invalid user name/Pass...");
			}
			
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
