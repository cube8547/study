package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
자바 서버 페이지 JSP 와 Servlet 간에 데이터를 주고 받는 방법을 구현해 보도록 하겠습니다. 
JSP 페이지에서 PSOT/GET 방식으로 Request 하게 되면 Servlet 자바 클래스에서 내용을 받아 처리한 후 Response 로 응답하게 됩니다.
 
▼ 먼저 웹 어플리케이션 프로젝트를 생성합니다. 그리고 패키지로 가서 오른 마우스를 클릭한 후 [New] > [Other] 메뉴를 선택합니다.
 Servlet 생성 메뉴가 없기 때문입니다. 새 파일 생성 창에서 Web 폴더로 가시면 Servlet 을 볼 수 있습니다.


▼ 새 파일 생성 팝업창을 띄워서 Servlet 을 선택한 이유는 자동으로 GET/POST 함수를 만들어 주기 때문입니다. 
HttpServlet 을 상속받아 만들기 때문에 가능한 것입니다. 매번 만들어야 되는 함수이기 때문에 자동으로 만들면 편하겠죠.

▼ JSP 페이지에서 POST 방식으로 데이터를 보내게 되면 doPost() 함수에서 값을 처리해야 합니다. 
클라이언트에서 euc-kr 로 보낼 것이기 때문에 request 클래스에 euc-kr 로 세팅 해 줍니다. 
받았다는 것을 알리기 위해 response 객체로 다시 클라이언트에 값을 보냅니다. 보낼 때 response 객체의 setContentType() 함수로 text/html;charset=euc-kr 을 입력해 줘야 합니다. 
그렇지 않으면 글자가 깨지게 됩니다.



*/
/**
 * Servlet implementation class LoginValue
 */
public class LoginValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 깨짐 방지
		request.setCharacterEncoding("euc-kr");
		
		//값 가져오기
		String id = request.getParameter("name");
		
		//출력하기
		response.setContentType("text/html/charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print("<HTML>");
		out.print("<HEAD><TITLE>FORM</TITLE></HEAD>");
		out.print("<BODY>");
		out.print("ID 값은 " + id + "입니다");
		out.print("/BODY");
		out.print("<HTML>");
		out.close();		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
