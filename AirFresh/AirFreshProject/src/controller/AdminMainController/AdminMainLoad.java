package controller.AdminMainController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.InstallDto;
import Dto.ManagerMemberDto;
import Dto.NoticeBbsDto;
import Dto.PurchaseNameDto;
import projectutil.ProjectUtil;
import singleton.singleton;
@WebServlet("/adminmain")
public class AdminMainLoad extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {

		singleton s = singleton.getInstance();
		HttpSession session = req.getSession();
		ManagerMemberDto mgr = (ManagerMemberDto)session.getAttribute("managerLogin");
		if(mgr.getMgr_auth()==0 || mgr.getMgr_auth()==1) {
			List<NoticeBbsDto> list = s.nbsi.getNoticeList();
			List<PurchaseNameDto> plist = s.ps.getMainPurchaseList();
			List<InstallDto> ilist = s.is.getMainInstallList();
			req.setAttribute("mainList", list);
			req.setAttribute("mainPList", plist);
			req.setAttribute("mainIList", ilist);
			ProjectUtil.forward("./admin_view/main.jsp", req, resp);
			
		} else if(mgr.getMgr_auth()==3){
			List<NoticeBbsDto> list = s.nbsi.getNoticeList();
			List<PurchaseNameDto> plist = s.ps.getMainPurchaseList();
			req.setAttribute("mainList", list);
			req.setAttribute("mainPList", plist);
			
			ProjectUtil.forward("./admin_view/mgrMain.jsp", req, resp);
		}
	}
}
