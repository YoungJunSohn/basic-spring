package com.yj.mapper;

import com.yj.domain.BoardVO;
import com.yj.domain.Criteria;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
    //@Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();

    public void insert(BoardVO board);
    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long no);

    public int update(BoardVO board);

    /*        페이징 처리         */
    public List<BoardVO> getListWithPaging(Criteria cri);
    public int getTotalCount(Criteria cri);
}//BoardMapper
