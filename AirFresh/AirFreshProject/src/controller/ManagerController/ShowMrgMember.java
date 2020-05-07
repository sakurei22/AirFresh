package controller.ManagerController;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ManagerMemberDto;
import singleton.singleton;

@WebServlet("/showMrgMember")
public class ShowMrgMember extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello ShowMrgMember doGet do get ");
		
		req.setCharacterEncoding("UTF-8");
		receiveManagerMember(req, resp);//DB에서 전체 리스트를 받아오는것.

	}//end of doGet

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("hello ShowMrgMember doPost do get ");
//		receiveManagerMember(req, resp);//DB에서 전체 리스트를 받아오는것. 
//	}//end of doPost


	public void receiveManagerMember(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		singleton si = singleton.getInstance();
		List<ManagerMemberDto> listmanagermemberlist = si.managerMember.receiveManagerMemberAll();
		System.out.println(listmanagermemberlist);
		
		req.setAttribute("managerMemberList", listmanagermemberlist);

		
		for (ManagerMemberDto managerMemberDto : listmanagermemberlist) {
			System.out.println(managerMemberDto);
		}
		System.out.println("리스트찍기 ");
		forward("./admin_view/manageMgr/showManagerAll.jsp", req, resp);
		
	}//end of receiveManagerMember
	
	public void forward(String link, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);
			
	}//end forward method

	
}//end of class

