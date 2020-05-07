package controller.InstallController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.InstallDto;
import Dto.ManagerMemberDto;
import singleton.singleton;

/**
 * Servlet implementation class installcompController
 */
@WebServlet("/installcompController")
public class installcompController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	
	protected void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		singleton s = singleton.getInstance();
		
		if(request.getParameter("command") != null) {
			String command = request.getParameter("command");
			
			if(command.equals("home")) {
				
				ManagerMemberDto dto = (ManagerMemberDto)request.getSession().getAttribute("managerLogin");
				List<InstallDto> list = s.is.getCompMyList(dto.getMgr_index());
				
				request.setAttribute("compList", list);
				forward("./admin_view/InstallList/installComp.jsp", request, response);
			}
			
		}
	}
	
	protected void forward(String url,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
