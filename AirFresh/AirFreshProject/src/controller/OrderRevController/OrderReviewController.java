package controller.OrderRevController;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dto.InstallDto;
import Dto.ManagerMemberDto;
import Dto.OrderReviewDto;
import Dto.PurchaseNameDto;
import Dto.RentalDetailDto;
import oracle.net.aso.i;
import projectutil.ProjectUtil;
import singleton.singleton;

/**
 * Servlet implementation class OrderReviewController
 */
@WebServlet("/OrderReviewController")
public class OrderReviewController extends HttpServlet {
	
	
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
			
			
			if(command.equals("update")) {
				//작성페이지로 이동 
				String purIndex = request.getParameter("pur")==null?"":request.getParameter("pur");
				System.out.println("purIndex = " + purIndex);
				int pur_index = Integer.parseInt(purIndex);
				RentalDetailDto dto = s.ps.getDetailDto(pur_index);
				System.out.println("넘어온 dto : "+dto.toString());
				
				request.setAttribute("dto", dto);
				ProjectUtil.forward("/client_view/review/install/writeOrderReview.jsp", request, response);
			}
				
			if(command.equals("write")) {
				//폼으로 데이터를 가져와서 처리하는 부분 
				/*
				 * String title = request.getParameter("title"); String rating =
				 * request.getParameter("rating"); String content =
				 * request.getParameter("content"); String filePath =
				 * request.getParameter("filePath"); String pur_index =
				 * request.getParameter("pur_index"); String prd_name =
				 * request.getParameter("prd_name");
				 */
				//여기서 pur_index까지 가지고 가서 
				//WHERE 조건에 pur_index = 가져간 index값으로 찾으면 된다 
				//System.out.println(prd_name+"//"+ title + "  // " + rating + "  //  " + content + "  //  " + filePath);
				
			
			}
		}
	}

	
}
