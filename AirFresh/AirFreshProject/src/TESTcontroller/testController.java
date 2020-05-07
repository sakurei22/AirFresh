package TESTcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singleton.singleton;
@WebServlet("/hellotest")
public class testController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("do get !! ");
		
		
		singleton si = singleton.getInstance();
		
//		String hel = si.ms.hello();
//		System.out.println("hel = " + hel);
		//req.setAttribute("syshello", hel);
		
//		resp.sendRedirect("./Sample/helloTest.jsp?hel="+hel);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do POST  !! ");
	}
	
	
	
	

	

}//end class
