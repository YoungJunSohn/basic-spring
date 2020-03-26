package com.yj.persistence;

import com.yj.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j2
public class TimeMapperTests {
    @Setter(onMethod_ = @Autowired)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime(){
        log.info(timeMapper.getClass().getName()); //실제 동작하는 class의 이름을 출력합니다.
        //현재 Interface만 제작하였으나, 실제로는 proxy 클래스가 작동하여 TimeMapper 클래스를 이용할 수 있습니다.
        log.info(timeMapper.getTime()); //현재 시작을 출력합니다.
        log.info("TimeMapper 클래스를 정상적으로 사용할 수 있게 되었습니다!");
    }//testGetTime()

    @Test
    public void testGetTime2(){
        log.info("getTime2 입니다.");
        log.info(timeMapper.getTime2());
    }//testGetTime2()
}//TimeMapperTests
