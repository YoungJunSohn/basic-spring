package com.yj.controller;

import com.sun.istack.internal.NotNull;
import com.yj.domain.BoardVO;
import com.yj.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor//생성자를 자동으로 생성시켜 주는 Lombok annotation입니다. 없을 시 @Notnull 작동 x
public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(@NotNull Model model){
        //Model 객체는 게시물을 목록을 전달하는 파라미터로 지정되고,
        // 이를 통해 BoardServiceImpl 객체의 GetList 결과를 담아 전달합니다.
        //log.info("list입니다.");
        model.addAttribute("list", service.getList());
    }//list(Model) get

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr){
        log.info("등록(post) 접근 확인 됨, : "+board);
        service.register(board);
        rttr.addFlashAttribute("result",board.getBno());
        return "redirect:/board/list";//글 등록 후 리다이렉트 이동으로 board list를 출력합니다.
    }//register() post

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno") Long bno, Model model){
        model.addAttribute("board",service.get(bno));
    }//get() get

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr){
        log.info("글 수정 메서드 접근 완료 , 현재 board객체 : "+board);

        if(service.modify(board)){
            rttr.addFlashAttribute("result","success");
        }//if()
        return "redirect:/board/list";
    }//modify() post


    @PostMapping("/remove")
    public String delete(Long bno, RedirectAttributes rttr){
        if(service.remove(bno)){
            log.info("remove 메서드가 작동합니다."+bno+"번 글이 삭제됩니다.");
            rttr.addFlashAttribute("result", "success");
        }//if()
        return "redirect:/board/list";
    }//delete() post

    /*         bootstrap 적용 후            */
    @GetMapping("/register")
    public void register(){
        //그저 입력 페이지를 연결해주는 역할이기에 비즈니스 로직이 필요하지 않다고 판단.
    }//register() get


}//BoardController
