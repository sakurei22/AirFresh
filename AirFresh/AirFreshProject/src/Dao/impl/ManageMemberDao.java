package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ManageMemberDaoInterface;
import Dto.ManagerMemberDto;
import db.DBClose;
import db.DBConnection;


public class ManageMemberDao implements ManageMemberDaoInterface {
	
	public ManageMemberDao() {
		DBConnection.initConnection();
	}

	@Override
	public boolean insertManagerMember(ManagerMemberDto dto) {
		String sql = " INSERT INTO managerMember(mgr_index, mgr_auth, mgr_id, "
				+ " mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joindate, mgr_delDate, mgr_del) "
				+ " VALUES(managerMember_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		System.out.println(" 1/6 ManageMemberDao success ");
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println( "sql = " + sql );
		System.out.println(" 2/6 ManageMemberDao success ");
		int count = 0;

		
		try {
			System.out.println(" 3/6 ManageMemberDao success ");
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println(" 4/6 ManageMemberDao success ");
			
			psmt.setInt(1, dto.getMgr_auth());//권한 0 : 왕어드민    1: 매니저    2 : 설치기사
			psmt.setString(2, dto.getMgr_id());
			psmt.setString(3, dto.getMgr_pw());
			psmt.setString(4, dto.getMgr_name());
			psmt.setInt(5, dto.getMgr_loc());
			psmt.setString(6, dto.getMgr_cell());
			psmt.setString(7, null);
			psmt.setString(8, null);
			psmt.setInt(9, 0);
			
			System.out.println(" 5/6 ManageMemberDao success ");
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(" ManageMemberDao  DB FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 ManageMemberDao DBCLOSE ");
			DBClose.close(psmt, conn, null);
		}
		
		
		return count>0?true:false;
		
	}//end insertManagerMember

