package fansir.me.springweb.common.security.service.impl;

import fansir.me.springweb.common.security.domain.User;
import fansir.me.springweb.common.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fansir.me.springweb.common.security.repository.UserRepository;


/**
* Class Name: UserServiceImpl
* Description: TODO
*
*/
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findOne(userName);
    }

}
