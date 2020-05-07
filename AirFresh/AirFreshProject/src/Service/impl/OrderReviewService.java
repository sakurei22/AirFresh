package Service.impl;


import java.util.List;

import Dao.OrderReviewDaoInterface;
import Dao.impl.OrderReviewDao;
import Dto.ModelReviewPurDto;
import Dto.OrderReviewDto;
import Service.OrderReviewServiceInterface;

public class OrderReviewService implements OrderReviewServiceInterface {
	
	OrderReviewDaoInterface dao = new OrderReviewDao();
	@Override
	public boolean createOrderReview(String mem_id, int pur_index, int ins_index) {
		
		return dao.createOrderReview(mem_id, pur_index, ins_index);
	}
	
	/*
	 * public List<OrderReviewDto> getOrderReviewList(){
	 * 
	 * return dao.getOrderReviewList(); }
	 */


	@Override
	public boolean writeOrderReview(OrderReviewDto dto) {
		return dao.writeOrderReview(dto);
	}


	@Override
	public boolean updatePurReview(int pur_index) {
		return dao.updatePurReview(pur_index);
	}


	/*
	 * @Override public List<ModelReviewPurDto> reviewAllList() { return
	 * dao.reviewAllList(); }
	 */


	@Override
	public ModelReviewPurDto getDetailReview(int re_index) {
		return dao.getDetailReview(re_index);
	}


	@Override
	public boolean updateReadCount(int re_index) {
		return dao.updateReadCount(re_index);
	}


	@Override
	public boolean updateReview(int re_index, ModelReviewPurDto dto) {
		return dao.updateReview(re_index, dto);
	}


	@Override
	public boolean delReivew(int re_index) {
		return dao.delReivew(re_index);
	}

	@Override
	public List<ModelReviewPurDto> pagingAllList(int page) {
		return dao.pagingAllList(page);
	}

	@Override
	public int getAllReveiw() {
		return dao.getAllReveiw();
	}

	@Override
	public ModelReviewPurDto rentalListReview(String mem_id, int pur_index) {
		return dao.rentalListReview(mem_id, pur_index);
	}

	@Override
	public List<ModelReviewPurDto> getPrdReviewList(int prd_index) {
		return dao.getPrdReviewList(prd_index);
	}

	@Override
	public int prdRevewLen(int prd_index) {
		return dao.prdRevewLen(prd_index);
	}
}
