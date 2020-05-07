package controller.NoticeBbsController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.NoticeBbsDto;
import singleton.singleton;

@WebServlet("/filedown")
public class NoticeFileDown extends HttpServlet {
	
	ServletConfig mConfig = null;
	static final int BUFFER_SIZE = 8192;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		mConfig = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int noti_index = Integer.parseInt(req.getParameter("noti_index"));
		singleton s = singleton.getInstance();
		NoticeBbsDto notice = s.nbsi.getNoticeBbs(noti_index);
		
		String filename = notice.getFilename();
		String tempfile = notice.getTempfile();
		
		//down load 증가(db)
				BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
				
				String filePath = "";
				
				//tomcat (Server)
				filePath = mConfig.getServletContext().getRealPath("/upload");
				
				//폴더 (Client)
				//filePath = "d:\\tmp";
				String str = filename.substring(filename.lastIndexOf("."));
				filePath = filePath + "\\" +tempfile + str;
			
				System.out.println("다운로드" + filePath);
				
				File f = new File(filePath);
				
				if(f.exists() && f.canRead()) {
					resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
					resp.setHeader("Content-Transfer-Encoding", "binary;");
					resp.setHeader("Content-Length", "" + f.length());
					resp.setHeader("Pragma", "no-cache;"); 
					resp.setHeader("Expires", "-1;");
					
					//파일을 생성, 기입
					BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
					byte buffer[] = new byte[BUFFER_SIZE];
					
					int read = 0;
					while((read = fileInput.read(buffer)) != -1) {
						out.write(buffer, 0, read); // 실제 다운로드 
					}
					
					fileInput.close();
					out.flush();
				}
	}

}
