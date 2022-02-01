package com.example.springbootcrud.repository;


import com.example.springbootcrud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    @Query(value = "select u from User u where u.login = :login")
    User findByLogin(@Param("login") String login);
}
