package com.yj.controller;

import com.yj.domain.BoardVO;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Log4j2
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml",
                    "file:src/main/webapp/WEB-INF/app-servlet.xml"})
//WAS 연결을 하지 않고, 컨트롤러를 테스트하기 위해 추가한 어노테이션입니다.
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BoardControllerTests {
    @Setter(onMethod_ = @Autowired)
    private WebApplicationContext ctx;

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

    @Test
    public void testRegister () throws Exception{
        /*String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
        .param("title", "테스트 새글 제목1")
        .param("content", "테스트 새글 내용1")
        .param("writer", "user03")
        ).andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);*/

    }//testRegister()

    @Test
    public void testGetOne() throws  Exception{
        /*log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
                .param("bno", "10"))
                .andReturn()
                .getModelAndView()
                .getViewName());*/

    }//testGetOne()

    @Test
    public void testModify() throws Exception{

       /* String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno", "1")
                        .param("title", "수정된 제목1")
                        .param("content", "수정된 내용1")
                        .param("writer", "user04")
        ).andReturn()
        .getModelAndView()
        .getViewName();

        log.info(resultPage);*/
    }//testModify()


    @Test
    public void remove() throws  Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
        .param("bno", "25")).andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }//remove()q

    @Test
    public void testPagedList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
        .param("pageNum", "2")
        .param("amount","15")).andReturn().getModelAndView().getModelMap();
    }//testPagedList()
}//BoardControllerTests
