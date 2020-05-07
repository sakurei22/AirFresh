package controller.MemberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	
	protected void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("command") != null) {
			String command = request.getParameter("command");
			
			if(command.equals("login")) {
				userLogin(request, response);
			
			}else if(command.equals("logout")) {
				userLogout(request, response);
			}
		}

	}
	
	protected void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//위에서 로직처리후 url주소와  req(리턴값), resp(리턴)
		//돌아가는 함수
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);	
	}
	
	//로그인버튼 클릭시 처리
	protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("login") == null) {
			//비로그인 상태   ---> 로그인 페이지로 이동 
			response.sendRedirect(request.getContextPath() + "/client_view/member/login.jsp");
			
		}else {
			//로그인 상태   -----> 마이페이지
			response.sendRedirect(request.getContextPath() + "/client_view/member/mypage.jsp");
		}
	}
	
	//로그아웃버튼 클릭시 처리 
	protected void userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션정보 지우고 메인페이지로 이동 
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
}
