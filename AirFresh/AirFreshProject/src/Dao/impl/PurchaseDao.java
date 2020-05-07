package Dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.PurchaseDaoInterface;
import Dto.PurchaseDto;
import Dto.PurchaseNameDto;
import Dto.RentalDetailDto;
import db.DBClose;
import db.DBConnection;


public class PurchaseDao implements PurchaseDaoInterface {

	public PurchaseDao() {
		
	}
	
	public boolean purchaseInsert(String mem_id, int prd_index, String ins_date) {
		String sql = " INSERT INTO PURCHASE ( PUR_INDEX, MEM_ID, PRD_INDEX, PUR_DATE, "
				+ " INS_DATE, ORDER_NUM, REVIEW, ORDER_AUTH ) "
				+ " VALUES ( PURCHASE_SEQ.NEXTVAL , ?, ?, SYSDATE, ?, 1, 0, 0 ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 insert");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 insert");
			
			psmt.setString(1, mem_id);
			psmt.setInt(2, prd_index);
			psmt.setString(3, ins_date);
			
			count = psmt.executeUpdate();
			System.out.println("3/6 insert");
			
		} catch (SQLException e) {
			System.out.println("insert fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
	}
	
	
	public boolean purchaseDelete(int pur_index) {
		String sql = " UPDATE PURCHASE "
				+ " SET ORDER_AUTH=1 "
				+ " WHERE PUR_INDEX=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 purchasedel success");
			psmt = conn.prepareStatement(sql);
			System.out.println("1/6 purchasedel success");
			
			psmt.setInt(1, pur_index);
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("purchasedel fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
	}
	
	
	@Override
	public List<PurchaseNameDto> getPurchaseList() {
		String sql = " SELECT p.pur_index, mem_id, p.prd_index, m.prd_name, m.prd_model_name,pur_date,"
				+ " p.ins_date, order_num, review, order_auth, i.ins_state "
				+ " FROM  purchase p, modellist m, install i "
				+ " where p.prd_index = m.prd_index and i.pur_index = p.pur_index "
				+ " ORDER BY p.PUR_DATE DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PurchaseNameDto> list = new ArrayList<PurchaseNameDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 memPurchaseList success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 memPurchaseList success");

			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				PurchaseNameDto dto = new PurchaseNameDto(
						rs.getInt(i++),//pur_index, 
						rs.getString(i++),//mem_id, 
						rs.getInt(i++),//prd_index, 
						rs.getString(i++),//prd_name, 
						rs.getString(i++),//prd_model_name, 
						rs.getString(i++),//pur_date, 
						rs.getString(i++),//ins_date, 
						rs.getInt(i++),//order_num,
						rs.getInt(i++),//review
						rs.getInt(i++),//order_auth)
						rs.getInt(i++));//ins_state
				
				
				list.add(dto);
			}
			System.out.println("3/6 memPurchaseList success");
		} catch (SQLException e) {
			System.out.println("memPurchaseList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}
	
	
	

	/*
	@Override
	public List<PurchaseDto> getPurchaseList() {
		
		String sql = " SELECT PUR_INDEX, MEM_ID, PRD_INDEX, PUR_DATE, INS_DATE, "
				+ " ORDER_NUM, REVIEW, ORDER_AUTH "
				+ " FROM PURCHASE "
				+ " ORDER BY PUR_DATE DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PurchaseDto> list = new ArrayList<PurchaseDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPurchaseList success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getPurchaseList success");
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				PurchaseDto dto = new PurchaseDto(rs.getInt(i++),//pur_index, 
												rs.getString(i++),//mem_id, 
												rs.getInt(i++),//prd_index, 
												rs.getString(i++),//pur_date, 
												rs.getString(i++),//ins_date, 
												rs.getInt(i++),//order_num, 
												rs.getInt(i++),//review, 
												rs.getInt(i++));//	order_auth);
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}/**/

	
	/*
	@Override
	public List<PurchaseDto> memPurchaseList(String mem_id) {
		String sql = " SELECT PUR_INDEX, MEM_ID, PRD_INDEX, PUR_DATE, INS_DATE, "
				+ " ORDER_NUM, REVIEW, ORDER_AUTH "
				+ " FROM PURCHASE "
				+ " WHERE MEM_ID = ? "
				+ " ORDER BY PUR_INDEX ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PurchaseDto> list = new ArrayList<PurchaseDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 memPurchaseList success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 memPurchaseList success");
			
			psmt.setString(1, mem_id);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				PurchaseDto dto = new PurchaseDto(rs.getInt(i++),//pur_index, 
												rs.getString(i++),//mem_id, 
												rs.getInt(i++),//prd_index, 
												rs.getString(i++),//pur_date, 
												rs.getString(i++),//ins_date, 
												rs.getInt(i++),//order_num, 
												rs.getInt(i++),//review, 
												rs.getInt(i++));//	order_auth);
				
				
				list.add(dto);
			}
			System.out.println("3/6 memPurchaseList success");
		} catch (SQLException e) {
			System.out.println("memPurchaseList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}/**/
	@Override
	public List<PurchaseNameDto> memPurchaseList(String mem_id) {
		String sql = " SELECT p.pur_index, p.mem_id, p.prd_index, m.prd_name, m.prd_model_name,pur_date,"
				+ " p.ins_date, order_num, review, order_auth, i.ins_state "
				+ " FROM  purchase p, modellist m, install i "
				+ " where p.prd_index = m.prd_index and i.pur_index = p.pur_index "
				+ " and p.mem_id =? "
				+ " ORDER BY p.PUR_DATE DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PurchaseNameDto> list = new ArrayList<PurchaseNameDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 memPurchaseList success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 memPurchaseList success");
			
			psmt.setString(1, mem_id);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				PurchaseNameDto dto = new PurchaseNameDto(
						rs.getInt(i++),//pur_index, 
						rs.getString(i++),//mem_id, 
						rs.getInt(i++),//prd_index, 
						rs.getString(i++),//prd_name, 
						rs.getString(i++),//prd_model_name, 
						rs.getString(i++),//pur_date, 
						rs.getString(i++),//ins_date, 
						rs.getInt(i++),//order_num,
						rs.getInt(i++),//review, 
						rs.getInt(i++),//order_auth)
						rs.getInt(i++));//ins_state
				
				list.add(dto);
			}
			System.out.println("3/6 memPurchaseList success");
		} catch (SQLException e) {
			System.out.println("memPurchaseList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

	/*
	@Override
	public PurchaseDto getPurchaseOne(int pur_index) {
		//구매 내역 상세
		String sql =" SELECT PUR_INDEX, MEM_ID, PRD_INDEX, PUR_DATE, INS_DATE, "
					+ " ORDER_NUM, REVIEW, ORDER_AUTH "
					+ " FROM PURCHASE "
					+ " WHERE PUR_INDEX=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		PurchaseDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPurchaseOne success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getPurchaseOne success");
			psmt.setInt(1, pur_index);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				int i = 1;
				dto = new PurchaseDto(rs.getInt(i++),//pur_index, 
									 rs.getString(i++),//mem_id, 
									 rs.getInt(i++),//prd_index, 
									 rs.getString(i++),//pur_date, 
									 rs.getString(i++),//ins_date, 
									 rs.getInt(i++),//order_num, 
									 rs.getInt(i++),//review, 
									 rs.getInt(i++));	//order_auth)
			}
			
			System.out.println("3/6 getPurchaseOne success");
		} catch (SQLException e) {
			System.out.println("getPurchaseOne fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		return dto;
	}/**/
	
	
	/*
	@Override
	public PurchaseNameDto getPurchaseOne(int pur_index) {
		String sql = " SELECT PUR_INDEX, MEM_ID, P.PRD_INDEX, M.PRD_NAME, M.PRD_MODEL_NAME, PUR_DATE, INS_DATE, "
				+ " ORDER_NUM, REVIEW, ORDER_AUTH "
				+ " FROM MODELLIST M, PURCHASE P "
				+ " WHERE P.PRD_INDEX = M.PRD_INDEX "
				+ " AND P.PUR_INDEX = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		PurchaseNameDto dto = new PurchaseNameDto();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPurchaseOne success");
			psmt = conn.prepareStatement(sql);
			System.out.println("1/6 getPurchaseOne success");
			
			psmt.setInt(1, pur_index);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				int i = 1;
					dto = new PurchaseNameDto(
						rs.getInt(i++),//pur_index, 
						rs.getString(i++),//mem_id, 
						rs.getInt(i++),//prd_index, 
						rs.getString(i++),//prd_name, 
						rs.getString(i++),//prd_model_name, 
						rs.getString(i++),//pur_date, 
						rs.getString(i++),//ins_date, 
						rs.getInt(i++),//order_num,
						rs.getInt(i++),//review, 
						rs.getInt(i++));//order_auth)
			}
			 
		} catch (SQLException e) {
			System.out.println("getPurchaseOne fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		
		return dto;
	}/**/
	


	
	public List<PurchaseNameDto> getModelName(String mem_id) {
		//모델name 뽑아오기
		String sql = " SELECT PUR_INDEX, MEM_ID, P.PRD_INDEX, M.PRD_NAME, M.PRD_MODEL_NAME, PUR_DATE, INS_DATE, ORDER_NUM, REVIEW, ORDER_AUTH "
				+ " FROM MODELLIST M, PURCHASE P "
				+ " WHERE P.PRD_INDEX = M.PRD_INDEX "
				+ " AND P.MEM_ID = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PurchaseNameDto> list = new ArrayList<PurchaseNameDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getModelName success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getModelName success");

			psmt.setString(1, mem_id);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int i = 1;
				PurchaseNameDto dto = new PurchaseNameDto(
						rs.getInt(i++),//pur_index, 
						rs.getString(i++),//mem_id, 
						rs.getInt(i++),//prd_index, 
						rs.getString(i++),//prd_name, 
						rs.getString(i++),//prd_model_name, 
						rs.getString(i++),//pur_date, 
						rs.getString(i++),//ins_date, 
						rs.getInt(i++),//order_num,
						rs.getInt(i++),//review, 
						rs.getInt(i++),//order_auth)
						rs.getInt(i++));//ins_state
				list.add(dto);
			}
			
			System.out.println("3/6 getModelName success");
			
		} catch (SQLException e) {
			System.out.println("getModelName fail");
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	
	
	public PurchaseDto getNewCreate_Pur() {
		
		String sql = " SELECT pur_index, ins_date "
				+ " FROM ( SELECT *  FROM PURCHASE  ORDER BY pur_index  DESC ) "
				+ "	WHERE ROWNUM = 1";
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		//sql 쿼리문 확인용 
		System.out.println("[getNewCreate_Pur] sql = " + sql);
		
		//반환용 dto 준비
		PurchaseDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new PurchaseDto(rs.getInt("pur_index"),// 마지막 생성 index
										rs.getString("ins_date"));//설치 희망일
			}
			
			
		} catch (SQLException e) {
			System.out.println("[getNewCreate_Pur] fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
	}
	

	
	public boolean userPurConfirm(String userID) {
		
		String sql = " SELECT * FROM purchase "
				+ " WHERE mem_id =? ";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		System.out.println("[userPurConfirm] sql = " + sql);
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				count++;
			}
			
			
		} catch (SQLException e) {
			System.out.println("[userPurConfirm] fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		return count>0?true:false;
	}



	@Override
	public RentalDetailDto getDetail(int pur_index) {
		String sql = " select p.pur_index, m.prd_price, m.prd_index, p.mem_id, s.mem_name, s.mem_cell, s.mem_addr1, "
				+ " s.mem_addr2, s.mem_addr3, m.prd_name, m.prd_model_name, "
				+ " p.pur_date, p.ins_date, i.comp_date , p.review, i.ins_state "
				+ " from modellist m, purchase p, members s, install i "
				+ " where m.prd_index = p.prd_index and p.mem_id = s.mem_id and p.pur_index = i.pur_index " 
				+ " and p.pur_index = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		RentalDetailDto dto = new RentalDetailDto();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getDetail success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getDetail success");
			
			psmt.setInt(1, pur_index);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int i = 1;
				dto = new RentalDetailDto(
										 rs.getInt(i++),//pur_index, 
										  rs.getInt(i++),//prd_price
										  rs.getInt(i++),//prd_index
										  rs.getString(i++),//mem_id, 
										  rs.getString(i++),//mem_name, 
										  rs.getString(i++),//mem_cell, 
										  rs.getInt(i++),//mem_addr1, 
										  rs.getString(i++),//	mem_addr2, 
										  rs.getString(i++),//	mem_addr3, 
										  rs.getString(i++),//	prd_name, 
										  rs.getString(i++),//prd_model_name, 
										  rs.getString(i++),//pur_date, 
										  rs.getString(i++),//	ins_date, 
										  rs.getString(i++),//	comp_date)
										  rs.getInt(i++),//review
										  rs.getInt(i++));//ins_state
			}
			
			
		} catch (SQLException e) {
			System.out.println("getDetail fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		return dto;
	}

	@Override
	public List<PurchaseNameDto> getModelName(int pageNumber) {
		//모델name 뽑아오기
				String sql = " SELECT PUR_INDEX, MEM_ID, PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PUR_DATE, INS_DATE, ORDER_NUM, REVIEW, ORDER_AUTH "
						+ " FROM (SELECT ROWNUM as rnum, PUR_INDEX, MEM_ID, PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PUR_DATE, INS_DATE,  "
						+ " ORDER_NUM, REVIEW, ORDER_AUTH "
						+ " FROM (SELECT PUR_INDEX, MEM_ID, P.PRD_INDEX, M.PRD_NAME,M.PRD_MODEL_NAME, PUR_DATE, "
						+ " INS_DATE, ORDER_NUM, REVIEW, ORDER_AUTH "
						+ " FROM MODELLIST M, PURCHASE P  "
						+ " WHERE P.PRD_INDEX = M.PRD_INDEX"
						+ " ORDER BY PUR_DATE DESC ) "
						+ " ) "
						+ " WHERE rnum >=? AND rnum <=? ";
				
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				
				int start, end;
				start = 1 + 10 * pageNumber;	// 0 -> 1	1 -> 11
				end = 10 + 10 * pageNumber;	// 0 -> 10  1 -> 20
				List<PurchaseNameDto> list = new ArrayList<PurchaseNameDto>();
				
				try {
					conn = DBConnection.getConnection();
					System.out.println("1/6 getModelName success");
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, start);
					psmt.setInt(2, end);	
					System.out.println("2/6 getModelName success");
					
					rs = psmt.executeQuery();
					while(rs.next()) {
						int i = 1;
						PurchaseNameDto dto = new PurchaseNameDto(rs.getInt(i++),//pur_index, 
																  rs.getString(i++),//mem_id,
																  rs.getInt(i++),//prd_index, 
																  rs.getString(i++),//prd_name,
																  rs.getString(i++),//prd_model_name, 
																  rs.getString(i++),//pur_date, 
																  rs.getString(i++),//ins_date,
																  rs.getInt(i++),//order_num, 
																  rs.getInt(i++),//review,
																  rs.getInt(i++));//order_auth)
						
						list.add(dto);
					}
					
					System.out.println("3/6 getModelName success");
					
				} catch (SQLException e) {
					System.out.println("getModelName fail");
					e.printStackTrace();
				}
				
				return list;
				
	}

	@Override
	public int getlength() {
		String sql = " SELECT COUNT(*) FROM PURCHASE ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int len = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				len = rs.getInt(1);
			}			
		} catch (SQLException e) {
			System.out.println("getAllBbsLength fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return len;	
	}

	@Override
	public List<PurchaseNameDto> getMainPurchaseList() {
		String sql = " SELECT ROWNUM, pur_index, mem_id, p.prd_index, m.prd_name, m.prd_model_name,pur_date,ins_date, order_num, review, order_auth "
				+ " FROM  purchase p, modellist m "
				+ " where p.prd_index = m.prd_index "
				+ " AND ROWNUM >=1 AND ROWNUM <=5 AND ORDER_AUTH = 0 "
				+ " ORDER BY PUR_DATE DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PurchaseNameDto> list = new ArrayList<PurchaseNameDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getMainPurchaseList success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getMainPurchaseList success");
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int i = 2;
				PurchaseNameDto dto = new PurchaseNameDto(
						rs.getInt(i++),//pur_index, 
						rs.getString(i++),//mem_id, 
						rs.getInt(i++),//prd_index, 
						rs.getString(i++),//prd_name, 
						rs.getString(i++),//prd_model_name, 
						rs.getString(i++),//pur_date, 
						rs.getString(i++),//ins_date, 
						rs.getInt(i++),//order_num,
						rs.getInt(i++),//review, 
						rs.getInt(i++));//order_auth)
				
				
				list.add(dto);
			}
			System.out.println("3/6 getMainPurchaseList success");
		} catch (SQLException e) {
			System.out.println("getMainPurchaseList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

	@Override
	public RentalDetailDto getReDetail(int pur_index) {
		String sql = " select r.re_index,p.pur_index, m.prd_price, m.prd_index, p.mem_id, s.mem_name, s.mem_cell, s.mem_addr1, "
				+ " s.mem_addr2, s.mem_addr3, m.prd_name, m.prd_model_name, "
				+ " p.pur_date, p.ins_date, i.comp_date , p.review, i.ins_state "
				+ " from modellist m, purchase p, members s, install i, orderreview r"
				+ " where m.prd_index = p.prd_index and p.mem_id = s.mem_id and p.pur_index = i.pur_index "
				+ " and p.pur_index=r.pur_index " 
				+ " and p.pur_index = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		RentalDetailDto dto = new RentalDetailDto();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getDetail success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getDetail success");
			
			psmt.setInt(1, pur_index);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int i = 1;
				dto = new RentalDetailDto(
										rs.getInt(i++),//re_index, 
										 rs.getInt(i++),//pur_index, 
										  rs.getInt(i++),//prd_price
										  rs.getInt(i++),//prd_index
										  rs.getString(i++),//mem_id, 
										  rs.getString(i++),//mem_name, 
										  rs.getString(i++),//mem_cell, 
										  rs.getInt(i++),//mem_addr1, 
										  rs.getString(i++),//	mem_addr2, 
										  rs.getString(i++),//	mem_addr3, 
										  rs.getString(i++),//	prd_name, 
										  rs.getString(i++),//prd_model_name, 
										  rs.getString(i++),//pur_date, 
										  rs.getString(i++),//	ins_date, 
										  rs.getString(i++),//	comp_date)
										  rs.getInt(i++),//review
										  rs.getInt(i++));//ins_state
			}
			
			
		} catch (SQLException e) {
			System.out.println("getDetail fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		return dto;
	}

	
	 

}

