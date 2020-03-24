package com.youngjun.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Controller 와 @RequestMapping 을 식별하여 HandlerMapping 이 생성됩니다. >> MappingRegistry 에 보관*/
@Controller
@RequestMapping("/sample/*") //이제 /sample/aaa와 같은 경로의 페이지에 접근이 가능합니다.
@Log4j2
public class SampleController {

    @RequestMapping("")
    public void basic(){ log.info("sampleController:basic 페이지입니다."); }//basic()

}//SampleController
