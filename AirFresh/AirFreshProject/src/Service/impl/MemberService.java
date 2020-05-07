package Service.impl;

import java.util.List;

import Dao.MemberDaoInterface;
import Dao.impl.MemberDao;
import Dto.MemberDto;
import Service.MemberServiceInterface;

public class MemberService implements MemberServiceInterface{
	 
		MemberDaoInterface dao = new MemberDao();
//		MemberDao dao = new MemberDao();
		
		@Override
		public boolean idCheck(String mem_id) {			
			return dao.idCheck(mem_id);
		}
		
		@Override
		public boolean addMem(MemberDto dto) {			
			return dao.addMem(dto);
		}

		@Override
		public MemberDto memLogin(String mem_id, String mem_pw) {			
			return dao.memLogin(mem_id, mem_pw);
		}

		@Override
		public boolean delMem(String mem_id, String mem_pw) {
			return dao.delMem(mem_id, mem_pw);
		}

		@Override
		public boolean updateMem(String mem_id, MemberDto dto) {			
			return dao.updateMem(mem_id, dto);
		}

		@Override
		public String findID(String mem_name, String mem_cell) {			
			return dao.findID(mem_name, mem_cell);
		}

		@Override
		public String findPW(String mem_id, String mem_name) {			
			return dao.findPW(mem_id, mem_name);
		}

		@Override
		public MemberDto getMem(String id) {			
			return dao.getMem(id);
		}

		//admin memlist
		@Override
		public List<MemberDto> getAdminMemList(int pageNumber) {
			return dao.getAdminMemList(pageNumber);
		}

		//전체 멤버
		@Override
		public int getMemLength() {
			return dao.getMemLength();
			
		}

}
