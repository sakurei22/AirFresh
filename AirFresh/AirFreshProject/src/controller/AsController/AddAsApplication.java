package controller.AsController;

import java.io.File;
import java.io.IOException;
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

import Dto.AsAppDto;
import singleton.singleton;

@WebServlet("/addAsApp")
public class AddAsApplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proccess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proccess(req, resp);
	}

	public void proccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		System.out.println("addAsApp 도착 ");
		
		//파일업로드
		String fupload = this.getServletContext().getRealPath("/asupload");
		System.out.println("업로드 폴더: "+fupload);
		
		String yourTempDir = fupload;
		int yourMaxRequestSize = 100 * 1024 * 1024;	// 1 Mbyte
		int yourMaxMemorySize = 100 * 1024;			// 1 Kbyte 
		
		//form field 데이터를 저장하는 변수
		String spur_index="";
		String mem_id="";
		String prd_name="";
		String req_date="";
		String astitle="";
		String ascontent="";
		
		//업로드된 이미지
		String filename ="";
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(isMultipart==true) {
			// FileItem 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			factory.setSizeThreshold(yourMaxMemorySize);
			factory.setRepository(new File(yourTempDir));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(yourMaxRequestSize);
			
			// list 저장 -> id, title, content, prd_index, prd_name, file
			try {
				List<FileItem> items = upload.parseRequest(req);
				Iterator<FileItem> it = items.iterator();
				
				// 구분
				while(it.hasNext()){
					FileItem item = it.next();
					
					if(item.isFormField()){	// pur_index, mem_id, astitle, ascontent, req_date, prd_name, 
						if(item.getFieldName().equals("pur_index")){
							spur_index = item.getString("utf-8");
						} else if(item.getFieldName().equals("mem_id")){
							mem_id = item.getString("utf-8");
						} else if(item.getFieldName().equals("prd_name")){
							prd_name = item.getString("utf-8");
						} else if (item.getFieldName().equals("req_date")) {
							req_date = item.getString("utf-8");
						} else if (item.getFieldName().equals("astitle")) {
							astitle = item.getString("utf-8");
						} else if (item.getFieldName().equals("ascontent")) {
							ascontent = item.getString("utf-8");
						}
					}
					else{	// fileload
						if(item.getFieldName().equals("fileload")){
							filename = processUploadFile(item, fupload);
						}
					}		
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("multipart가 아님");
		}
		
		int pur_index = Integer.parseInt(spur_index);
		
		singleton s = singleton.getInstance();
		AsAppDto dto = new AsAppDto(mem_id, req_date, astitle, ascontent, filename, pur_index, prd_name);
		
		boolean isS = s.asi.addAsApplictaion(dto);

		if(isS) {
			System.out.println("파일업로드성공");
			List<AsAppDto> list = s.asi.memAsAppList(mem_id);
			System.out.println("list size: "+list.size());
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("./client_view/as/asapplist.jsp").forward(req, resp);
		}else {
			System.out.println("파일업로드실패");
		}
		
		//req.setAttribute("dto", dto);
		//resp.sendRedirect("./client_view/as/asappcomplete.jsp?command="+isS);
		
	}
	
	public String processUploadFile(FileItem fileItem, String dir) throws IOException{

		String filename = fileItem.getName();	// 경로(서버, 클라이언트) + 파일명
		long sizeInBytes = fileItem.getSize();
		
		// 파일이 정상
		if(sizeInBytes > 0){ //   d:\\tmp\\abc.txt  d:/tmp/abc.txt 
			
			int idx = filename.lastIndexOf("\\");
			if(idx == -1){
				idx = filename.lastIndexOf("/");
			}
			
			filename = filename.substring(idx + 1); // abc.txt		
			File uploadFile = new File(dir, filename);
			
			try{
				fileItem.write(uploadFile);	// 실제 upload부분
			}catch(Exception e){}		
		}	
		return filename;	// 확인용	
	}
}
