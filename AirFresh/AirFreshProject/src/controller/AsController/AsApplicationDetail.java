package controller.AsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.AsAppDto;
import singleton.singleton;


@WebServlet("/asDetail")
public class AsApplicationDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("AsApplicatonDetail 도착");
		String seq = req.getParameter("seq");
		
		System.out.println("AsApplicatonDetail seq : "+seq);
		int as_index = Integer.parseInt(seq);
		
		singleton s = singleton.getInstance();
		AsAppDto dto = s.asi.getDetailAs(as_index);
		System.out.println("AsAppDto : "+dto.toString());
		
	
		
		
		
		String savePath = req.getServletContext().getRealPath("/asupload");
		if(dto.getAsImgPath()!= null){
			int idx = dto.getAsImgPath().lastIndexOf(".");
			String str = dto.getAsImgPath().substring(idx+1);	//확장자
			System.out.println("이미지 확장자: "+str);
		}
		//System.out.println("savePath: "+savePath);
		
		
		//////////////////////////////////////
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("./client_view/as/asDetail.jsp").forward(req, resp);
	}
}
