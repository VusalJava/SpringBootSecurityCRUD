package com.example.springbootcrud;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import com.example.springbootcrud.repository.RoleRepository;
import com.example.springbootcrud.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.*;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class SpringBootCrudApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateUser(){
        User user = new User();

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
        roleRepository.save(role2);

        Set<Role> roleSet = new HashSet<>();
        //roleSet.add(role1);
        roleSet.add(role2);

        user.setRoles(roleSet);
        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = userRepository.findAll();

        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete(){
        Long userId = 8L;
        userRepository.deleteById(userId);

        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
