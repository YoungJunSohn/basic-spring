package com.yj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter //댓글 페이징 처리에는 댓글 목록 + 댓글의 수가 있어야 하므로 DTO를 구성합니다.
public class ReplyPageDTO {

    private int replyCnt; //댓글의 수
    private List<ReplyVO> list; // 댓글목록

}//ReplyPageDTO
