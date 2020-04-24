package com.yj.mapper;

import com.yj.domain.ReplyVO;

public interface ReplyMapper {
// CRUD 작성
    public int insert(ReplyVO vo);
    public ReplyVO read(Long rno);
    public int delete(Long rno);
    public int update(ReplyVO reply);

}//ReplyMapper
