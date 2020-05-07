package controller.AsController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.InstallDto;
import Dto.PurchaseDto;
import singleton.singleton;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	
	protected void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("testServlet 도착");
		String scommand = request.getParameter("command");
		
		singleton s = singleton.getInstance();
		
		if(scommand.equals("test")) {
			//pur 생성 성공시 
			PurchaseDto purDto = s.ps.getNewCreate_Pur();
			System.out.println(purDto.getPur_index() + "   || " + purDto.getIns_date());
			
			InstallDto insDto = new InstallDto(purDto.getPur_index(), purDto.getIns_date());
			
			boolean isS = s.is.addInstall(insDto);
			if(isS) {
				System.out.println("install 생성 성공");
			}else {
				System.out.println("install 생성 실패");
			}
		}
	}
}
