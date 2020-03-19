package com.youngjun.sample;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j2
public class HotelTests {
    @Setter(onMethod_ = @Autowired)
    private SampleHotel hotel;

    @Test
    public void testExist(){
        assertNotNull(hotel); //hotel 객체가 Null 이 아님을 판별합니다.

        log.info(hotel);
        log.info("--------------------------------");
        log.info(hotel.getChef());

    }//testExist()
}//HotelTests
