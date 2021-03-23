package org.iptime.kibnm821.homepage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class HomepageApplicationTests{

//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    MemberService memberService;
//
//    @Test
//    public void run() throws Exception{
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection.getMetaData().getURL());
//        System.out.println(connection.getMetaData().getUserName());
//    }
//
//    @Test
//    public void accountTest(){
//        //DB에 넘길 변수
//        Map<String, Object> account = new HashMap<>();
//        String ID = "test";
//        String PASSWORD = "1234";
//
//        //DB에 넘길 변수
//        account.put("ID", ID);
//        account.put("PASSWORD", PASSWORD);
//
//        account =  (Map<String ,Object>) memberService.LoginCheck(account);
//
//        System.out.println("결과값은 : " + account.get("ID"));
//    }

    @Test
    public void Encrypte(){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String test = bCrypt.encode("1234");
        System.out.println(test);


    }
}
