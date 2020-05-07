package Service.impl;

import java.util.List;

import Dao.AsDaoInterface;
import Dao.impl.AsDao;
import Dto.AsAppDto;
import Service.AsServiceInterface;

public class AsService implements AsServiceInterface {
	AsDaoInterface dao = new AsDao();

	@Override
	public boolean addAsApplictaion(AsAppDto dto) {
		return dao.addAsApplictaion(dto);
	}

	@Override
	public List<AsAppDto> getAsAll() {
		return dao.getAsAll();
	}

	@Override
	public AsAppDto getDetailAs(int as_index) {
		return dao.getDetailAs(as_index);
	}

	@Override
	public boolean updateAsApp(int as_index,AsAppDto dto) {
		return dao.updateAsApp(as_index, dto);
	}

	@Override
	public boolean deleteAsApp(int as_index) {
		return dao.deleteAsApp(as_index);
	}

	@Override
	public List<AsAppDto> memAsAppList(String mem_id) {
		return dao.memAsAppList(mem_id);
	}
	


}
