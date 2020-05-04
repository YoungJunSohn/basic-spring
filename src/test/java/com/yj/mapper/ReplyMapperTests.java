package com.yj.mapper;

import com.yj.domain.Criteria;
import com.yj.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@Log4j2
public class ReplyMapperTests {

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;
    private Long[] bnoArr = {8126610L, 8126609L, 8126608L, 8126607L, 8126606L};


    @Test
    public void getListWithPaging(){
        Criteria cri = new Criteria(1, 5);
        List<ReplyVO> replies = mapper.getListWithPaging(cri, 8126610L);
        replies.forEach(reply->log.info(reply));
    }//getListWithPaging



    /*@Test
    public void testListWithPaging(){
        Criteria cri = new Criteria();
        List<ReplyVO> replies = mapper.getListWithPaging(cri,bnoArr[0]);
        replies.forEach(reply -> log.info(reply));

    }//testListWithPaging()*/

    @Test
    public void testUpdate(){
        //update에서는 불러올 댓글 번호를 하나 지정하고 불러온뒤, 댓글 내용을 편집합니다.
        Long targetRno = 6L; //6번 댓글을 수정합니다.
        ReplyVO reply = mapper.read(targetRno);
        reply.setReply("하핳ㅎ핳ㅎ핳 바뀌었지로옹");
        Boolean result = mapper.update(reply)==1;
        log.info("작업 결과 : " +result);
    }//testUpdate()

    @Test
    public void testDelete(){
        //testDelete 메서드에서는 댓글 번호를 하나 지정하고, mapper의 delete메서드를 통해 삭제합니다.
        Long targetRno = 2L;//2번 선택
        mapper.delete(targetRno);
    }//testDelete()

    @Test
    public void testRead(){
        //testRead 메서드에서는 댓글번호를 하나 지정하고, mapper의 메서드를 통해 불러옵니다.
        Long targetRno = 5L; //5번 선택
        ReplyVO vo = mapper.read(targetRno);

        log.info(vo);
    }//testRead()

    @Test
    public void testCreate(){
        IntStream.rangeClosed(1,10).forEach(i ->{
            ReplyVO vo = new ReplyVO();

            //게시물의 번호
            vo.setBno(bnoArr[i % 5]);
            vo.setReply("댓글 테스트 "+i);
            vo.setReplyer("유저 "+i);
            mapper.insert(vo);
        });
    }//testCreate()

    @Test
    public void testMapper(){
        log.info(mapper);//mapper객체가 만들어지는지 확인
    }//testMapper()



}//ReplyMapperTests
