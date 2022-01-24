package com.example.springbootcrud.repository;

import com.example.springbootcrud.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> readAllUsers() {
        return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteById(Long id) {
        User userById = getUserById(id);
        if (userById != null) {
            entityManager.remove(userById);
        } else {
            System.out.println("There is no such user");
        }

    }
    @Override
    public void update(User user) {
/*        User newUser = getUserById();
        newUser.setName(user.getName());
        newUser.setMailAddress(user.getMailAddress());*/
        entityManager.merge(user);
    }


}
