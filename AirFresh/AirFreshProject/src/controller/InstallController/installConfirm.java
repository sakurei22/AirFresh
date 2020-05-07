package controller.InstallController;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dto.InstallDto;
import Dto.ManagerMemberDto;
import singleton.singleton;

/**
 * Servlet implementation class installConfirm
 */
@WebServlet("/installConfirm")
public class installConfirm extends HttpServlet implements Serializable{

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
				//나의 as리스트 메인으로 연결 
				commandHome(request, response);
			}
			if(command.equals("detail")) {
				//detail
				commandDetail(request, response);
			}
			if(command.equals("comp")) {
				String seq = request.getParameter("ins");
				System.out.println("seq = " + seq);
				boolean isS = s.is.compInstall(Integer.parseInt(seq));
				System.out.println(isS);
				
				if(isS) {
					//설치완료일과 처리상태를 바꾸어주는 것이 성공했을때
					//order리뷰 생성
					InstallDto dto = s.is.getDetailDto(Integer.parseInt(seq));
					boolean pass = s.orsi.createOrderReview(dto.getMem_id(), dto.getPur_index(), dto.getIns_index());
					if(pass) {
						System.out.println("생성완료");
					}else {
						System.out.println("생성실패");
					}
				}
				
				String gson = new Gson().toJson(isS);
				response.getWriter().write(gson);
			}
			

		}
	}
	
	protected void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//위에서 로직처리후 url주소와  req(리턴값), resp(리턴)
		//돌아가는 함수
		RequestDispatcher dispatch = req.getRequestDispatcher(url);
		dispatch.forward(req, resp);	
	}
	
	
	protected void commandHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		singleton s = singleton.getInstance();
		ManagerMemberDto dto = (ManagerMemberDto)request.getSession().getAttribute("managerLogin");
		List<InstallDto> list = s.is.getNoCompMyList(dto.getMgr_index());
		
		request.setAttribute("confirmList", list);
		forward("./admin_view/InstallList/installConfirm.jsp", request, response);
	}
	
	protected void commandDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		singleton s = singleton.getInstance();
		String seq = request.getParameter("ins")==null?"" : request.getParameter("ins");
		System.out.println("detail seq = " + seq);
		InstallDto dto = s.is.getDetailDto(Integer.parseInt(seq));
		
		request.setAttribute("detailDto", dto);
		forward("/admin_view/InstallList/insDetail.jsp", request, response);
	}
	
}
