package controller.OrderRevController;

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

import Dto.ModelReviewPurDto;
import Dto.OrderReviewDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/upReview")
public class UpdateReview extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proc(req, resp);
	}

	public void proc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		System.out.println("upReview도착");
		singleton s = singleton.getInstance();
		
		//form field 저장할변수
		String sre_index="";
		String spur_index="";
		String prd_name="";
		String mem_id="";
		String title="";
		String content="";
		String srating="";
		String oldfile="";
		
		//파일업로드
		String filePath="";
		
		//파일업로드
		String fupload = this.getServletContext().getRealPath("/reviewupload");
		System.out.println("업로드 폴더: "+fupload);
		
		String yourTempDir = fupload;
		int yourMaxRequestSize = 100 * 1024 * 1024;	// 1 Mbyte
		int yourMaxMemorySize = 100 * 1024;			// 1 Kbyte 
		
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
						} else if (item.getFieldName().equals("rating")) {
							srating = item.getString("utf-8");
						} else if (item.getFieldName().equals("title")) {
							title = item.getString("utf-8");
						} else if (item.getFieldName().equals("content")) {
							content = item.getString("utf-8");
						} else if (item.getFieldName().equals("oldfile")) {
							oldfile = item.getString("utf-8");
						} else if (item.getFieldName().equals("re_index")) {
							sre_index = item.getString("utf-8");
						} else if (item.getFieldName().equals("pur_index")) {
							spur_index  = item.getString("utf-8");
						}
					}
					else{	// fileload
						if(item.getFieldName().equals("filePath")){
							if(item.getName() != null && !item.getName().equals("")) {
								filePath = processUploadFile(item, fupload);
							}	
						}
					}
					if(filePath == null || filePath.equals("")) {
						filePath = oldfile;
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("multipart가 아님");
		}
		
		System.out.println("------------------------------upReview title : "+title);
		System.out.println("------------------------------upReview content : "+content);
		System.out.println("------------------------------upReview oldfile : "+oldfile);
		System.out.println("------------------------------upReview filePath : "+filePath);
		System.out.println("------------------------------upReview rating : "+srating);
		System.out.println("------------------------------upReview re_index : "+sre_index);
		System.out.println("------------------------------upReview pur_index : "+spur_index);
		int re_index = Integer.parseInt(sre_index);
		int rating = Integer.parseInt(srating);
		int pur_index = Integer.parseInt(spur_index);
		
		ModelReviewPurDto dto = new ModelReviewPurDto(re_index, pur_index, mem_id, title, content, filePath, rating);
		System.out.println("수정dto: "+dto.toString());
		boolean isS = s.orsi.updateReview(re_index, dto);

		if(isS) {
			System.out.println("수정 성공");
			
			// 리뷰 작성후 finding으로 이동
			resp.sendRedirect(req.getContextPath() + "/client_view/review/finding.jsp?command=update&isS="+isS);
			
			/*
			 * List<ModelReviewPurDto> list = s.orsi.reviewAllList();
			 * System.out.println("listsize: "+list.size()); req.setAttribute("list", list);
			 * ProjectUtil.forward("/client_view/review/reviewList.jsp", req, resp);
			 */
			 
		} else {
			System.out.println("수정 실패");
		}
		
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
