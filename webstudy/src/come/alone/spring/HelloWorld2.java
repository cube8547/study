package come.alone.spring;



import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 */
@WebServlet("/HelloWorld2")
public class HelloWorld2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
  
    public HelloWorld2() {
        super();
        
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		System.out.println("HelloWorld call");
		
		Date date = new Date(System.currentTimeMillis());

		resp.getWriter().println("<h1>Hello World!!! "+ date.toString() +"</h1>");
	}

    

}