package controller.ManagerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mgrMyPage
 */
@WebServlet("/mgrMyPage")
public class mgrMyPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	
	protected void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("command") != null) {
			String command = request.getParameter("command");
			if(command.equals("home")) {
				//나의 as리스트 메인으로 연결 
				forward("./admin_view/member/MyPage.jsp", request, response);
			}
			
			
		}
	}
	
	protected void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//위에서 로직처리후 url주소와  req(리턴값), resp(리턴)
		//돌아가는 함수
		RequestDispatcher dispatch = req.getRequestDispatcher(url);
		dispatch.forward(req, resp);	
	}
}
