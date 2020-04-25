package com.yj.controller;

import com.sun.istack.internal.NotNull;
import com.yj.domain.Criteria;
import com.yj.domain.ReplyVO;
import com.yj.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Rest 방식을 이용하여 작성합니다.
@RequestMapping("/replies/*")
@Log4j2
@AllArgsConstructor//setter 주입을 사용해도 되지만, 생성자 주입으로 의존성을 부여하였습니다.
public class ReplyController {
    private ReplyService service;

    //댓글 등록 : 브라우저에는 json 타입의 댓글 데이터를 전송하고, 서버에서는 문자열 처리결과 출력
    @PostMapping(value = "/new",
            consumes = "application/json",//데이터 처리정보
            produces = {MediaType.TEXT_PLAIN_VALUE})//반환정보
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        log.info("ReplyVO :" + vo);

        int insertCount = service.register(vo);
        if (insertCount == 1) {
            log.info("성공적으로 댓글이 입력되었습니다.");
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            log.info("댓글 입력이 실패하였습니다.");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }//if~else
    }

    ;//create()


    @GetMapping(value = "/pages/{bno}/{page}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno,
                                                 @PathVariable("page") int page) {
        log.info("리스트 페이지입니다.");
        Criteria cri = new Criteria(page, 10);
        log.info("cri 객체 : " + cri);

        return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
    }//getList()


    @GetMapping(value = "/{rno}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
        log.info(rno + "번 댓글을 출력합니다.");

        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }//get()


    @DeleteMapping(
            value = "/{rno}",
            produces = {
                    MediaType.TEXT_PLAIN_VALUE
            })
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        log.info(rno + "번 댓글 삭제를 준비중입니다.");
        return service.remove(rno) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//삼항 연산자 처리
    }//remove()


    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
            value = "/{rno}",
            consumes = "application/json",
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@PathVariable("rno") Long rno,
                                         @RequestBody ReplyVO vo) {
        vo.setRno(rno);
        log.info(rno+"번 댓글 수정을 준비중입니다.");
        log.info("수정할 댓글 정보 : "+vo);
        return service.modify(vo)==1
                ? new ResponseEntity<>("success",HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }//modify()
}//ReplyController
