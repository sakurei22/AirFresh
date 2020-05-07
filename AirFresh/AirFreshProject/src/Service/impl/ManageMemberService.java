package Service.impl;

import java.util.List;

import Dao.ManageMemberDaoInterface;
import Dao.impl.ManageMemberDao;
import Dto.ManagerMemberDto;
import Service.ManageMemberInterface;

public class ManageMemberService implements ManageMemberInterface{
	
	ManageMemberDaoInterface mmdao= new ManageMemberDao();

	@Override
	public boolean insertManagerMember(ManagerMemberDto dto) {
		return mmdao.insertManagerMember(dto);
	}
	
	
	@Override
	public List<ManagerMemberDto> receiveManagerMemberAll() {
		return mmdao.receiveManagerMemberAll();
	}//receiveManagerMemberAll


	@Override
	public ManagerMemberDto loginManagerMembercheck(ManagerMemberDto managermemberdto) {		
		return mmdao.loginManagerMemberCehck(managermemberdto);
	}


	@Override
	public ManagerMemberDto receiveManagerMemberSelect(String indexno) {
		// TODO managerList에서 특정 메니저 인덱스를 받아서 해당 메니저의 정보를 가져옴.   
		return mmdao.receiveManagerMemberSelect(indexno);
	}


	@Override
	public boolean setSelectedIndexChange(int number) {
		return mmdao.setSelectedIndexChange(number);
	}


	@Override
	public boolean managerMemberUpdate(ManagerMemberDto managermemdto) {
		
		return mmdao.privateMemberInfoChange(managermemdto);
	}
	
	
	
	

	
	

}
