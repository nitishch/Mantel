package qasite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class pikachu
 */
public class pikachu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn = null;
    Statement st = null;
    
    public void init() throws ServletException{
    	String dburl = "jdbc:postgresql://localhost/test";
    	String user = "postgres";
    	String password = "one";
    	try{
    		Class.forName("org.postgresql.Driver");
    		conn = DriverManager.getConnection(dburl, user, password);
    		st = conn.createStatement();
    		
    		System.out.println("Connection done");
    	} 
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pikachu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			ResultSet rs;
			if(request.getParameter("type").equals("login")){
				System.out.println("passedloop");
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				rs = st.executeQuery("select count(*) from siteuser where uname = '" + userName + "';");
				System.out.println("passed");
				rs.next();
				if(rs.getInt(1) == 0){
					response.sendRedirect("/qasite/login.jsp?registered=false&wrong=false");
					return;
				}
				rs = st.executeQuery("select upassword from siteuser where uname = '" + userName + "';");
				rs.next();
				if(!request.getParameter("password").equals(rs.getString(1))){
					response.sendRedirect("/qasite/login.jsp?registered=true&wrong=true");
					return;
				}
				response.sendRedirect("/qasite/intro.jsp");
				return;
			}
			else if(request.getParameter("type").equals("signup")){
				String userName = request.getParameter("newUserName"), password1 = request.getParameter("password1"), password2 = request.getParameter("password2");
				
				if(password1.equals(password2)){
					rs = st.executeQuery("select count(*) from siteuser where uname = '" + userName + "';");
					rs.next();
					if(rs.getInt(1) == 0){ 
						rs = st.executeQuery("select count(*) from siteuser;");
						rs.next();
						Integer id = rs.getInt(1);
						st.executeUpdate("insert into siteuser values(" + id + ", '" + userName + "', '" + password1 + "');");
						response.sendRedirect("/qasite/intro.jsp");
						return;
					
					}
					else{
						response.sendRedirect("/qasite/signup.jsp?taken=true");
						return;
					}
				}
				response.sendRedirect("/qasite/signup.jsp?match=false");
				return;
			
				}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}