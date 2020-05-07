package Dao;

import java.util.List;

import Dto.AsAppDto;

public interface AsDaoInterface {	
	//as신청
	boolean addAsApplictaion(AsAppDto dto);

	//as전체 list
	List<AsAppDto> getAsAll();
	
	//멤버별 as신청 list
	List<AsAppDto> memAsAppList(String mem_id);
	
	//as상세
	AsAppDto getDetailAs(int as_index);
	
	//as신청수정
	boolean updateAsApp(int as_index,AsAppDto dto);
	
	//as신청취소
	boolean deleteAsApp(int as_index);

}
