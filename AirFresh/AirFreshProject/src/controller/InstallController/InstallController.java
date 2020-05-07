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
import Service.InstallServiceInterface;
import Service.impl.InstallService;
import projectutil.ProjectUtil;
import singleton.singleton;

/**
 * Servlet implementation class getInstallList_Null
 */
@WebServlet("/InstallController")
public class InstallController extends HttpServlet implements Serializable{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processing(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processing(req, resp);
	}

	protected void processing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("InstallController 도착");
		singleton s = singleton.getInstance();

		//명령어 판단 
		String command = null;
		if(req.getParameter("command") != null) {
			command = req.getParameter("command");
			
			if(command.equals("install")) {
				resp.sendRedirect("./admin_view/InstallList/InstallList.jsp");
			}
			
			if(command.equals("installk")) {
				
				List<InstallDto> list = s.is.getWaitInstallList();
				List<InstallDto> comflist = s.is.getCompInstallList();
				
				req.setAttribute("installList", list);
				req.setAttribute("comfllList", comflist);
				ProjectUtil.forward("./admin_view/InstallList/installList_k.jsp", req, resp);
				
			}
			
			
			
			if(command.equals("getDayList")) {
				//선택한 날짜의 리스트를 가져오는 명령
				System.out.println("getDayList 도착");
				
				ManagerMemberDto mdto = (ManagerMemberDto)req.getSession().getAttribute("managerLogin");
				int level = mdto==null?-1:mdto.getMgr_auth();
				System.out.println(level);

				getDayList(level, req, resp);

			}			
			
			if(command.equals("save")) {
				//직원용 
				System.out.println("save 도착");
				ManagerMemberDto mdto = (ManagerMemberDto)req.getSession().getAttribute("managerLogin");
				installSave(mdto.getMgr_index(),req, resp);
			}
			
			if(command.equals("carlender")) {
				//달력 
				installCarlender(req, resp);
			}
			
			
			if(command.equals("savet")) {
				System.out.println("savet 도착");
				forward("./admin_view/main.jsp", req, resp);
			}
		}

	}
	
	protected void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//위에서 로직처리후 url주소와  req(리턴값), resp(리턴)
		//돌아가는 함수
		RequestDispatcher dispatch = req.getRequestDispatcher(url);
		dispatch.forward(req, resp);	
	}
	
	
	
	
	protected void getDayList(int level, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		singleton s = singleton.getInstance();
		String date = req.getParameter("date");
		List<InstallDto> list = null;
		System.out.println(date);
		
		ManagerMemberDto dto = req.getSession().getAttribute("managerLogin")==null? new ManagerMemberDto("-1", "-1"): (ManagerMemberDto)req.getSession().getAttribute("managerLogin");
		
		if(level > 0) {
			//왕관리자가 아닐 때
			String loc = ProjectUtil.locationChange(dto.getMgr_loc());
			list = s.is.getMgrPicDayList(date, loc);
		}else {
			//왕관리자 일 때
			list = s.is.getNullInstallList(date);
		}
		
		//리턴값 타입 json 으로 지정 
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		//list를 json형식의 string으로 변환
		String gson = new Gson().toJson(list);
		
		//System.out.println(gson);
		
		//변환한 json형식을 리턴 
		resp.getWriter().write(gson);
		
	}
	
	protected void installSave(int mgr_index,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("installSave 메소드 도착");
		//DB에 업데이트
		singleton s = singleton.getInstance();
		
		String[] insArr = req.getParameterValues("seqArr")==null?null:req.getParameterValues("seqArr");
		if(insArr != null) {
			int size = insArr.length;
			System.out.println("insArr 사이즈 = " + size);
		}
		/*
		for(int i = 0; i < size; i++) {
			System.out.println("insArr[" + i + "] = " + insArr[i]);
		}
		*/
		
		boolean isS = true;
		if(insArr != null && insArr.length > 0) {
			for(int i = 0; i < insArr.length; i++) {
				//System.out.println(insArr[i]);
				System.out.println("installDao 출발" + (i + 1));
				isS = s.is.insertMgrID(Integer.parseInt(insArr[i]), mgr_index);
				
				if(!isS) { break;} //업데이트 실패시 
			}
			
			if(isS) {
				//모든 update가 성공하면 true반환
				//리턴값 타입 json 으로 지정 
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				
				String gson = new Gson().toJson(isS);
				//변환한 json형식을 리턴 
				resp.getWriter().write(gson);
			}else {
				//하나라도 실패시 false 반환
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				
				String gson = new Gson().toJson(isS);
				//변환한 json형식을 리턴 
				resp.getWriter().write(gson);
			}
		}
		
	}
	
	
	
	protected void installCarlender(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String year = req.getParameter("year");
		String month = req.getParameter("month");
		System.out.println(year);
		System.out.println(month);
		
		req.setAttribute("year", year);
		req.setAttribute("month", month);
		
		forward("./admin_view/InstallList/InstallList.jsp", req, resp);
	}
	
	
	
}
