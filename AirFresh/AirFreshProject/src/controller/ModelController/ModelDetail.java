package controller.ModelController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ModelDto;
import Dto.ModelReviewPurDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/modelDetail")
public class ModelDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("modelDetail 도착");
		String command = req.getParameter("command");

		String seq = req.getParameter("seq");
		System.out.println("seq: " + seq);
		int prd_index = Integer.parseInt(seq);

		singleton s = singleton.getInstance();
		ModelDto model = s.msi.getModelDetail(prd_index);
		// System.out.println(model.toString());
		req.setAttribute("model", model);

		if (command.equals("detail")) {
			// 전체목록-> 상세페이지로 넘어갈때
			List<ModelReviewPurDto> list = s.orsi.getPrdReviewList(prd_index);
			System.out.println("listsize: "+list.size());
			req.setAttribute("list", list);
			req.getRequestDispatcher("./client_view/rental/rentalDetail.jsp").forward(req, resp);

		} else if (command.equals("purcha")) {

			if (req.getSession().getAttribute("login") == null) {
				// 비로그인 상태 ---> 로그인 페이지로 이동
				resp.sendRedirect(req.getContextPath() + "/client_view/member/login.jsp");
			} else {

				req.getRequestDispatcher("./client_view/rental/purchase.jsp").forward(req, resp);
			}
		}

	}// end process

}
