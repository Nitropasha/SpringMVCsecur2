package ru.kata.spring.boot_security.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDao  {
   List<User> listUsers();
   void saveUser(User user);
   User getUser(Long id);
   void deleteUser(Long id);
   User roleNull(User user);


}
