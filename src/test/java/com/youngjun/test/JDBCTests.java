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
                Class.forName("oracle.jdbc.OracleDriver");
                /*
                ojdbc 9 버전 이후(현재버전 11g)에는
                oracle.jdbc.driver.OracleDriver 에서
                oracle.jdbc.OracleDriver 로 변경되었습니다. 주의 << applicationContext 에서도 변경할 것!!
                */
            }catch (Exception exp){
                exp.printStackTrace();
            }//try~catch
        }//static

    @Test
    public void testConnection() {
        try(Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "awesomeboard",
                "1111")
        ){
            log.info(con);
            }catch (Exception e){
            fail(e.getMessage());
        }//try~catch
    }//testConnection()
}//JDBCTests



