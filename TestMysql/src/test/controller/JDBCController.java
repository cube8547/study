package test.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc.do")
public class JDBCController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		
		
		if( cmd.equals("showDatabaseList")){
			list1(request, response);
		}
		if( cmd.equals("select_table1")){
			list2(request, response);
		}
		
	}
	
	private void list1(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	

		ArrayList<String> list = new ArrayList<String>();
		System.out.println("<< MySQL connection start >>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
			Connection con = null;

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306",
					"root", "hl8187");

			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery("SHOW DATABASES");
			
			if (st.execute("SHOW DATABASES")) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String str = rs.getNString(1);
				list.add(str);
								
				System.out.println(str);
			}
		}catch (ClassNotFoundException cne) {
			System.out.println("ClassNotFoundException: " + cne.getMessage());
		}
		catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
		
		System.out.println("<< MySQL connection end >>");
		
		
		request.setAttribute("databaselist", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}
	
	private void list2(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	

		ArrayList<String> list = new ArrayList<String>();
		System.out.println("<< MySQL connection start >>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
			Connection con = null;

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hl8187",
					"root", "hl8187");

			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			//rs = st.executeQuery("show tables");
			
			if (st.execute("select name from table1")) {
				rs = st.getResultSet();
			
				while (rs.next()) {
					String str = rs.getNString(1);
					list.add(str);
									
					System.out.println(str);
				}	
				
			}else{
				System.out.println( "!! rs is null !!");
			}
			
			
			/*
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBConnection.getConn();
				String sql = "select * from CBMember where id= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				
				if(rs.next()) {
					return 1;
				}else{
					return -1;
				}
				
				//return pstmt.executeUpdate();
			} catch (SQLException se) {
				se.printStackTrace();
				return -1;
			} finally {
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
			*/
			
		}catch (ClassNotFoundException cne) {
			System.out.println("ClassNotFoundException: " + cne.getMessage());
		}
		catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
		
		System.out.println("<< MySQL connection end >>");
		
		
		request.setAttribute("databaselist", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}
	
}
