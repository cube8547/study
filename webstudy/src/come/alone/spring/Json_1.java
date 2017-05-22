package come.alone.spring;



import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * http://localhost:8070/webstudy/Json_1
 */
@WebServlet("/Json_1")
public class Json_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
  
    public Json_1() {
        super();
        
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		System.out.println("Json_1 call");
		
		Date date = new Date(System.currentTimeMillis());

		RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/jsp/request/json_1.jsp" );
		rd.forward(req,resp);
	}

    

}