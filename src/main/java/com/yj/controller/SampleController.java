package com.yj.controller;

import com.yj.domain.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*@Controller 와 @RequestMapping 을 식별하여 HandlerMapping 이 생성됩니다. >> MappingRegistry 에 보관*/
@Controller
@RequestMapping("/sample/*") //이제 /sample/aaa와 같은 경로의 페이지에 접근이 가능합니다.
@Log4j2
public class SampleController {

    @RequestMapping("")
    public String basic(){
        System.out.println("sampleController :  시스템 로그입니다.");
        log.info("sampleController : basic 입니다.");
        return "index";
    }//basic()

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet(){
        log.info("sampleController : basicGet()입니다.");
        /*
        * @RequestMapping은 method 방식을 GET, POST, PUT, DELETE 모두 설정할 수 있습니다.
        * 간편하게 하나로 사용하고 싶을 때는 @GetMapping 과 같은 방식으로 사용합니다.
        * */
    }//basicGet()

    @GetMapping("/basicOnlyGet")
    public void basicGet2(){
        log.info("sampleController : basicGet2() 입니다.");
    }//basicGet2()

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        log.info(""+dto);
        return "ex01";
    }//ex01(SampleDTO dto)

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age){
            log.info("name: "+name);
            log.info("age: "+age);
        return "ex02";
    }//ex02()
}//SampleController
