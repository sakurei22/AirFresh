package controller.ManagerController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ManagerMemberDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/showMgrMemberDetail")
public class showMgrMemberDetail extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("detail do post ");
		String status = req.getParameter("status");
		System.out.println("!!!!!!status = " + status );
		singleton si = singleton.getInstance();
		
		if(status==null) {
			String receiveIndexNo = req.getParameter("mgr_index");
			ManagerMemberDto managerdto = si.managerMember.receiveManagerMemberSelect(receiveIndexNo);
			System.out.println(managerdto);
			System.out.println("managerInfoSelectOne mgr_index receiveIndexNo = "+receiveIndexNo );
			
			req.setAttribute("managerInfoSelectOne", managerdto);
			forward("admin_view/manageMgr/showMgrMemberDetail.jsp", req, resp);
			
			
		}else if(status.equals("delete")) {
			System.out.println("삭제 에 진입.");
			String S_index = req.getParameter("index");
			int index=Integer.parseInt(S_index);
			
			System.out.println("delete index = "+index);
			boolean check = si.managerMember.setSelectedIndexChange(index);
			
			System.out.println("check 상태 입력 " + check);
			
			forward("admin_view/manageMgr/ManagerCURD/deleteManager.jsp", req, resp);
		}else if(status.equals("modify")) {
			System.out.println("수정에 진입. ");
			String index = req.getParameter("index");
			System.out.println("modify index   = "+index);
			

			forward("admin_view/manageMgr/ManagerCURD/modifyManager.jsp", req, resp);
		}
		
		
		

		
		
	}// end of service class
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}

	

}//end of class
