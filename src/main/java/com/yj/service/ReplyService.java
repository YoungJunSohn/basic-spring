package com.yj.service;

import com.yj.domain.Criteria;
import com.yj.domain.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {
    public int register(ReplyVO vo);
    public ReplyVO get(Long rno);
    public int modify(ReplyVO vo);
    public int remove(Long rno);

    public List<ReplyVO> getList(Criteria cri, Long bno);
}//ReplyService
