package com.yj.controller;

import com.sun.istack.internal.NotNull;
import com.yj.domain.BoardVO;
import com.yj.domain.Criteria;
import com.yj.domain.PageDTO;
import com.yj.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor//생성자를 자동으로 생성시켜 주는 Lombok annotation입니다. 없을 시 @Notnull 작동 x
public class BoardController {
    private BoardService service;

    /* 04/12  페이징처리된 리스트를 화면에 출력 */
    @GetMapping("/list")
    public void list(Model model, Criteria cri){
        log.info("페이징 정보를 받아 리스트를 출력합니다. :"+cri);
        model.addAttribute("list",service.getList(cri));

        int total = service.getTotal(cri);
        log.info("total 페이지 :"+total);
        //PageDTO를 사용할 수 있도록 pageMaker 라는 이름으로 객체를 만들어서 model에 담아줍니다.
        model.addAttribute("pageMaker",new PageDTO(cri,total));
    }//list(model, cri)

    /*@GetMapping("/list")
    public void list(@NotNull Model model){
        //Model 객체는 게시물을 목록을 전달하는 파라미터로 지정되고,
        // 이를 통해 BoardServiceImpl 객체의 GetList 결과를 담아 전달합니다.
        //log.info("list입니다.");
        model.addAttribute("list", service.getList());
    }//list(Model) get*/

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr){
        log.info("등록(post) 접근 확인 됨, : "+board);
        service.register(board);
        rttr.addFlashAttribute("result",board.getBno());
        return "redirect:/board/list";//글 등록 후 리다이렉트 이동으로 board list를 출력합니다.
    }//register() post

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam(value = "bno") Long bno,
                    @ModelAttribute("cri") Criteria cri, Model model){

        //@RequestParam을 지정할 경우, 파라미터가 존재하지 않을 때 에러가 발생합니다.
        model.addAttribute("board",service.get(bno));

        int total = service.getTotal(cri);
        model.addAttribute("pageMaker",new PageDTO(cri,total));
    }//get() get

    @PostMapping("/modify")
    public String modify(BoardVO board,
                         RedirectAttributes rttr,
                         @ModelAttribute("cri") Criteria cri){

        //log.info("글 수정 메서드 접근 완료 , 현재 board객체 : "+board);

        if(service.modify(board)){
            rttr.addFlashAttribute("result","success");
        }//if()

        rttr.addFlashAttribute("pageNum", cri.getPageNum());
        rttr.addFlashAttribute("amount", cri.getAmount());
        rttr.addFlashAttribute("type", cri.getType());
        rttr.addFlashAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list";
    }//modify() post


    @PostMapping("/remove")
    //public String delete(Long bno, RedirectAttributes rttr){
    public String delete(@RequestParam("bno") Long bno,
                         @ModelAttribute("cri") Criteria cri,
                         RedirectAttributes rttr){
// 04/13 삭제 메서드 작동 방식 변경 > cri를 받아서 삭제
        if(service.remove(bno)){
            log.info("delete 메서드가 작동합니다."+bno+"번 글이 삭제됩니다.");
            rttr.addFlashAttribute("result", "success");
        }//if()
        rttr.addFlashAttribute("pageNum",cri.getPageNum());
        rttr.addFlashAttribute("amount",cri.getAmount());
        rttr.addFlashAttribute("type", cri.getType());
        rttr.addFlashAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list";
    }//delete() post

    /*         bootstrap 적용 후            */
    @GetMapping("/register")
    public void register(){
        //그저 입력 페이지를 연결해주는 역할이기에 비즈니스 로직이 필요하지 않다고 판단.
    }//register() get


}//BoardController
