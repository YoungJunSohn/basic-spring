package com.yj.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/restSample")
@Log4j2
public class RestSampleController {

    @GetMapping(value = "/getText", produces = "text/plain;charset=UTF-8")
    public String getText(){
/*
* 기존의 @Controller 는 문자열을 반환하는 경우, JSP 파일 이름으로 반환하지만,
* @RestController 의 경우에는 순수한 데이터가 반환된다는 점에 주의!!
*
* @GetMapping 내부 속성  produces 는 해당 메서드가 생산하는 MIME 타입을 의미합니다!!
* */
        log.info("MIME TYPE :"+ MediaType.TEXT_PLAIN_VALUE);
        return "안녕하세요";
    }//getText()
}//RestSampleController
