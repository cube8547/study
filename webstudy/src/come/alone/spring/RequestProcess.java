package come.alone.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("request")
public class RequestProcess {


	 

	// 클래스에 @RequestMapping 어노테이션을 쓰면 상위 URL 이 추가된다.

	// http://localhost:8080/hellospring3/request/... 형태로 접근해야 한다.


	// return void 이면 request 와 같은 경로의 view 를 자동으로 찾는다.

	// http://localhost:8080/hellospring3/request/request.do 로 접근
	 @RequestMapping("request")
	 public void request1() {
	 }
	 
	 
	// return string 이면 해당 값의 view 를 찾는다.

	// http://localhost:8080/hellospring3/request/request2.do 로 접근
	 @RequestMapping("request2")
	 public String request2() {
	  return "/WEB-INF/jsp/request/request2.jsp";
	 }
	 
	 
	// parameter 가 있으면 파라미터를 받는다.
	// 만약 파라메터를 프리미티브 타입으로 해 놓으면 넘기지 않으면 오류난다. 
	// 그럼으로 파라메터는 왠만하면 Wrapper 타입으로 써줘야 한다.

	// http://localhost:8080/hellospring3/request/request3.do?param1=aa&param2=2 로 접근
	 @RequestMapping("request3")
	 public String request3(String param1,Integer param2) {
	  System.out.println("param1:"+param1+",param2:"+param2);

	  return "request/request";
	 }
	 

	// @RequestParam 어노테이션으로 파라메터의 좀 더 세세한 설정이 가능하다.

	// http://localhost:8080/hellospring3/request/request4.do?p1=aa&p2=2 로 접근
	 @RequestMapping("request4")
	 public String request4(
	   @RequestParam(value="p1",required=true) String param1,
	   @RequestParam(value="p2",required=true) Integer param2
	   ) {
	  System.out.println("param1:"+param1+",param2:"+param2);

	  return "request/request";
	 }
	 
	 
	// 파라메터에 Model 객체를 넣어놓으면 해당 객체에 속성을 추가하는것으로 view 에 데이터를 던져 줄 수 있다.

	// http://localhost:8080/hellospring3/request/request5.do 로 접근
	 @RequestMapping("request5")
	 public String request5(Model model) {
	  model.addAttribute("message","hello5");
	  return "request/request2";
	 }
	 
	// 리턴을 ModelAndView 를 받는것으로 view 에 데이터를 던져 줄 수도 있다.

	// http://localhost:8080/hellospring3/request/request6.do? 로 접근
	 @RequestMapping("request6")
	 public ModelAndView request6() {
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("request/request2");
	  modelAndView.getModel().put("message","hello6");

	  return modelAndView;
	 }
	 
	 
	// 파라메터와 model 을 혼용해서 사용할 수 있다.

	// http://localhost:8080/hellospring3/request/request7.do?param1=aa&param2=2 로 접근
	 @RequestMapping("request7")
	 public String request7(String param1,Integer param2,Model model) {
	  System.out.println("param1:"+param1+",param2:"+param2);
	  model.addAttribute("message","hello7");

	  return "request/request2";
	 }
	 
	// 마찬가지로 파라메터와 ModelAndView 를 같이 사용할수 있다.

	// http://localhost:8080/hellospring3/request/request8.do?param1=aa&param2=2 로 접근
	 @RequestMapping("request8")
	 public ModelAndView request8(String param1,Integer param2) {
	  System.out.println("param1:"+param1+",param2:"+param2);
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("request/request2");
	  modelAndView.getModel().put("message","hello8");

	  return modelAndView;
	 } 
	}




