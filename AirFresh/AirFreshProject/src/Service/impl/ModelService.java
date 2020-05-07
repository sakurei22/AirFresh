package Service.impl;

import java.util.List;

import Dao.ModelDaoInterface;
import Dao.impl.ModelDao;
import Dto.ModelDto;
import Service.ModelServiceInterface;

public class ModelService implements ModelServiceInterface {
	
	ModelDaoInterface mdi = new ModelDao();
	
	@Override
	public List<ModelDto> getModelList() {
		return mdi.getModelList();
	}

	@Override
	public ModelDto getModelDetail(int prd_index) {
		return mdi.getModelDetail(prd_index);
	}

	@Override
	public List<ModelDto> getModelPagingList(int page) {
		return mdi.getModelPagingList(page);
	}

	@Override
	public int getAllPrd() {
		return mdi.getAllPrd();
	}

}