	@Override
	public List<ManagerMemberDto> receiveManagerMemberAll() {
		
		String sql = " SELECT mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joindate, mgr_delDate, mgr_del "
				+ " FROM managerMember "
				+ " order by MGR_INDEX ASC "; 
		
		System.out.println(" 1/6 receiveManagerMemberAll success ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<ManagerMemberDto> list=  new ArrayList<ManagerMemberDto>();
		
		System.out.println( "sql = " + sql );
		
		System.out.println(" 2/6 receiveManagerMemberAll success ");

		
		try {
			System.out.println(" 3/6 receiveManagerMemberAll success ");
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			System.out.println(" 4/6 receiveManagerMemberAll success ");
			while(rs.next()) {
				  int mgr_index = rs.getInt("mgr_index");
				  int mgr_auth = rs.getInt("mgr_auth");
				  String mgr_id = rs.getString("mgr_id");
				  String mgr_pw = rs.getString("mgr_pw");
				  String mgr_name = rs.getString("mgr_name"); 
				  int mgr_loc = rs.getInt("mgr_loc");
				  String mgr_cell = rs.getString("mgr_cell");
				  String  mgr_joinDate = rs.getString("mgr_joinDate");
				  String mgr_delDate = rs.getString("mgr_delDate");
				  int mgr_del = rs.getInt("mgr_del");
				  
				  list.add(new ManagerMemberDto(mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joinDate, mgr_delDate, mgr_del));
				  
			}//end while()
			System.out.println(" 5/6 receiveManagerMemberAll success ");
			
		} catch (SQLException e) {
			System.out.println(" receiveManagerMemberAll  FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 receiveManagerMemberAll DB CLOSE ");
//			DBClose.close(psmt, conn, null);
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

	@Override
	public ManagerMemberDto loginManagerMemberCehck(ManagerMemberDto managermemberdto) {
		String sql = " SELECT mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell,mgr_joindate, mgr_delDate, mgr_del "
					+ " FROM managerMember "
					+ " WHERE mgr_id=? AND mgr_pw=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ManagerMemberDto dto=  null;
		
		System.out.println( "sql = " + sql );
		System.out.println(" 2/6 loginManagerMemberCehck success ");
		int count = 0;

		
		try {
			System.out.println(" 3/6 loginManagerMemberCehck success ");
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			System.out.println(" 4/6 loginManagerMemberCehck success ");
			psmt.setString(1, managermemberdto.getMgr_id());
			psmt.setString(2, managermemberdto.getMgr_pw());
			

			System.out.println(" 5/6 loginManagerMemberCehck success ");
			rs = psmt.executeQuery();

			System.out.println(" 5.5/6 receiveManagerMemberAll success ");
			while(rs.next()) {
				  int mgr_index = rs.getInt("mgr_index");
				  int mgr_auth = rs.getInt("mgr_auth");
				  String mgr_id = rs.getString("mgr_id");
//				  String mgr_pw = rs.getString("mgr_pw");
				  String mgr_pw = null;
				  String mgr_name = rs.getString("mgr_name"); 
				  int mgr_loc = rs.getInt("mgr_loc");
				  String mgr_cell = rs.getString("mgr_cell");
				  String mgr_joinDate = rs.getString("mgr_joindate");
				  String mgr_delDate = rs.getString("mgr_deldate");
				  int mgr_del = rs.getInt("mgr_del");
				  
				  System.out.println("!!!!!!!!!!!!!!!!!"+mgr_index+" "+mgr_auth+" "+mgr_id+" "+mgr_pw+" "+mgr_name+" "+mgr_loc+" "+mgr_cell+" "+mgr_joinDate+" "+ mgr_delDate + " "+mgr_del);
				  
				  dto = new ManagerMemberDto(mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joinDate, mgr_delDate, mgr_del);
				  
			}
			
		} catch (SQLException e) {
			System.out.println(" loginManagerMemberCehck  DB FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 loginManagerMemberCehck DBCLOSE ");
			DBClose.close(psmt, conn, rs);
		}
		
		System.out.println("loginManagerMemberCehck RESULT =  "+dto);
		return dto;
		
	}//end of loginManagerMemberCehck

	@Override
	public ManagerMemberDto receiveManagerMemberSelect(String index) {
		String sql = " SELECT mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joindate, mgr_delDate, mgr_del "
				+ " FROM managerMember "
				+ " WHERE mgr_index=?";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	ManagerMemberDto dto=  null;
	
	System.out.println( "sql = " + sql );
	System.out.println(" 2/6 receiveManagerMemberSelect success ");
	int count = 0;

	
	try {
		System.out.println(" 3/6 receiveManagerMemberSelect success ");
		conn = DBConnection.getConnection();
		psmt = conn.prepareStatement(sql);
		
		System.out.println(" 4/6 receiveManagerMemberSelect success ");
		psmt.setString(1,index);
		

		System.out.println(" 5/6 receiveManagerMemberSelect success ");
		rs = psmt.executeQuery();

		System.out.println(" 5.5/6 receiveManagerMemberSelect success ");
		while(rs.next()) {
			  int mgr_index = rs.getInt("mgr_index");
			  int mgr_auth = rs.getInt("mgr_auth");
			  String mgr_id = rs.getString("mgr_id");
//			  String mgr_pw = rs.getString("mgr_pw");
			  String mgr_pw = null;
			  String mgr_name = rs.getString("mgr_name"); 
			  int mgr_loc = rs.getInt("mgr_loc");
			  String mgr_cell = rs.getString("mgr_cell");
			  String mgr_joinDate = rs.getString("mgr_joinDate");
			  String mgr_delDate = rs.getString("mgr_delDate");
			  int mgr_del = rs.getInt("mgr_del");
			  System.out.println("!!!receiveManagerMemberSelect!!!"+
			  mgr_index+" "+mgr_auth+" "+mgr_id+" "+mgr_pw+" "+mgr_name+" "+mgr_loc+" "+mgr_cell+" "+mgr_joinDate+" "+mgr_delDate+" "+mgr_del);
			  
			  dto = new ManagerMemberDto(mgr_index, mgr_auth, mgr_id, mgr_pw, mgr_name, mgr_loc, mgr_cell, mgr_joinDate,  mgr_delDate, mgr_del);
			  
		}
			
		} catch (SQLException e) {
			System.out.println(" receiveManagerMemberSelect  DB FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 receiveManagerMemberSelect DBCLOSE ");
			DBClose.close(psmt, conn, rs);
		}
	
	
	return dto;
	}//end of receiveManagerMemberSelect

	@Override
	public boolean setSelectedIndexChange(int number) {

//		String sql = " SELECT * FROM MANAGERMEMBER " + 
//					" WHERE mgr_index=? ";
		
		String sql = "update managerMember "
				+ " set mgr_del=1 where mgr_index=? ";

		
		
		System.out.println(" 1/6 ManageMemberDao success ");
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println( "sql = " + sql );
		System.out.println(" 2/6 ManageMemberDao success ");
		int count = 0;

		
		try {
			System.out.println(" 3/6 ManageMemberDao success ");
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println(" 4/6 ManageMemberDao success ");
			
			psmt.setInt(1, number);

			
			System.out.println(" 5/6 ManageMemberDao success ");
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(" ManageMemberDao  DB FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 ManageMemberDao DBCLOSE ");
			DBClose.close(psmt, conn, null);
		}
		
		
		return count>0?true:false;
	}

	@Override
	public boolean managerMemberUpdate(ManagerMemberDto ManagerMemberDto) {
		System.out.println("managerMemberUpdate 내의 파라미터값 : " + ManagerMemberDto);
//		String sql = " SELECT * FROM MANAGERMEMBER " + 
//					" WHERE mgr_index=? ";
		
		String sql = " UPDATE managerMember " + 
				" SET " + 
				//"-- 입력될 데이터 60000 k_admin 최고관리자 1 1012341234 0 0 " + 
				" mgr_auth=?, " + 
				" mgr_id=?, " + 
				" mgr_pw=?, " + 
				" mgr_name=?, " + 
				" mgr_loc=?, " + 
				" mgr_cell=?, "; 
				
		System.out.println("ManagerMemberDto.getMgr_delDate() : " +ManagerMemberDto.getMgr_delDate() + "\n");
		System.out.println("ManagerMemberDto : " +ManagerMemberDto);
		
				if((ManagerMemberDto.getMgr_delDate())!=null && (ManagerMemberDto.getMgr_delDate()).equals("SYSDATE")) {
					sql +=" mgr_delDate=SYSDATE, ";
					System.out.println(" 0/6  의 sysdate");
				}else {
					sql +=" mgr_delDate=null, ";
					System.out.println(" 0/6  null 입력 ");
				}
				
			sql+=" mgr_del=? " + 
				" WHERE " + 
				" mgr_index=? ";

		
		
		System.out.println(" 1/6 managerMemberUpdate success ");
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println( " managerMemberUpdate sql = " + sql );
		System.out.println(" 2/6 managerMemberUpdate success ");
		int count = 0;

		
		try {
			System.out.println(" 3/6 managerMemberUpdate success ");
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println(" 4/6 managerMemberUpdate success ");
			
			psmt.setInt(1, ManagerMemberDto.getMgr_auth());
			psmt.setString(2, ManagerMemberDto.getMgr_id());
			psmt.setString(3, ManagerMemberDto.getMgr_pw());
			psmt.setString(4, ManagerMemberDto.getMgr_name());
			psmt.setInt(5, ManagerMemberDto.getMgr_loc());
			psmt.setString(6, ManagerMemberDto.getMgr_cell());
//			psmt.setString(7, ManagerMemberDto.getMgr_delDate());
			psmt.setInt(7, ManagerMemberDto.getMgr_del());
			psmt.setInt(8, ManagerMemberDto.getMgr_index());
			

			System.out.println(" 5/6 managerMemberUpdate success ");
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(" managerMemberUpdate  DB FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 managerMemberUpdate DBCLOSE ");
			DBClose.close(psmt, conn, null);
		}
		
		
		return count>0?true:false;
	}//end of managerMemberUpdate

	@Override
	public boolean privateMemberInfoChange(ManagerMemberDto ManagerMemberdto) {
		
		System.out.println("ManagerMemberdto 의 값 들어온거 확인 + = " + ManagerMemberdto);
		
		
		String sql = " UPDATE managerMember " + 
					" SET ";
				
					if((ManagerMemberdto.getMgr_pw()==null) || (ManagerMemberdto.getMgr_pw().equals(""))){
					
					}else {
						sql +="mgr_pw=?, ";
					}
					sql+=" mgr_name=?, "+  
					" mgr_cell=? " + 
					" WHERE " + 
					" mgr_index=? ";
	
		System.out.println( sql);
		
		System.out.println(" 1/6 privateMemberInfoChange success ");
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println( " managerMemberUpdate sql = " + sql );
		System.out.println(" 2/6 privateMemberInfoChange success ");
		int count = 0;

		
		try {
			System.out.println(" 3/6 privateMemberInfoChange success ");
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println(" 4/6 privateMemberInfoChange success ");
			System.out.println("맴버디티오 네임 값" + ManagerMemberdto.getMgr_name());
			if((ManagerMemberdto.getMgr_pw()==null) || (ManagerMemberdto.getMgr_pw().equals(""))){
				psmt.setString(1, ManagerMemberdto.getMgr_name());
				psmt.setString(2, ManagerMemberdto.getMgr_cell());
				psmt.setInt(3, ManagerMemberdto.getMgr_index());
			}else {
				psmt.setString(1, ManagerMemberdto.getMgr_pw());
				psmt.setString(2, ManagerMemberdto.getMgr_name());
				psmt.setString(3, ManagerMemberdto.getMgr_cell());
				psmt.setInt(4, ManagerMemberdto.getMgr_index());
			}
			

			System.out.println(" 5/6 privateMemberInfoChange success ");
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(" privateMemberInfoChange  DB FAIL ");
			e.printStackTrace();
		}finally {
			System.out.println(" 6/6 privateMemberInfoChange DBCLOSE ");
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
	}// end of privateMemberInfoChange()
	
	
	
}// end of ManagerMemberDao class
