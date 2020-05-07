package Service;

import java.io.Serializable;
import java.util.List;

import Dto.ModelReviewPurDto;
import Dto.OrderReviewDto;

public interface OrderReviewServiceInterface extends Serializable {

	public boolean createOrderReview(String mem_id, int pur_index, int ins_index);

	//public List<OrderReviewDto> getOrderReviewList();

	// 리뷰작성
	boolean writeOrderReview(OrderReviewDto dto);

	// 리뷰작성하면 구매테이블 review 1로바꿔줌
	boolean updatePurReview(int pur_index);

	// 전체 리뷰 list
	//List<ModelReviewPurDto> reviewAllList();
	List<ModelReviewPurDto> pagingAllList(int page);
		
	int getAllReveiw();

	// review detail
	ModelReviewPurDto getDetailReview(int re_index);

	// 조회수 update
	boolean updateReadCount(int re_index);

	// 리뷰수정
	boolean updateReview(int re_index, ModelReviewPurDto dto);

	// 리뷰삭제
	boolean delReivew(int re_index);
	
	//구매내역에서 작성한 review detail
	ModelReviewPurDto rentalListReview(String mem_id, int pur_index);
	
	//해당 상품 리뷰 페이징
	List<ModelReviewPurDto> getPrdReviewList(int prd_index);
		
	//해당 상품 리뷰 전체게시글수
	int prdRevewLen(int prd_index);
}
