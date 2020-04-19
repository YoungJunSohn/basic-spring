package com.yj.service;

import com.yj.domain.BoardVO;
import com.yj.domain.Criteria;
import com.yj.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("게시글을 등록합니다 : "+board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("read 메서드를 실행합니다.");
        return mapper.read(bno);
    }
    @Override
    public boolean modify(BoardVO board) {
        log.info(board.getBno()+"번 글을 수정합니다.");
        return mapper.update(board)==1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info(bno+"번 글을 삭제합니다.");
        return mapper.delete(bno)==1; //삭제가 완료될 경우 1이 넘어오므로 비교해서 같으면 true(삭제완료)
    }

    @Override
    public List<BoardVO> getList() {
        //log.info("리스트를 세팅합니다(serviceImpl)");
        return mapper.getList();
    }

    //페이징 처리
    @Override
    public List<BoardVO> getList(Criteria cri){
        log.info("페이징 처리정보 :"+cri);
        return mapper.getListWithPaging(cri);
    }//getList(Criteria cri)
    @Override
    public int getTotal(Criteria cri){
        log.info("총 페이지 수를 가져옵니다.");
        return mapper.getTotalCount(cri);
    }//getTotal(cri)
}//BoardServiceImpl
