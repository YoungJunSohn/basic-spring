package com.yj.controller;

import com.yj.domain.SampleDTO;
import com.yj.domain.SampleDTOList;
import com.yj.domain.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/*@Controller 와 @RequestMapping 을 식별하여 HandlerMapping 이 생성됩니다. >> MappingRegistry 에 보관*/
@Controller
@RequestMapping("/sample/*") //이제 /sample/aaa 와 같은 주소의 접근이 가능합니다.
@Log4j2
public class SampleController {

    @RequestMapping("")
    public void basic(){
        System.out.println("sampleController :  시스템 로그입니다.");
        log.info("sampleController : basic 입니다.");
    }//basic()

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet(){
        log.info("sampleController : basicGet()입니다.");

//          @RequestMapping은 method 방식을 GET, POST, PUT, DELETE 모두 설정할 수 있습니다.
//          간편하게 하나로 사용하고 싶을 때는 @GetMapping 과 같은 방식으로 사용합니다.
//
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
    }//ex02(String name, int age)


    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids){
        log.info("ex02List page //ids : "+ ids);
        return "ex02List";
    }//ex02List(ArrayList<String>)

    @GetMapping("ex02Array")
    public String ex02Array(@RequestParam("param") String[] param){
        log.info("ex02Array page //param : "+ Arrays.toString(param));
        return "ex02Array";
    }//ex02Array(String[])

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list){
        log.info("ex02Bean // list : " +list);
        return "ex02Bean";
    }//ex02Bean(SampleDTOList)
    /* /sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb 로 접근하는 경우
    INFO  com.yj.controller.SampleController - ex02Bean //
    list : SampleDTOList(list=[SampleDTO(name=aaa, age=0),
    SampleDTO(name=null, age=0),
    SampleDTO(name=bbb, age=0)]  와 같이 출력됩니다. > List[0]과 List[2]만 채워줄 경우 List[1]은 null인 상태로 생성)
*/

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(dateFormat,false));
    }//initBinder(WebDataBinder)
    @GetMapping("/ex03")
    public String ex03(TodoDTO todoDTO){
        log.info("todoDTO : "+todoDTO);
        return "ex03";
    }//ex03(TodoDTO)

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto,@ModelAttribute("page") int page){
        log.info("dto : "+dto);//String name,int age

        log.info("page : "+page);
        return "/sample/ex04";
    }//ex04(SampleDTO, int)
}//SampleController










