package controller.AsController;

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

@WebServlet("/asFileDown")
public class AsFileDownLoader extends HttpServlet {
	ServletConfig mConfig = null;
	static final int BUFFER_SIZE = 8192;	// 8 kbyte
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 업로드 폴더 경로를 취득하기 위해서 Config에 접근
		super.init(config);
		mConfig = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String filename = req.getParameter("filename");
		String sseq = req.getParameter("seq");
		
		System.out.println("filedownloader 도착 filename: "+filename+", seq: "+sseq);
		
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
		
		String filePath = "";
		filePath = mConfig.getServletContext().getRealPath("/asupload");
		
		filePath = filePath + "\\" + filename;
		System.out.println("다운로드:" + filePath);

		File f = new File(filePath);
		
		if(f.exists() && f.canRead()) {
		//	System.out.println("파일이 맞고 있습니다");
			
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
			resp.setHeader("Content-Transfer-Encoding", "binary;");
			resp.setHeader("Content-Length", "" + f.length());
			resp.setHeader("Pragma", "no-cache;"); 
			resp.setHeader("Expires", "-1;");
			
			// 파일을 생성, 기입
			BufferedInputStream fileInput = new BufferedInputStream(
												new FileInputStream(f));
			byte buffer[] = new byte[BUFFER_SIZE];
			
			int read = 0;
			while( (read = fileInput.read(buffer) ) != -1) {
				out.write(buffer, 0, read);		// 실제 다운로드				
			}
			fileInput.close();
			out.flush();
		}		
	}
}
