package com.yj.mapper;

import com.yj.domain.BoardVO;
import com.yj.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@Log4j2
public class BoardMapperTests {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList(){
//        mapper.getList().forEach(board ->log.info(board) );
    };

    @Test
    public void testInsert(){
        /*BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        //mapper.insert(board);
        mapper.insertSelectKey(board);
        log.info(board);*/
    }//testInsert()

    @Test
    public void testRead(){
        //게시물 번호로 불러오는 게시물 정보
        //warning! -- 게시물 번호가 존재하는지 반드시 그 여부를 확인해야 합니다.
        /*BoardVO board = mapper.read(5L);
        log.info(board);*/
    }//testRead()

    @Test
    public void testDelete(){
        log.info("Delete 구문이 실행되었습니다 : " +mapper.delete(3L));
    }//testDelete()

    @Test
    public void testUpdate(){
        /*Long num = 5L;
        BoardVO board = new BoardVO();//데이터를 객체형식으로 넘기기위해서 생성합니다.
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user01");
        //실행전 해당 글 번호가 데이터베이스에 존재하는지 확인해야합니다.
        board.setBno(num);

        int count = mapper.update(board);
        log.info("Update 구문 실행 : "+num+"번 글을 수정합니다. ->"+count);*/
    }//testUpdate()

    @Test
    public void testPaging(){
        /*Criteria cri = new Criteria();

        List<BoardVO> list = mapper.getListWithPaging(cri);

        list.forEach(board ->log.info(board));*/
    }//testPaging


    //검색 테스트
    @Test
    public void testSearch(){
        Criteria cri = new Criteria();
        cri.setKeyword("새로");
        cri.setType("TC");

        List<BoardVO> list = mapper.getListWithPaging(cri);
        list.forEach(board-> log.info(board));
    }//testSearch()
}//BoardMapperTests()

/*
* 작동 순서
* 1. mapper interface 에서 메서드를 만듭니다.
* 2. mapper.xml에서 sql 구문을 작성합니다.
* 3. 작성된 Context를 Spring에서 읽을 수 있도록 applicationContext에 bean 등록합니다.(context:component-scan)
* 4. 오류가 없는지 테스트 클래스에서 작동시킵니다.
* */