package controller.ManagerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.ManagerMemberDto;
import singleton.singleton;

@WebServlet("/modifyMgrMember")
public class ModifyMgrMember extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("modifymgrmember in the service now!! ");
		String command = req.getParameter("command");
		System.out.println("command  = " +  command);
/*		command list  submit 회원정보를 수정한다.  */
		//들어온 파라미터를 수집하여 dto 에 넣는다.  
		
		
		
		if(command.equals("submit")) {
			ManagerMemberDto managermemdto = collectParameterToDto(req, resp);
			System.out.println("콜랙터 파라미터 이후 " +managermemdto);
/*
			1. dao 에서 데이더 업데이트가 이루어지고 난 뒤에 true가 들어오면 ajax 에서 true를 전다. 
			2. ajax 에서는 true 신호를 받아서 CONTROLLER로 comment=updatesuccess 를 보내서 상세정보 페이지로 이동한다.
					(mgrMemberDetail.jsp와 mgrindex를 같이 전달한다.)
			3. 
*/
			//singleton 통해서 update 시작.
			singleton si = singleton.getInstance();
			
			boolean isS = si.managerMember.managerMemberUpdate(managermemdto);
			System.out.println(" 업데이트 결과 : " + isS);
			if(isS == true) {
				resp.getWriter().write("true");
			}else {
				resp.getWriter().write("false");
			}
			
			
			
			//end command
		}else if(command.equals("success")) {
			System.out.println("success 진입함. "  );

		}else if(command.equals("ModifyProfile")) {
			singleton si = singleton.getInstance();
			HttpSession session = req.getSession();

			 ManagerMemberDto managerMemberSession = 
					 		(ManagerMemberDto) session.getAttribute("adminLogin");
//			 System.out.println("메니저 맴버 :::: managerMemberSession = " + managerMemberSession);
			String index = Integer.toString(managerMemberSession.getMgr_index());
			
			req.setAttribute("receiveFromIndex", si.managerMember.receiveManagerMemberSelect(index)); 
			
			forward("./admin_view/manageMgr/managerProfileChange.jsp", req, resp);
		}
		
		
		


	}//end of service 
	
	
	protected ManagerMemberDto collectParameterToDto(HttpServletRequest req, HttpServletResponse resp) {
		String mgr_index_s	=	req.getParameter("mgr_index");
		int mgr_index 		= 	Integer.parseInt(mgr_index_s);
		
		String mgr_auth_s	=	req.getParameter("mgr_auth");
		int mgr_auth		= 	Integer.parseInt(mgr_auth_s);
		
		String mgr_id		=	req.getParameter("mgr_id");
		String mgr_pw		=	req.getParameter("mgr_pw");
		String mgr_name		=	req.getParameter("mgr_name");
		String mgr_loc_s	=	req.getParameter("mgr_loc");
		int mgr_loc 		= 	Integer.parseInt(mgr_loc_s);
		
		String mgr_cell		=	req.getParameter("mgr_cell");
		String mgr_delDate	=	null;
//		String mgr_delDate	=	req.getParameter("mgr_delDate");
		
		String mgr_del_s	=	req.getParameter("mgr_del");
		int mgr_del			= 	Integer.parseInt(mgr_del_s);
		
		singleton si = singleton.getInstance();
		/*데이터 조건처리
		1. 재직중에서 퇴사상태로 전환시 0->1 날짜를 직접 입력하도록한다.(SYSDATE)
		2. 퇴직상태에서 재직중으로 변경시 1-> 0 일경우  "-" 으로 문자열을 입력해준다. */
		
		//조건1 //mgr_del의 이전과 이후를 비교하기 위해서 정보를 가져온다.
		ManagerMemberDto beforedto = si.managerMember.receiveManagerMemberSelect(mgr_index_s);
		ManagerMemberDto managerMemDto = new ManagerMemberDto();
		
		
		if(mgr_del == beforedto.getMgr_del()) {
			System.out.println("변동없음.");
		}else if(mgr_del > beforedto.getMgr_del()) {
			//기존:변화 0->1 일때  mgr_delDate에  getMgr_delDate에 날짜가 입력 되어야함.
			mgr_delDate="SYSDATE";
		}else if(mgr_del < beforedto.getMgr_del()) {
			//기존:변화 1->0 일때  mgr_delDate "_"로 입력되어야함.
			mgr_delDate=null;
		}
		
		
		
		
		if(mgr_pw == null) {
			managerMemDto.setMgr_pw(beforedto.getMgr_pw());
		}else {
			managerMemDto.setMgr_pw(mgr_pw);
		}
		managerMemDto.setMgr_index(mgr_index);
		managerMemDto.setMgr_auth(mgr_auth);
		managerMemDto.setMgr_id(mgr_id);
		managerMemDto.setMgr_name(mgr_name);
		managerMemDto.setMgr_loc(mgr_loc);
		managerMemDto.setMgr_cell(mgr_cell);
		managerMemDto.setMgr_delDate(mgr_delDate);
		managerMemDto.setMgr_del(mgr_del);
		
		System.out.println("최종 managerMemDto 결과 ::::::: \n" + managerMemDto);
		
		
		return managerMemDto;
	
	}//end of collectParameter
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}

	
	

}	//end of class
