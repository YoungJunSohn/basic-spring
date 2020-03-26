package com.yj.sample;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@Getter
public class SampleHotel {
    private Chef chef;

    public SampleHotel(Chef chef){
        this.chef = chef; //Annotation 없이 생성자를 선언하고 chef를 주입합니다.
    }//SampleHotel(Chef)

}//SampleHotel
