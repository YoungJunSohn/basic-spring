package com.yj.controller;

import com.yj.domain.SampleVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RestController
@RequestMapping("/restSample")
@Log4j2
public class RestSampleController {

    @GetMapping(value = "/getText", produces = "text/plain;charset=UTF-8")
    public String getText(){
/*
* 기존의 @Controller 는 문자열을 반환하는 경우, JSP 파일 이름으로 반환하지만,
* @RestController 의 경우에는 순수한 데이터가 반환된다는 점에 주의!!
*
* @GetMapping 내부 속성  produces 는 해당 메서드가 생산하는 MIME 타입을 의미합니다!!
* */
        log.info("MIME TYPE :"+ MediaType.TEXT_PLAIN_VALUE);
        return "안녕하세요";
    }//getText()


    @GetMapping(value = "/getSample",
                produces = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE})//json타입과 xml타입을 사용합니다.(생략 가능)
    public SampleVO getSample(){
        return new SampleVO(1, "영준","손");
    }//getSample()

    @GetMapping(value = "/getSample2")
    public SampleVO getSample2() {
        return new SampleVO(2, "영진","손");
    }//getSample2()

    @GetMapping(value = "/getRestList")
    public List<SampleVO> getList(){
        return IntStream
                .range(1,10)
                .mapToObj(i -> new SampleVO(i, i+"First", i+"Last"))
                .collect(Collectors.toList());
    }//getList()

    @GetMapping(value = "/getMap")
    public Map<String, SampleVO> getMap(){
        Map<String, SampleVO> result = new HashMap<>();

        //Map을 이용하는 경우 key 값이 XML 태그로 변환되기 때문에 문자열형을 사용합니다.
        result.put("First", new SampleVO(3,"해서웨이", "앤"));
        return result;
    }//getMap()

    @GetMapping(value = "/check", params = {"height", "weight"})
    public ResponseEntity<SampleVO> check(Double height, Double weight){
        SampleVO vo = new SampleVO(0,""+height, ""+weight);
        ResponseEntity<SampleVO> result = null;

        if(height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);//150보다 작을경우 502에러
        }else{
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
        }//if~else

        return result;
    }//check()
}//RestSampleController
