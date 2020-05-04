package com.yj.mapper;

import com.yj.domain.Criteria;
import com.yj.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
// CRUD 작성
    public int insert(ReplyVO vo);
    public ReplyVO read(Long rno);
    public int delete(Long rno);
    public int update(ReplyVO reply);

    public List<ReplyVO> getList(
            @Param("cri")Criteria cri,
            @Param("bno")Long bno
            );//getList

    public List<ReplyVO> getListWithPaging(
            @Param("cri")Criteria cri,
            @Param("bno")Long bno
    );//getListWithPaging

    public int getCountByBno(Long bno);
}//ReplyMapper
