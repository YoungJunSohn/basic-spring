package com.yj.service;

import com.yj.domain.BoardVO;
import com.yj.domain.Criteria;

import java.util.List;

public interface BoardService {
    public void register(BoardVO board);
    public BoardVO get(Long bno);
    public boolean modify(BoardVO board);
    public boolean remove(Long bno);

    public List<BoardVO> getList();

    //paging처리
    public List<BoardVO> getList(Criteria cri);
    public int getTotal(Criteria cri);
}//BoardService
