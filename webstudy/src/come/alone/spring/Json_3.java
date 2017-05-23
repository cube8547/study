package come.alone.spring;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	@WebServlet("/json_3")
	public class Json_3 extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
	    public Json_3() {
	        super();
	        
	    }
	    @Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {

			System.out.println("json_3 call");
		
			//resp.sendRedirect("/WEB-INF/jsp/request/json_3.jsp");

			RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/jsp/request/json_3.jsp" );
			rd.forward(req,resp);
			
		}
	
	
}
