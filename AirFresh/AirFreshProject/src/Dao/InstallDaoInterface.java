package Dao;

import java.util.List;
import Dto.InstallDto;

public interface InstallDaoInterface {

	//왕어드민에서 현재 배정이 안된  설치신청 리스트를 받아오는 메소드 
	public List<InstallDto> getNullInstallList();
	
	//특정 날짜의 배정이 안된 설치신청 리스트를 받아오는 메소드 
	public List<InstallDto> getNullInstallList(String date);
	
	//설치신청을 생성하는 함수
	public boolean addInstall(InstallDto dto);
	
	//설치기사가 장바구니에서 저장하기 버튼을 누르면 사용되는 메소드 
	public boolean insertMgrID(int ins_index, int mgr_index);
	
	//위에 함수중 1개라도 안되면 다시 되돌리는 메소드 
	public boolean insertNull(int ins_index, int mgr_index);
	
	//로그인한 직원의 근무지에 해당되고 & 선택한 특정날짜의 Null 설치 리스트를 가져오는 메소드  
	public List<InstallDto> getMgrPicDayList(String date, String loc);
	
	//강남구, 성동구, 중랑구를 제외한 나머지 지역들의 Null 설치 리스트를 가져오는 메소드 
	public List<InstallDto> getGitaNullList(String date);
	
	//완료가 안된 MyList
	public List<InstallDto> getNoCompMyList(int mgr_index);
	
	//완료가 된 MyList
	public List<InstallDto> getCompMyList(int mgr_index);
	
	//디테일 정보를 가져오는 메소드
	public InstallDto getDetailDto(int index);
	
	//설치기사가 완료처리를 하는 메소드
	public boolean compInstall(int index);
	
	//왕어드민에서 현재 완료된  설치신청 리스트를 받아오는 메소드 
	public List<InstallDto> getCompInstallList();
	
	//왕어드민에서 현재 대기중 설치신청 리스트를 받아오는 메소드 
	public List<InstallDto> getWaitInstallList();
	
	//main 5개
	public List<InstallDto> getMainInstallList();
	
}
