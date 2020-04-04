package com.yj.controller;

import com.yj.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board/*")
public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model){
        //Model 객체는 게시물을 목록을 전달하는 파라미터로 지정되고,
        // 이를 통해 BoardServiceImpl 객체의 GetList 결과를 담아 전달합니다.
        log.info("list입니다.");
        model.addAttribute("list", service.getList());
    }//list(Model)
}//BoardController
