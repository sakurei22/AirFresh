 package controller.NoticeBbsController;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



import Dto.NoticeBbsDto;
import singleton.singleton;

@WebServlet("/noticeupload")
public class AddNotice extends HttpServlet {

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
		String command = req.getParameter("command");

		if (command.equals("add")) {
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/notice_write.jsp");
		} else if (command.equals("upload")) {
			// tomcat배포(server)
			String fupload = getServletContext().getRealPath("upload");
			System.out.println("업로드 폴더 : " + fupload);
			String yourTempDir = fupload;
			int yourMaxRequestSize = 100 * 1024 * 1024; // 1mbyte
			int yourMaxMemorySize = 100 * 1024; // 1kbyte

			// form field의 데이터

			int noti_catagory = 0;
			String noti_title = "";
			String noti_content = "";

			// file name

			String filename = "";
			String fname ="";

			boolean isMultipart = ServletFileUpload.isMultipartContent(req);

			if (isMultipart == true) {

				// FileItem 생성
				DiskFileItemFactory factory = new DiskFileItemFactory();

				factory.setSizeThreshold(yourMaxMemorySize);
				factory.setRepository(new File(yourTempDir));

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(yourMaxRequestSize); // 순간 전송 크기

				// list 저장
				List<FileItem> items;
				try {
					items = upload.parseRequest(req);
					Iterator<FileItem> it = items.iterator();
					// 구분
					while (it.hasNext()) {
						FileItem item = it.next();
						if (item.isFormField()) { // catagory, title, content
							if (item.getFieldName().equals("catagory")) {
								noti_catagory = Integer.parseInt(item.getString("utf-8"));
							} else if (item.getFieldName().equals("title")) {
								noti_title = item.getString("utf-8");
							} else if (item.getFieldName().equals("content")) {
								noti_content = item.getString("utf-8");
							}
							
						} else {
							if (item.getFieldName().equals("fileload")) {
								
								// 시간을 취득
								fname = (new Date().getTime()) + "";

								// old			 new 	
								// mydata.txt -> 1580695728906.txt -> upload
								// 1580695728906.txt -> download -> mydata.txt
								
								filename = processUploadFile(item, fupload, fname);
							}
						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("멀티파트가 아닙니다");
			}
			singleton s = singleton.getInstance();
			boolean isS = s.nbsi.writeNotice(new NoticeBbsDto(noti_title, noti_content, noti_catagory, filename, fname));
			
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/finding.jsp?command=upload&isS="+isS);
		}

	}

	private String processUploadFile(FileItem fileItem, String dir, String fname) {
		String filename = fileItem.getName();
    	long sizeInBytes = fileItem.getSize();
    	
    	//파일이 정상
    	
    	if(sizeInBytes > 0){ // d:\\tmp\\abc.txt   d:/tmp/abc.txt
    		
    		int idx = filename.lastIndexOf("\\");
    		if(idx == -1){
    			idx = filename.lastIndexOf("/");
    		}
    		
    		filename = filename.substring(idx+1); // abc.txt
    		System.out.println(filename);
    		
    		String str = filename.substring(filename.lastIndexOf("."));
    		System.out.println(str);
    		File uploadFile = new File(dir, fname+str);
    		
    		try{
    		fileItem.write(uploadFile); //실제 업로드 부분 

    		}catch(Exception e){
    			
    		}
    	}
    	return filename;
	}
}
