package Service;

import java.util.List;

import Dto.PurchaseDto;
import Dto.PurchaseNameDto;
import Dto.RentalDetailDto;

public interface PurchaseServiceInterface {

	//구매하기 눌렀을때
	boolean purchaseInsert(String mem_id, int prd_index, String ins_date);
	
	//구매취소 눌렀을때 == 구매테이블 index
	boolean purchaseDelete(int pur_index);
	
	//구매 전체 list보기
	//List<PurchaseDto> getPurchaseList();
	List<PurchaseNameDto> getPurchaseList();
	public int getlength();
	//관리자
	List<PurchaseNameDto> getModelName(int pageNumber);
	
	//회원별 구매 list 보기
	//List<PurchaseDto> memPurchaseList(String mem_id);
	List<PurchaseNameDto> memPurchaseList(String mem_id);
	
	 //구매 상세 dto 보기
	RentalDetailDto getDetailDto(int pur_index);
	
	public RentalDetailDto getReDetail(int pur_index);
	
   //model name뽑아오기
    List<PurchaseNameDto> getModelName(String mem_id);
    
    //INSTALL 생성을 위한 직전에 생성된 제품구매 데이터의  FK 값 가져오는 함수 
    public PurchaseDto getNewCreate_Pur();
    
    //회원이 렌탈(구매)를 했는지 안했는지 판단하는 메소드 
    public boolean userPurConfirm(String userID);
    
    public List<PurchaseNameDto> getMainPurchaseList();
}
