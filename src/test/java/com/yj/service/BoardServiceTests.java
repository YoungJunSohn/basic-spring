package com.yj.service;

import com.yj.domain.BoardVO;
import com.yj.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class BoardServiceTests {
    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

    @Test
    public void testExist(){
        //test1 : boardService 객체가 주입이 가능한지 확인합니다.
//        log.info(boardService);//test1
//        assertNotNull(boardService);//test1

    }//testExist()
    @Test
    public void testRegister(){
//        test2: 게시글 작성 테스트입니다.
        /*BoardVO board = new BoardVO();
        board.setTitle("새글 제목입니다.");
        board.setContent("새글 내용입니다.");
        board.setWriter("user02");

        boardService.register(board);
        log.info("생성된 게시물의 번호 : "+board.getBno());*/
    }//testRegister()

    @Test
    public void getList(){
//        boardService.getList().forEach(board->log.info(board));
    }//getList()

    @Test
    public void getOne(){
        //boardService.get(2L);
    }//getOne()

    @Test
    public void remove(){
        //boardService.remove(2L);
    }//remove()

    @Test
    public void modify(){
        Long no = 4L;

        BoardVO board = boardService.get(no);

        if(board!=null){
            board.setTitle("asjdflkasjdfl;asdjf");
            board.setContent("asdfqwefqwekjlsdanfa");
            board.setWriter("user04");
            boardService.modify(board);
            log.info("수정 완료!"+boardService.get(no));
        }//if()

    }//modify()
}//BoardServiceTests

