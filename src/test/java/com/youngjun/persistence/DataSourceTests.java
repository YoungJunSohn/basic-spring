package com.youngjun.persistence;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j2
public class DataSourceTests {
    @Setter(onMethod_ = {@Autowired})
    private DataSource datasource;

    @Test
    public void testConnection(){
        try(Connection con = datasource.getConnection()){
            log.info("커넥션 객체를 출력합니다");
            log.info(con);
        }catch(Exception e){
            fail(e.getMessage());
        }//try~catch
    }//testConnection()
}//DataSourceTests
