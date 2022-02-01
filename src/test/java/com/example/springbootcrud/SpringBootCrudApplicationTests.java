package com.example.springbootcrud;

import com.example.springbootcrud.domain.Role;
import com.example.springbootcrud.domain.User;
import com.example.springbootcrud.repository.RoleDAO;
import com.example.springbootcrud.repository.UserDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.*;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class SpringBootCrudApplicationTests {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Test
    public void testCreateUser(){
        User user = new User();
        //user.setId(7l);
        user.setName("Ruslan");
        user.setLastName("Ruslanov");
        user.setAge((byte) 30);
        user.setEmailAddress("ruslan111@mail.com");
        user.setLogin("RuslanUser");
        user.setPassword("RuslanUser");

/*        Role role1 = new Role();
        //role1.setId(7l);
        role1.setName("USER");
        roleDAO.save(role1);*/

        Role role2 = new Role();
        role2.setName("USER");
        roleDAO.save(role2);

        Set<Role> roleSet = new HashSet<>();
        //roleSet.add(role1);
        roleSet.add(role2);

        user.setRoles(roleSet);
        User savedUser = userDAO.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = userDAO.findAll();

        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }
}
