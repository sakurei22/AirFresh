package Dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.InstallDaoInterface;
import Dto.InstallDto;
import Utill.Jutill;
import db.DBClose;
import db.DBConnection;

public class InstallDao implements InstallDaoInterface, Serializable {

	public InstallDao() {
		DBConnection.initConnection();
	}
	
	
	//관리자용 메소드 ( 담당자가 없는 모든 install 리스트를 가져온다)
	public List<InstallDto> getNullInstallList(){
		
		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, "
						+ "	i.comp_date, i.mgr_index, i.ins_state, "
						+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell, "
						+ " p.pur_date ,"
				+ " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2 "
				+ " WHERE i.pur_index = p.pur_index  AND "
				+ " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND "
				+ " i.mgr_index IS NULL ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<InstallDto> list = new ArrayList<InstallDto>();
		System.out.println("[getNullInstallList] sql = " + sql);

		try {

			conn = DBConnection.getConnection();
			System.out.println("[getNullInstallList]  1/6");
			psmt = conn.prepareStatement(sql);
			System.out.println("[getNullInstallList]  2/6");

			rs = psmt.executeQuery();
			System.out.println("[getNullInstallList]  3/6");

			while (rs.next()) {

				InstallDto dto = new InstallDto(rs.getInt("ins_index"), // 제품설치(install) 인덱스
						rs.getInt("pur_index"), // 렌탈(purchase) 인덱스
						rs.getString("ins_date"), // 설치 희망일
						rs.getString("comp_date"), // 설치 완료일
						rs.getInt("mgr_index"), // 매니저(직원) 인덱스
						rs.getInt("ins_state"), // 설치 상태
						rs.getString("prd_model_name"), // 제품명
						rs.getString("mem_id"), // 회원아이디
						rs.getString("mem_name"), // 회원이름
						rs.getString("pur_date"), // 구매일
						rs.getString("mem_addr1"), // 회원 주소1 (우편번호)
						rs.getString("mem_addr2"), // 회원 주소2 (xx도 xx시)
						rs.getString("mem_addr3"), // 회원 주소3(xx구 xx동)
						rs.getString("mem_cell"));
				list.add(dto);

			}
			System.out.println("[getNullInstallList]  4/6");
		} catch (SQLException e) {
			System.out.println("[getNullInstallList] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}

	// 이것도 관리자용 특정날짜의 담당자가 Null인 리스트를 가져오는 메소드
	public List<InstallDto> getNullInstallList(String date) {

		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell,"
				+ " p.pur_date " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.mgr_index IS NULL AND " + " TO_CHAR(i.ins_date,'YYYY/MM/DD') = '"
				+ date + "' " + " ORDER BY i.ins_index ASC ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<InstallDto> list = new ArrayList<InstallDto>();
		System.out.println("[getNullInstallList(Date)] sql = " + sql);

		try {

			conn = DBConnection.getConnection();
			System.out.println("[getNullInstallList(Date)]  1/6");
			psmt = conn.prepareStatement(sql);
			System.out.println("[getNullInstallList(Date)]  2/6");

			rs = psmt.executeQuery();
			System.out.println("[getNullInstallList(Date)]  3/6");

			while (rs.next()) {

				InstallDto dto = new InstallDto(rs.getInt("ins_index"), // 제품설치(install) 인덱스
						rs.getInt("pur_index"), // 렌탈(purchase) 인덱스
						rs.getString("ins_date"), // 설치 희망일
						rs.getString("comp_date"), // 설치 완료일
						rs.getInt("mgr_index"), // 매니저(직원) 인덱스
						rs.getInt("ins_state"), // 설치 상태
						rs.getString("prd_model_name"), // 제품명
						rs.getString("mem_id"), // 회원아이디
						rs.getString("mem_name"), // 회원이름
						rs.getString("pur_date"), // 구매일
						rs.getString("mem_addr1"), // 회원 주소1 (우편번호)
						rs.getString("mem_addr2"), // 회원 주소2 (xx도 xx시)
						rs.getString("mem_addr3"), // 회원 주소3(xx구 xx동)
						rs.getString("mem_cell"));
				list.add(dto);

			}
			System.out.println("[getNullInstallList(Date)]  4/6");
		} catch (SQLException e) {
			System.out.println("[getNullInstallList(Date)] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}

	// 설치신청 데이터를 추가해주는 메소드
	public boolean addInstall(InstallDto dto) {

		String sql = " INSERT INTO INSTALL(ins_index, pur_index, ins_date, ins_state) "
				+ " VALUES( INSTALL_SEQ.NEXTVAL , ?, TO_DATE(?), 0) ";

		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		System.out.println("[addInstall] sql = " + sql);

		// 날짜 Date 형식에 맞춰서 작성
		String date = dto.getIns_date();
		System.out.println(date);

		date = date.replace("-", "/");
		System.out.println(date);
		date = date.substring(0, 10);
		System.out.println(date);

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getPur_index());
			psmt.setString(2, date);

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return count > 0 ? true : false;
	}

	// 설치신청 데이터에 담당자 정보를 넣어주는 메소드
	public boolean insertMgrID(int ins_index, int mgr_index) {

		System.out.println("insertMgrID ins" + ins_index);
		System.out.println("insertMgrID mgr" + mgr_index);

		String sql = "UPDATE INSTALL " + " SET mgr_index =?" + " WHERE ins_index =?";

		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		System.out.println("[insertMgrID] sql = " + sql);

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mgr_index);
			psmt.setInt(2, ins_index);

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[insertMgrID] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		System.out.println(count);
		return count > 0 ? true : false;
	}

	// 장바구니의 데이터에 담당자를 넣다가 에러발생시 처리를 롤백하기 위한 메소드
	public boolean insertNull(int ins_index, int mgr_index) {

		String sql = " UPDATE INSTALL " + " SET mgr_index =? " + " WHERE ins_index =? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		System.out.println("[insertMgrID] sql = " + sql);

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mgr_index);
			psmt.setInt(2, ins_index);

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[insertMgrID] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return count > 0 ? true : false;
	}

	// 근무지별로 특정날짜의 데이터를 가져오는 메소드
	public List<InstallDto> getMgrPicDayList(String date, String loc) {

		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell,"
				+ " p.pur_date " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.mgr_index IS NULL AND " + " TO_CHAR(i.ins_date,'YYYY/MM/DD') = '"
				+ date + "' ";

		if (loc.equals("기타")) {
			sql += " AND  m2.mem_addr2 NOT LIKE '%강남구%' AND " + "  m2.mem_addr2 NOT LIKE '%성동구%' AND "
					+ "  m2.mem_addr2 NOT LIKE '%중랑구%' ";
		} else {
			sql += " AND m2.mem_addr2 LIKE '%" + loc + "%'";
		}

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		// 쿼리문 확인용
		System.out.println("[getMgrPicDayList] sql = " + sql);
		// 리턴용 list 생성
		List<InstallDto> list = new ArrayList<InstallDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				InstallDto dto = new InstallDto(rs.getInt("ins_index"), // 제품설치(install) 인덱스
						rs.getInt("pur_index"), // 렌탈(purchase) 인덱스
						rs.getString("ins_date"), // 설치 희망일
						rs.getString("comp_date"), // 설치 완료일
						rs.getInt("mgr_index"), // 매니저(직원) 인덱스
						rs.getInt("ins_state"), // 설치 상태
						rs.getString("prd_model_name"), // 제품명
						rs.getString("mem_id"), // 회원아이디
						rs.getString("mem_name"), // 회원이름
						rs.getString("pur_date"), // 구매일
						rs.getString("mem_addr1"), // 회원 주소1 (우편번호)
						rs.getString("mem_addr2"), // 회원 주소2 (xx도 xx시)
						rs.getString("mem_addr3"), // 회원 주소3(xx구 xx동)
						rs.getString("mem_cell"));
				list.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("[getMgrPicDayList] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}

	// 특정날짜의 근무지외의 기타인 Null 리스트를 가져오는 메소드
	public List<InstallDto> getGitaNullList(String date) {

		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell, "
				+ " p.pur_date " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.mgr_index IS NULL AND " + " TO_CHAR(i.ins_date,'YYYY/MM/DD') = '"
				+ date + "'  AND" + "  m2.mem_addr2 NOT LIKE '%강남구%' AND " + "  m2.mem_addr2 NOT LIKE '%성동구%' AND "
				+ "  m2.mem_addr2 NOT LIKE '%중랑구%' ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		System.out.println("[getGitaNullList] sql = " + sql);

		List<InstallDto> list = new ArrayList<InstallDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				InstallDto dto = new InstallDto(rs.getInt("ins_index"), // 제품설치(install) 인덱스
						rs.getInt("pur_index"), // 렌탈(purchase) 인덱스
						rs.getString("ins_date"), // 설치 희망일
						rs.getString("comp_date"), // 설치 완료일
						rs.getInt("mgr_index"), // 매니저(직원) 인덱스
						rs.getInt("ins_state"), // 설치 상태
						rs.getString("prd_model_name"), // 제품명
						rs.getString("mem_id"), // 회원아이디
						rs.getString("mem_name"), // 회원이름
						rs.getString("pur_date"), // 구매일
						rs.getString("mem_addr1"), // 회원 주소1 (우편번호)
						rs.getString("mem_addr2"), // 회원 주소2 (xx도 xx시)
						rs.getString("mem_addr3"), rs.getString("mem_cell")); // 회원 주소3(xx구 xx동)
				list.add(dto);

			}

		} catch (SQLException e) {
			System.out.println("[getGitaNullList]fail ");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}

	public List<InstallDto> getNoCompMyList(int mgr_index) {
		Jutill ju = new Jutill();
		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell, "
				+ " p.pur_date " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.mgr_index =? AND P.order_auth=0" + " AND comp_date IS NULL "
				+ " ORDER BY i.ins_index DESC ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		System.out.println("[getNoCompMyList] sql = " + sql);

		List<InstallDto> list = new ArrayList<InstallDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mgr_index);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int ind = 0;
				// list에 추가
				InstallDto dto = new InstallDto(rs.getInt("ins_index"), rs.getInt("pur_index"),
						ju.ChangeDate(rs.getString("ins_date")), rs.getString("comp_date"), rs.getInt("mgr_index"),
						rs.getInt("ins_state"), rs.getString("prd_model_name"), rs.getString("mem_id"),
						rs.getString("mem_name"), rs.getString("pur_date"), rs.getString("mem_addr1"),
						rs.getString("mem_addr2"), rs.getString("mem_addr3"), rs.getString("mem_cell"));

				list.add(dto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}

	public List<InstallDto> getCompMyList(int mgr_index) {
		Jutill ju = new Jutill();
		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell, "
				+ " p.pur_date , o.rating " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2, orderReview o"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.ins_index = o.ins_index AND " + " i.mgr_index =? "
				+ " AND comp_date IS NOT NULL " + " ORDER BY i.ins_index DESC ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		System.out.println("[getCompMyList] sql = " + sql);

		List<InstallDto> list = new ArrayList<InstallDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mgr_index);

			rs = psmt.executeQuery();

			while (rs.next()) {

				// list에 추가
				InstallDto dto = new InstallDto(rs.getInt("ins_index"), rs.getInt("pur_index"),
						ju.ChangeDate(rs.getString("ins_date")), rs.getString("comp_date"), rs.getInt("mgr_index"),
						rs.getInt("ins_state"), rs.getString("prd_model_name"), rs.getString("mem_id"),
						rs.getString("mem_name"), rs.getString("pur_date"), rs.getString("mem_addr1"),
						rs.getString("mem_addr2"), rs.getString("mem_addr3"), rs.getString("mem_cell"),
						rs.getString("rating"));

				list.add(dto);

			}

		} catch (SQLException e) {
			System.out.println("[getCompMyList] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}

	public InstallDto getDetailDto(int index) {
		Jutill ju = new Jutill();

		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell, "
				+ " p.pur_date " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.ins_index = " + index;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		System.out.println("[getDetailDto] sql = " + sql);
		InstallDto dto = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new InstallDto(rs.getInt("ins_index"), rs.getInt("pur_index"),
						ju.ChangeDate(rs.getString("ins_date")), rs.getString("comp_date"), rs.getInt("mgr_index"),
						rs.getInt("ins_state"), rs.getString("prd_model_name"), rs.getString("mem_id"),
						rs.getString("mem_name"), rs.getString("pur_date"), rs.getString("mem_addr1"),
						rs.getString("mem_addr2"), rs.getString("mem_addr3"), rs.getString("mem_cell"));

			}
		} catch (SQLException e) {
			System.out.println("[getDetailDto] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return dto;
	}

	public boolean compInstall(int index) {

		String sql = " UPDATE install " + " SET ins_state = 1,  comp_date = sysdate " + " WHERE ins_index =? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		System.out.println("[compInstall] sql = " + sql);

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, index);

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[compInstall] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return count > 0 ? true : false;

	}

	@Override
	public List<InstallDto> getCompInstallList() {
		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, i.comp_date, i.mgr_index, i.ins_state, " + 
				" m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_cell, p.pur_date, m3.mgr_name, " + 
				" m3.mgr_loc, m3.mgr_cell, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3 " + 
				" FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2, managerMember m3 " + 
				" WHERE i.pur_index = p.pur_index  AND  p.prd_index = m1.prd_index  AND  p.mem_id = m2.mem_id  "
				+ " AND m3.mgr_index= i.mgr_index AND  i.ins_state= 1 ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<InstallDto> list = new ArrayList<InstallDto>();
		System.out.println("[getCompInstallList] sql = " + sql);

		try {

			conn = DBConnection.getConnection();
			System.out.println("[getCompInstallList]  1/6");
			psmt = conn.prepareStatement(sql);
			System.out.println("[getCompInstallList]  2/6");

			rs = psmt.executeQuery();
			System.out.println("[getCompInstallList]  3/6");

			while (rs.next()) {
					int i = 1;

				InstallDto dto = new InstallDto(
						rs.getInt(i++), // ins_index
						rs.getInt(i++), // pur_index
						rs.getString(i++), // ins_date
						rs.getString(i++), // comp_date
						rs.getInt(i++), // mgr_index
						rs.getInt(i++), // ins_state
						rs.getString(i++), // prd_model_name
						rs.getString(i++), // mem_id
						rs.getString(i++), // mem_name
						rs.getString(i++), // mem_cell
						rs.getString(i++), // pur_date
						rs.getString(i++), // mgr_name
						rs.getInt(i++), // mgr_loc
						rs.getString(i++), //mgr_cell
						rs.getString(i++), //mem_addr1
						rs.getString(i++), //mem_addr2
						rs.getString(i++)); //mem_addr3
					
				list.add(dto);

			}
			System.out.println("[getCompInstallList]  4/6");
		} catch (SQLException e) {
			System.out.println("[getCompInstallList] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}

	@Override
	public List<InstallDto> getWaitInstallList() {
		String sql = " SELECT  i.ins_index, i.pur_index, i.ins_date, " + "	i.comp_date, i.mgr_index, i.ins_state, "
				+ " m1.prd_model_name, m2.mem_id, m2.mem_name, m2.mem_addr1, m2.mem_addr2, m2.mem_addr3, m2.mem_cell, "
				+ " p.pur_date " + " FROM INSTALL i, PURCHASE p, MODELLIST m1, MEMBERS m2"
				+ " WHERE i.pur_index = p.pur_index  AND " + " p.prd_index = m1.prd_index  AND "
				+ " p.mem_id = m2.mem_id AND " + " i.ins_state= 0";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<InstallDto> list = new ArrayList<InstallDto>();
		System.out.println("[getCompInstallList] sql = " + sql);

		try {

			conn = DBConnection.getConnection();
			System.out.println("[getCompInstallList]  1/6");
			psmt = conn.prepareStatement(sql);
			System.out.println("[getCompInstallList]  2/6");

			rs = psmt.executeQuery();
			System.out.println("[getCompInstallList]  3/6");

			while (rs.next()) {

				InstallDto dto = new InstallDto(rs.getInt("ins_index"), // 제품설치(install) 인덱스
						rs.getInt("pur_index"), // 렌탈(purchase) 인덱스
						rs.getString("ins_date"), // 설치 희망일
						rs.getString("comp_date"), // 설치 완료일
						rs.getInt("mgr_index"), // 매니저(직원) 인덱스
						rs.getInt("ins_state"), // 설치 상태
						rs.getString("prd_model_name"), // 제품명
						rs.getString("mem_id"), // 회원아이디
						rs.getString("mem_name"), // 회원이름
						rs.getString("pur_date"), // 구매일
						rs.getString("mem_addr1"), // 회원 주소1 (우편번호)
						rs.getString("mem_addr2"), // 회원 주소2 (xx도 xx시)
						rs.getString("mem_addr3"), // 회원 주소3(xx구 xx동)
						rs.getString("mem_cell"));
				list.add(dto);

			}
			System.out.println("[getCompInstallList]  4/6");
		} catch (SQLException e) {
			System.out.println("[getCompInstallList] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}


	@Override
	public List<InstallDto> getMainInstallList() {
		String sql = " select rownum, i.ins_index, i.comp_date, m1.prd_model_name from " + 
				" INSTALL i, PURCHASE p, MODELLIST m1 " + 
				" WHERE i.pur_index = p.pur_index  AND p.prd_index = m1.prd_index " + 
				" AND i.ins_state=1 AND ROWNUM >=1 AND ROWNUM<=5 " + 
				" ORDER BY i.comp_date desc ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<InstallDto> list = new ArrayList<InstallDto>();
		System.out.println("[getgetMainInstallList] sql = " + sql);

		try {

			conn = DBConnection.getConnection();
			System.out.println("[getgetMainInstallList]  1/6");
			psmt = conn.prepareStatement(sql);
			System.out.println("[getgetMainInstallList]  2/6");

			rs = psmt.executeQuery();
			System.out.println("[getNullInstallList(Date)]  3/6");

			while (rs.next()) {
				int i = 2;
				InstallDto dto = new InstallDto(
						rs.getInt(i++), 
						rs.getString(i++), 
						rs.getString(i++) 
						);
						list.add(dto);

			}
			System.out.println("[getgetMainInstallList]  4/6");
		} catch (SQLException e) {
			System.out.println("[getgetMainInstallList] fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}



}
