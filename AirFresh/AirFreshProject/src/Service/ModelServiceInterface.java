package Service;

import java.util.List;

import Dto.ModelDto;

public interface ModelServiceInterface {
	int getAllPrd();
	List<ModelDto> getModelList();
	List<ModelDto> getModelPagingList(int page);
	ModelDto getModelDetail(int prd_index);
}
