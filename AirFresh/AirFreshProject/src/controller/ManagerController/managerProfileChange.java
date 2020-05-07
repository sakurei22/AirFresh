package controller.ManagerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ManagerMemberDto;
import Utill.Jutill;
import singleton.singleton;

@WebServlet("/managerProfileChange")
public class managerProfileChange extends HttpServlet {
	private ManagerMemberDto receiveManagerDTO = null;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String commend = req.getParameter("ManageProfileCommnd");
		System.out.println("23라인//v프로파일 진입함. ");
		
		
		
		
		
		if(commend.equals("main")) {
			System.out.println("main");
			
			forward("./admin_view/main.jsp", req, resp);
			
		}else if(commend.equals("modify")) {
			receiveManagerDTO = dtoFromParameter(req, resp);			
			System.out.println("36라인  //수집된 파라미터 DTO 에 들어갔나 본다. " + receiveManagerDTO );	
			System.out.println("modify");
			//값이 넘어오면 저장한다.Setting parameter and input ot the managermemberdto 
			
			singleton si = singleton.getInstance();
			
			boolean result11 = si.managerMember.managerMemberUpdate(receiveManagerDTO);			
			System.out.println("44라인  result 11의 정보  :ㅣ !!!!! " + result11 ); 
			
			if(result11 == true ) {
				resp.getWriter().write("true");
			}else {
				resp.getWriter().write("false");
			}
			
			
			
		}else if(commend.equals("redirectMainPage")) {
			System.out.println("redirect to mainpage");
			
			
		} else {
			System.out.println("알수 없는 값이 들어왔습니다. 다시 시도해 주세요 ");

		}

		
		
		
	}	//end of service 
	
	private ManagerMemberDto dtoFromParameter(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("70라인");
		String mgr_index_s = req.getParameter("mgr_index");
		int mgr_index = Integer.parseInt(mgr_index_s);
		String mgr_pw = req.getParameter("mgr_pw");
		String mgr_name = req.getParameter("mgr_name");
		String mgr_cell = req.getParameter("mgr_cell");
		
		//입력된 내용 출력하기
		
		System.out.println("78라인 ind=" + 
				 mgr_index +" pw="+ 
				 mgr_pw +" name="+
				 mgr_name +" cell="+  
				 mgr_cell +" " );
		
		ManagerMemberDto dto = new ManagerMemberDto();
		dto.setMgr_index(mgr_index);
		dto.setMgr_pw(mgr_pw);
		dto.setMgr_name(mgr_name);
		dto.setMgr_cell(mgr_cell);
		
		
		System.out.println("dtoFromParameter 에서 수집된 >DTO 값 :: " + dto);
		
		return dto;
	}

	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}//end of forward()


}// end of class managerProfileChange()
