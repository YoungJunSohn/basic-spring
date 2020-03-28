package com.yj.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDTOList {
    private List<SampleDTO> list;

    public SampleDTOList(){
        list = new ArrayList<>();
    }//SampleDTOList()
}//SampleDTOList

//여러개의 객체를 한번에 처리해야할 때 객체 리스트 타입의 클래스를 설계합니다.