package com.yj.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;
}//BoardVO

//Lombok의 @Data를 이용하여 getter/setter, toString 등을 생성합니다.
