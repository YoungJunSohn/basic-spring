package com.yj.sample;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

//@ExtendWith(SpringExtension.class)//Junit4에서 @RunWith(SpringJunit4ClassRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j2
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
public class SampleTests {

    @Setter(onMethod_ = { @Autowired })
    private Restaurant restaurant;

    @Test
    public void testExist(){
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("---------------------");
        log.info(restaurant.getChef());
    }//testExist()
}//SampleTests
