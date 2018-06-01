package fansir.me.springweb.common.security.repository;

import fansir.me.springweb.common.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
* Class Name: UserRepository
* Description: TODO
*
*/
public interface UserRepository extends JpaRepository<User, String> {

}
