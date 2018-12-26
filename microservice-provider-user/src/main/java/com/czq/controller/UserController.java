package com.czq.controller;

import com.czq.dao.UserRepository;
import com.czq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
//        User findOne = userRepository.getOne(id);
//        会报错No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer

        User findOne = userRepository.findById(id).get();
        return findOne;
    }
}
