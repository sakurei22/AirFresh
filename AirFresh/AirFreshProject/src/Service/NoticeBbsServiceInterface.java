package Service;

import java.util.List;

import Dto.NoticeBbsDto;

public interface NoticeBbsServiceInterface {
	public List<NoticeBbsDto> getNoticeList();
	public boolean writeNotice(NoticeBbsDto notice);
	public NoticeBbsDto getNoticeBbs(int noti_index);
	public void readcount(int noti_index);
	public List<NoticeBbsDto> getNoticeList(String opt, String keyword);
	public List<NoticeBbsDto> getNoticePaging(String opt, String keyword, int page);
	public List<NoticeBbsDto> getNoticeUser(String opt, String keyword, int page); // user검색+페이징
	public int getAllBbsLength(String opt, String keyword);
	public int getUserLength(String opt, String keyword);  //공지사항 사용자 전체 갯수 
	public boolean deleteNotice(int noti_index);
	public boolean multiDelNotice(String[] noticeIndex);
	public boolean updateNotice(int noti_index, NoticeBbsDto notice);
}
