package Dao;

import java.util.List;

import Dto.ModelDto;

public interface ModelDaoInterface {
	//전체 상품갯수구하기
	int getAllPrd();
	
	List<ModelDto> getModelList();
	
	//상품 list paging
	List<ModelDto> getModelPagingList(int page);
	
	//상품 디테일
	ModelDto getModelDetail(int prd_index);
}
