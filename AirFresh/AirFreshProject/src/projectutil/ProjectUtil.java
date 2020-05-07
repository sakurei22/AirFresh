package projectutil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectUtil {
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}
	
	public static void forward11(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}
		
	//근무지 숫자를 넣으면 그에 해당하는 주소로 변환해주는 함수
	public static String locationChange(int loc) {
		String[] sloc = {"error","강남구","성동구","중랑구","기타"};
		
		return sloc[loc];
	}
	
	//근무지 숫자를 넣으면 그에 해당하는 주소로 변환해주는 함수
	public static int locationChange(String loc) {
		String[] sloc = {"error","강남구","성동구","중랑구","기타"};
		
		for(int i = 0 ; i < sloc.length; i++) {
			if(loc.equals(sloc[i])) {
				return i;
			}
		}
		return -1;
	}//end of locationchange()
	
	
	
	
	//DB에서 받아온 Date타입의 String을 2020/02/13 형식으로 바꾸어 변환해주는 함수 
	public static String ChangeDate(String date) {
		date = date.replace("-", "/");
		date = date.substring(0, 10);	
		return date;
	}
	
	public static String managerStatus(int del) {
		return del>0?"퇴사":"재직중";
	}

	public static String managerLevel(int level) {
		String[] slevel= {"왕관리자", "부관리자", "매니저", "설치기사"};
		
		return slevel[level];
	}

	public static int managerLevel(String level) {
		String[] slevel= {"왕관리자", "부관리자", "매니저", "설치기사"};
		
		for(int i = 0 ; i < slevel.length; i++) {
			if(level.equals(slevel[i])) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static String outputdataValue(String data) {
		if(data==null) {
			return "-";
		}else {
			return data;
		}
		
	}//end 

	
	
	
}//end class 


