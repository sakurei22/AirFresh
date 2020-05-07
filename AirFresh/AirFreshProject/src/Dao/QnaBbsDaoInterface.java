package Dao;

import java.util.List;

import Dto.QnaBbsDto;

public interface QnaBbsDaoInterface {
	List<QnaBbsDto> getQnalist();
	List<QnaBbsDto> getQnaPaging(String opt, String keyword, int page);
	public int getAllQnaLength(String opt, String keyword);
	public boolean addQna(QnaBbsDto qna);
	public QnaBbsDto getQnaBbs(int qna_index);
	//public QnaBbsDto getPersonalQna(String mem_id);
	public boolean reComentQna(int qna_index, String re_content);
	public boolean userUpdate(QnaBbsDto qna);
	public boolean adminUpdate(int qna_index, int qna_secret);
	public boolean qnaDelete(int qna_index);
}
