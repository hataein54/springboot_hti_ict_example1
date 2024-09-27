package edu.ict.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.ict.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
   
   @Autowired
   private UserMapper userMapper;
   
   
   @Disabled
   @Test
   void testUserMapper() {
      assertNotNull(userMapper);
   }
   
   @Test
   void testGetUser() {
      UserVO user = userMapper.getUser("admin");
      assertNotNull(user);
      
      System.out.println(user);
      
   }
   
   
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   
   @Disabled
   @Test
   void testInsertUser() {
      
      UserVO user = new UserVO();
      user.setUsername("admin2");
      user.setPassword(passwordEncoder.encode("admin2"));
      user.setEnabled("1");
      
      userMapper.insertUser(user);
      userMapper.insertAuthorities(user);      
         
      assertNotNull(user);
      
      System.out.println(user);
      
   }
   
   @Test
   void testMather() {
      
	   UserVO user = userMapper.getUser("admin2");
	   //$2a$10$xWAXM9YiSFRlqS8JuBmro.AiVXBNG6Jri.FHarMjBzo42dlDcqlX2
	   boolean isMatch = passwordEncoder.matches("admin2",user.getPassword());
	   
	   assertEquals(isMatch, true);

      
   }

}
