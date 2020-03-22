package com.youngjun.test;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.Assert.fail;

@Log4j2
public class JDBCTests {
        static {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            }catch (Exception exp){
                exp.printStackTrace();
            }//try~catch
        }//static

    @Test
    public void testConnection() {
        try(Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521.XE",
                "TEST",
                "1111")
        ){
            log.info(con);
            }catch (Exception e){
            fail(e.getMessage());
        }//try~catch
    }//testConnection()
}//JDBCTests



