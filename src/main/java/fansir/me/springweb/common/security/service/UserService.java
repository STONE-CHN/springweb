package fansir.me.springweb.common.security.service;

import fansir.me.springweb.common.security.domain.User;


/**
* Class Name: UserService
* Description: TODO
*
*/
public interface UserService {
    
    User findUserByUserName(String userName);

}
