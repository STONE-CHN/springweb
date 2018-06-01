package fansir.me.springweb.common.security;

import org.springframework.stereotype.Component;

/**
 * Class Name: PageSecurityContext Description: TODO
 * 
 *
 */
@Component
public class SecurityContext extends BaseSecurityContext {

    public static SecurityContext getInstance() {
        return new SecurityContext();
    }

}
