package com.yj.service;

import com.yj.domain.Criteria;
import com.yj.domain.ReplyVO;
import com.yj.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ReplyServiceImpl implements ReplyService{
    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Override
    public int register(ReplyVO vo) {
        log.info("댓글을 등록합니다 :"+vo);
        return mapper.insert(vo);
    }//register

    @Override
    public ReplyVO get(Long rno) {
        log.info(rno+"번의 댓글을 출력합니다");
        return mapper.read(rno);
    }//get

    @Override
    public int modify(ReplyVO vo) {
        log.info(vo.getRno()+"번 댓글을 수정합니다. :" +vo);
        return mapper.update(vo);
    }//modify

    @Override
    public int remove(Long rno) {
        log.info(rno+"번 댓글을 삭제합니다.");
        return mapper.delete(rno);
    }//remove

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        log.info(bno+"번 글의 댓글 목록을 출력합니다.");
        return mapper.getList(cri, bno);
    }//getList

    @Override
    public List<ReplyVO> getListWithPaging(Criteria cri, Long bno) {
        log.info(bno+"번 글의 댓글 목록을 출력합니다.");
        return mapper.getListWithPaging(cri, bno);
    }
}//ReplyServiceImpl
