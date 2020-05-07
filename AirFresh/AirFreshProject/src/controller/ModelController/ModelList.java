package controller.ModelController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ModelDto;
import projectutil.ProjectUtil;
import singleton.singleton;
@WebServlet("/modelist")
public class ModelList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ModelList");

		singleton s = singleton.getInstance();
		//페이징
		String snowPage = req.getParameter("nowPage");
		System.out.println("nowPage: "+snowPage);
		int nowPage = 0;
		if(snowPage != null && !snowPage.equals("")){
			nowPage = Integer.parseInt(snowPage);
		}
		
		//총 상품갯수
		int totalPrd = s.msi.getAllPrd();
		System.out.println("총 상품갯수: "+totalPrd);
		
		//총 페이지갯수
		int totalPage = totalPrd / 6;
		if(totalPrd % 6 > 0) {
			totalPage += 1;
		}
		
		
		
		//List<ModelDto> list = s.msi.getModelList();
		List<ModelDto> list = s.msi.getModelPagingList(nowPage);
		System.out.println("listsize: "+list.size());
		
		req.setAttribute("modelList", list);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		ProjectUtil.forward("./client_view/model/modellist.jsp", req, resp);
	}
	
}
