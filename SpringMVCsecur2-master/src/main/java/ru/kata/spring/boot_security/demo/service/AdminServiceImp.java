package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.dao.UserDao2;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;



import java.util.List;


@Service
public class AdminServiceImp implements AdminService {

    private final UserDao userDao;
    private final UserDao2 userDao2;
    private final RoleDao roleDao;

    @Autowired
    public AdminServiceImp(UserDao userDao, UserDao2 userDao2, RoleDao roleDao) {
        this.userDao = userDao;
        this.userDao2 = userDao2;
        this.roleDao = roleDao;
    }


    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public List<User> allUsers() {
        return userDao2.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) roleDao.findAll();
    }


    public User findByUserName(String username) {
        return userDao2.findByUsername(username);
    }



}
