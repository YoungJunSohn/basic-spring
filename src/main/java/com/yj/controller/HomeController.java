package com.yj.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@Log4j2
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        log.info("Welcome Home!!! The client locale is {}.",locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime",formattedDate);
        return "home";
    }//home()

    /*
    @RequestMapping 의 value 값은 브라우저에서 클라이언트가 요청할 주소를 나타냅니다.
    Controller 내부의 메서드가 return 하는 값이 String 형일 경우, 접근하는 곳이
    [WEB-INF/views/ directory 내부의 JSP 파일 이름 ]임을 뜻합니다. 해당하는 JSP 파일이 존재하지 않는 경우
    브라우저는 요청에 대한 응답을 받지 못하고, 따라서 404 에러가 발생합니다.
    */
}//HomeController
