package controller.PurchaseController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.PurchaseNameDto;
import Dto.RentalDetailDto;
import singleton.singleton;

@WebServlet("/detailPur")
public class DetailPurchase extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String seq = req.getParameter("seq");	
		System.out.println("DetailPurchase 도착 seq: "+seq);
		
		
		int pur_index = Integer.parseInt(seq);
		String command = req.getParameter("command");
		
		singleton s = singleton.getInstance();
		if(command.contentEquals("user")) {
			RentalDetailDto dto = s.ps.getDetailDto(pur_index);
			System.out.println("선택 된 seq의 dto: "+dto.toString());
			
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("./client_view/rental/detailPurchase.jsp").forward(req, resp);
		} else if(command.contentEquals("admin")) {
			RentalDetailDto dto = s.ps.getDetailDto(pur_index);
			System.out.println("선택 된 seq의 dto: "+dto.toString());
			
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("./admin_view/rental/rentaldetail.jsp").forward(req, resp);
		}
	}

}
