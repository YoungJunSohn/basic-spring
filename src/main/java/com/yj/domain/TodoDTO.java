package com.yj.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TodoDTO {
    private String title;
    private Date dueDate;
    /*
    만일 멤버필드 dueDate 에 '2020-03-29' 와 같은 데이터를 받아 변환하고자 하면, 자료형이 다르므로 문제가 발생합니다.
    이를 해결하기 위해서 @InitBinder 를 사용합니다.
     */
}//TodoDTO
