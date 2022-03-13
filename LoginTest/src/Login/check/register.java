package Login.check;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String uemail=request.getParameter("uemail");               
		String upass=request.getParameter("upass");
		
		System.out.println(uname+" "+uemail+" "+upass);
		
		Connection connection=ConnectionProvider.getConn();
		try {
			PreparedStatement pq=connection.prepareStatement("insert into elogin values(?,?,?)");
			pq.setString(1,uname);
			pq.setString(2,uemail);
			pq.setString(3,upass);
			
			HttpSession session1 = request.getSession(); 	
			  
            session1.setAttribute("uname", uname);
            
            HttpSession session2 = request.getSession(); 
			  
            session2.setAttribute("uemail", uemail);
            
            HttpSession session3 = request.getSession(); 
			  
            session3.setAttribute("upass", upass);
            
            
            
			int i=pq.executeUpdate();
			if(i>0) {
				response.getWriter().println("Data Inserted");
			}
			else {
				response.getWriter().println("No Data Inserted");
			}
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}





