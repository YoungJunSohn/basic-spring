package com.yj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria{
    //페이징 처리 및 검색을 위한 클래스입니다
    private int pageNum;//페이지 번호
    private int amount;//페이지당 보여줄 글 수

    private String type;//검색 조건
    private String keyword;//검색에 사용할 키워드

    public Criteria() {
        this(1, 10); //amount개씩 pageNum번 페이지를 보여줍니다.
    }//Criteria()

    public Criteria(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }//Criteria(pageNum, amount)


    public String[] getTypeArr(){
//검색 조건을 배열로 만들어서 한번에 처리하기 위해서 생성 이렇게 만들면 getTypeArr() 을 이용하여 동적태그 활용가능
        String[] result = type == null ? new String[]{} : type.split("");

        return result;
    }//getTypeArr()
}//Criteria
