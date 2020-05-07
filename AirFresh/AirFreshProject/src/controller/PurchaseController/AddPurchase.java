package controller.PurchaseController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JSeparator;

import Dto.InstallDto;
import Dto.MemberDto;
import Dto.ModelDto;
import Dto.PurchaseDto;
import Dto.PurchaseNameDto;
import Dto.RentalDetailDto;
import singleton.singleton;

@WebServlet("/addPurchase")
public class AddPurchase  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proccess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proccess(req, resp);
	}

	public void proccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String ins_date = req.getParameter("ins_date");
		//System.out.println("희망설치일: "+ins_date);
		
		HttpSession session = req.getSession();
		MemberDto mem = (MemberDto) session.getAttribute("login");
		ModelDto model = (ModelDto) session.getAttribute("model");
		
		
		System.out.println("id : " + mem.getMem_id());
		System.out.println("제품idx : "+model.getPrd_index());
		System.out.println("설치희망일: "+ ins_date);
		
		
		singleton s = singleton.getInstance();
		
		boolean command = s.ps.purchaseInsert(mem.getMem_id(), model.getPrd_index(), ins_date);
		
		//Install 생성 부분
		if(command) {
			//pur 생성 성공시 
			PurchaseDto purDto = s.ps.getNewCreate_Pur();
			//System.out.println(purDto.getPur_index() + "   || " + purDto.getIns_date());
			
			InstallDto insDto = new InstallDto(purDto.getPur_index(), purDto.getIns_date());
			
			boolean isS = s.is.addInstall(insDto);
			if(isS) {
				System.out.println("install 생성 성공");
			}else {
				System.out.println("install 생성 실패");
			}
			
			//결제 후 상세내역 dto
			//PurchaseDto dto = s.ps.getPurchaseOne(purDto.getPur_index());
			//PurchaseNameDto dto = s.ps.getPurchaseOne(purDto.getPur_index());
			RentalDetailDto dto = s.ps.getDetailDto(purDto.getPur_index());
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("./client_view/rental/purcomplete.jsp?command="+command).forward(req, resp);
			
			
		}
	
	}
	
	
}
