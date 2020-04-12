package com.yj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
    //페이징 처리를 위한 클래스입니다 (pageNum:페이지 번호, amount: 페이지당 보여줄 글 수)
    private int pageNum;
    private int amount;

    public Criteria() {
        this(3, 10); //amount개씩 pageNum번 페이지를 보여줍니다.
    }//Criteria()

    public Criteria(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }//Criteria(pageNum, amount)

}//Criteria
