package com.yj.domain;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
    private int startPage; //시작페이지번호
    private int endPage;//끝페이지번호
    private boolean prev, next;

    private int total; //전체 게시글 수
    private Criteria cri; //현재페이지번호와 페이지당 보여줄 게시글 수

    public PageDTO(Criteria cri, int total){
        this.cri = cri;
        this.total = total;

        /*페이지 번호 수는 한페이지에 10개를 출력하는 기준으로 작성됩니다.
        1. 끝 페이지를 먼저 계산합니다
        - 현재 페이지번호를 받아온 뒤, 올림처리하여 현재 11페이지인 경우 20페이지까지 출력해야합니다.
        - 시작페이지번호는 끝페이지번호를 기준으로 몇번째인지 계산합니다 (10개를 보여주므로 - 9)
        */
        this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
        this.startPage = this.endPage - 9;

        int realEnd = (int)(Math.ceil(total * 1.0) / cri.getAmount());

        if (realEnd < this.endPage){
            this.endPage = realEnd;
        }//if()

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }//PageDTO(cri, total)
}//pageDTO
