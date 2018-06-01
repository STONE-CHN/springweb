package fansir.me.springweb.common.security.authc;

/**
 * Class Name: LegacyPasswordException
 * Description: TODO
 *
 */
public class LegacyPasswordMatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    
    /**
    * LegacyPasswordMatchException Constructor
    *
    */
    public LegacyPasswordMatchException(){
        super();
    }
    
    
    /**
    * LegacyPasswordMatchException Constructor
    *
    * @param message
    */
    public LegacyPasswordMatchException(String message){
        super(message);
    }
    
}
