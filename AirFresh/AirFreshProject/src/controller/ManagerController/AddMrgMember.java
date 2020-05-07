package controller.ManagerController;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ManagerMemberDto;
import singleton.singleton;

@WebServlet("/addMrgMember")
			  
public class AddMrgMember extends HttpServlet {
	

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); 
		
		String status=req.getParameter("status");
		System.out.println("status값 출력 = " + status);
		System.out.println("hello AddMrgMember doPost do get ");
		
		
		if(status == null){
			receiveManagerAll(req, resp);
		}else if(status.equals("enter")) {
			System.out.println("page redirect to add member " );
			forward("/admin_view/manageMgr/addManager.jsp", req, resp);
		} else {
			System.out.println("AddMrgMember 오류. 로직 확인해주세요 ");
		}
		

	}//end of receiveManagerMember
	
	public void receiveManagerAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String mgr_id= req.getParameter("manager_id");
		String mgr_pw= req.getParameter("manager_pw");
		String mgr_name= req.getParameter("manager_name");
		
		String Str_mgr_loc= req.getParameter("manager_loc");	// 1 : 강남구 2: 성동구 3: 중랑구
		int mgr_loc = Integer.parseInt(Str_mgr_loc);
		String Str_mgr_auth = req.getParameter("authLevel");
		int mgr_auth = Integer.parseInt(Str_mgr_auth);
		
		String mgr_cell= req.getParameter("manager_phNum");
		String mgr_joinDate =  "SYSDATE";
		
		System.out.println("test1 = " + mgr_id + " " +
				" " +mgr_pw+
				" " +mgr_name+
				" " +mgr_loc+
				" " +mgr_cell+
				" " + mgr_joinDate);
		int mgr_index = 0;
		int mgr_del = 0;  
		
		ManagerMemberDto managermem =
				new ManagerMemberDto(mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joinDate);
		System.out.println(managermem);
		singleton si = singleton.getInstance();
		boolean res = si.managerMember.insertManagerMember(managermem);
		System.out.println("AddMrgMember insert result  =  " + res );
		if(res==true) {
//			forward("admin_view/manageMgr/showManagerAll.jsp", req, resp);
			resp.setContentType("text/html;charset=utf-8"); 
			forward("showMrgMember", req, resp);
		} else {
			System.out.println("insert 실패함. ");
		}
		
		
		
	}//end of service 
	
	public void forward(String link, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
//		dispatch.include(req, resp);
		dispatch.forward(req, resp);
			
	}//end forward method
	
	
}
