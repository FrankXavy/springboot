package com.fxf.springboot.basic.service;

import com.fxf.springboot.basic.dao.UserRepository;
import com.fxf.springboot.basic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        var oldUserOp = userRepository.findById(user.getId());

        if (oldUserOp.isPresent()) {
            var olduser = oldUserOp.get();
            olduser.setAddress(user.getAddress());
            olduser.setName(user.getName());

            return userRepository.save(olduser);
        }
        return new User();
    }

    public String deleteUserById(Integer id) {
        userRepository.deleteById(id);
        return "User Deleted";
    }

}
