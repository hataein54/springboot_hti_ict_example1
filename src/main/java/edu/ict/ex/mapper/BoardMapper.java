package edu.ict.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.BoardVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface BoardMapper {
	public List<BoardVO> getList();
	BoardVO read(int bno);
	
	//게시판 삭제 == 삭제된 갯수 리턴
	int delete(int bno);
	
	//게시판 insert
	int insertBoard(@Param("board") BoardVO boardVO);
	
	//게시판 update
	int updateBoard(BoardVO boardVO);
	
	//히트수
	int upHit(BoardVO boardVO);
	
	//댓글 관련
	public void updateShape(BoardVO boardVO);		
	public void insertReply(BoardVO boardVO);
	
	//페이징 관련
	int getTotalCount();
	List<BoardVO> getListWithPaging(Criteria cri);
}
