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
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/managerLogin")
public class ManagerLogin extends HttpServlet {
	private ManagerMemberDto check = null;
	
	private String mgr_id = null;
	private String mgr_pw = null;
	
	private HttpSession session = null;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" managerLogin service Now.");
		
		//chdckID_PW로 일단 체크한다. 
		//2. 결과를  전달하기위해서 commans를 통해서 메시지를 전달한다.
		//3. 처음 ID 와 PW를  확인후에  TRUE 를 전달한  뒤에는 check 를 통해서 session 을 다시 출력함. 
		
		check = (ManagerMemberDto) req.getSession().getAttribute("managerLogin");
		System.out.println(" !!!!!!!!!!!!!!!!check  를 확인합니다. " + check);
		
		if(req.getParameter("command").equals("checkID_PW")) {
			boolean isS = loginCheck(req, resp);
			System.out.println("\n 5/6 logincheck \n");
			
			if(isS != false && !check.getMgr_id().equals("")) {
				System.out.println("\nTRUE6/6 logincheck \n");
				req.getSession().setAttribute("managerLogin", check);
				System.out.println("로그인성공 관리자 리스트로 이동 ");
				resp.setContentType("application/text");
				resp.setCharacterEncoding("UTF-8");
				String respon = "true";
				
				//session저장한다.
				session = req.getSession();
				session.setAttribute("adminLogin", check);		

				//웹페이지로 전달한다. 
				resp.getWriter().write(respon);
				//forward("/adminmain", req, resp);
			}else {
				System.out.println("실패했습니다. 재접속 해주세요");
				resp.setContentType("application/text");
				resp.setCharacterEncoding("UTF-8");
				String respon = "./admin_view/manageMgr/login/adminlogin.jsp";
				resp.getWriter().write(respon);
				System.out.println("\nFALSE6/6 logincheck \n");
				forward("./admin_view/manageMgr/login/adminlogin.jsp", req, resp);
			}
			
			
				
		}else if(req.getParameter("command").equals("success")) {
				forward("./adminmain", req, resp);
				//resp.sendRedirect("주소");
			
		}else if(req.getParameter("command").equals("logout")) {
			session.removeAttribute("managerLogin"); 
			System.out.println("session logout");
			forward("./admin_view/manageMgr/login/adminlogin.jsp", req, resp);
			
			
			
			
		}else {
			System.out.println(" 다시  확인해봐라  잘못적었다  진짜 다시봐라 ");
		}
		

	}//end of doPost
	
	
//	protected ManagerMemberDto getIdFromPw(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String mgr_id = req.getParameter("manager_id");
//		String mgr_pw = req.getParameter("manager_pw");
//		ManagerMemberDto managememdto = new ManagerMemberDto();
//		
//		
//		
//		
//		return ;
//	}
	

	protected boolean loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		mgr_id = req.getParameter("manager_id");
		mgr_pw = req.getParameter("manager_pw");
		System.out.println("\n1/6 logincheck \n");
		System.out.println("mgrid = " + mgr_id + " \n mgr_pw = "+mgr_pw);
		
		ManagerMemberDto managermemdto = new ManagerMemberDto(mgr_id, mgr_pw);
		
		singleton si = singleton.getInstance();
		
		System.out.println("\n2/6 logincheck \n");
		
		check = si.managerMember.loginManagerMembercheck(managermemdto);
		System.out.print("check 내용 출력  ");
		System.out.println(check);
		
		if(check==null){
			//로그인실패
			System.out.println("\nFALSE 4/6 logincheck \n");
			System.out.println("아이디 확인에 실패했습니다. 다시확인해 주세요 ");
			return false;
		}else if( check.getMgr_id().equals(managermemdto.getMgr_id())) {
			//로그인 
			//req.getSession().setAttribute("managerLogin", check);
			
			System.out.println("\nTRUE 4/6 logincheck \n");
			System.out.println("아이디 확인 성공하였습니다. " + check + "]]]]");
		
			return true;
		}else {
			System.out.println("예외상황 발생 확인필요 ManagerLogin    loginCheck Method");
			return false;
		}
		
		

	}
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}
	
	
	
	

}//end of class
