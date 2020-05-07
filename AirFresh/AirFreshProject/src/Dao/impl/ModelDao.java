package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ModelDaoInterface;
import Dto.ModelDto;
import db.DBClose;
import db.DBConnection;

public class ModelDao implements ModelDaoInterface {
	
	public ModelDao() {
		DBConnection.initConnection();
	}
	
	public List<ModelDto> getModelPagingList(int page) {
		String sql = " SELECT PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE "
				+ " FROM "
				+ " ( SELECT ROW_NUMBER()OVER(ORDER BY PRD_INDEX DESC ) AS RNUM,"
				+ " PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE "
				+ " FROM MODELLIST ) "
				+ " WHERE RNUM>= ? AND RNUM <= ? ";
		
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<ModelDto> list = new ArrayList<ModelDto>();
		
		int start,end;
		
		start = 1 + 6 * page;
		end = 6 + 6 * page;
		System.out.println("들어온 page: "+page);
		 
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getModelPagingList success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getModelPagingList success");
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getModelPagingList success");
			while(rs.next()) {
				int i = 1;
				ModelDto model = new ModelDto(rs.getInt(i++), 
						  rs.getString(i++), 
						  rs.getString(i++), 
					      rs.getInt(i++));
				list.add(model);
			}
			
		} catch (SQLException e) {
			System.out.println("getModelPagingList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list; 
		
	}
	
	public int getAllPrd() {
		//상품갯수 구하는 함수
		String sql =  " SELECT COUNT(*) FROM MODELLIST ";
		
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
			System.out.println("getAllPrd fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return len;
	}
	
	
	@Override
	public List<ModelDto> getModelList() {
		String sql = " SELECT * FROM MODELLIST ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<ModelDto> list = new ArrayList<ModelDto>();
		
		try {
			
			conn = DBConnection.getConnection();
			System.out.println("1/4 getModelList s");

			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 getModelList s");

			rs = psmt.executeQuery();
			System.out.println("3/4 getModelList s");
			
			while(rs.next()) {
				int i = 1;
				
				ModelDto model = new ModelDto(rs.getInt(i++), 
											  rs.getString(i++), 
											  rs.getString(i++), 
										      rs.getInt(i++));
				list.add(model);
			}
			
			System.out.println("4/4 getModelList s");
		} catch (SQLException e) {
			
			System.out.println("getModelList f");				
			e.printStackTrace();
			
		} finally {
			DBClose.close(psmt, conn, rs);
			
		}
		
	return list;
	}

	@Override
	public ModelDto getModelDetail(int prd_index) {
		String sql =  " SELECT PRD_INDEX, PRD_NAME, PRD_MODEL_NAME, PRD_PRICE "
				+ " FROM MODELLIST "
				+ " WHERE PRD_INDEX=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ModelDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getModelDetail success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getModelDetail success");
			
			psmt.setInt(1, prd_index);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int i=1;
				dto = new ModelDto(rs.getInt(i++),//prd_index, 
								   rs.getString(i++),//prd_name, 
								   rs.getString(i++),//prd_model_name, 
								   rs.getInt(i++));//prd_price)
				
			}
			
			System.out.println("3/6 getModelDetail success");
		} catch (SQLException e) {
			System.out.println("getModelDetail fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return dto;
	}

}
