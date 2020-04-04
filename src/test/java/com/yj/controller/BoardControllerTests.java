package com.yj.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Log4j2
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml",
                    "file:src/main/webapp/WEB-INF/app-servlet.xml"})
//WAS 연결을 하지 않고, 컨트롤러를 테스트하기 위해 추가한 어노테이션입니다.
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BoardControllerTests {
    @Setter(onMethod_ = @Autowired)
    private WebAppConfiguration ctx;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(ctx).build();
    }//setup()
    @Test
    public void testList() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap());

    }//testList()
}//BoardControllerTests
