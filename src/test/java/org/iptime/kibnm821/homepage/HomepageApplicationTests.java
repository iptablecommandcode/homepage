package org.iptime.kibnm821.homepage;

import org.iptime.kibnm821.homepage.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HomepageApplicationTests{

    @Autowired
    DataSource dataSource;

    @Autowired
    MemberService memberService;

    @Test
    public void run() throws Exception{
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getMetaData().getURL());
        System.out.println(connection.getMetaData().getUserName());
    }

    @Test
    public void accountTest(){
        //DB에 넘길 변수
        Map<String, Object> account = new HashMap<>();
        String ID = "test";
        String PASSWORD = "1234";

        //DB에 넘길 변수
        account.put("ID", ID);
        account.put("PASSWORD", PASSWORD);

        account =  (Map<String ,Object>) memberService.LoginCheck(account);

        System.out.println("결과값은 : " + account.get("ID"));
    }
}
