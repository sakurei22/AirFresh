package Dao;

import java.util.List;

import Dto.MemberDto;

public interface MemberDaoInterface {
	
	public boolean idCheck(String mem_id);
	
	public boolean addMem(MemberDto dto);
	
	public MemberDto memLogin(String mem_id, String mem_pw);

	public boolean updateMem(String mem_id, MemberDto dto);
	
	public boolean delMem(String mem_id, String mem_pw);
	
	public String findID(String mem_name, String mem_cell);
	
	public String findPW(String mem_id, String mem_name);
	
	public MemberDto getMem(String id);
	
	public List<MemberDto> getMemberList(String opt, String keyword, int page);
	
	public List<MemberDto> getAdminMemList(int pageNumber);

	public int getMemLength();

}
