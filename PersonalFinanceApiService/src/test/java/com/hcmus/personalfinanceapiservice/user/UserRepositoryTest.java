package com.hcmus.personalfinanceapiservice.user;

import com.hcmus.personalfinanceapicommon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser()
    {
        User user = User.builder().name("John Doe").email("le@gmail.com").build();
        User savedUser = userRepository.save(user);
        System.out.println(savedUser.getId());
    }

    @Test
    public void getUser()
    {
        Long id =   1L;
        User user = userRepository.findById(id).get();
        System.out.println(user.getId());
    }
}
