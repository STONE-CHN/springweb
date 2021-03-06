package fansir.me.springweb.common.exception;

import fansir.me.springweb.common.enumeration.EErrorCode;


/**
 * Class Name: BaseException
 * Description: TODO
 *
 */

public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected final DisplayableError errorCode;
    
    
    /**
    * BaseException Constructor
    *
    */
    public BaseException(){
        super();
        errorCode = EErrorCode.COMM_INTERNAL_ERROR;
    }
    
    
    /**
    * BaseException Constructor
    *
    * @param error
    */
    public BaseException(DisplayableError error){
        this.errorCode = error;
    }
    
    
    /**
    * BaseException Constructor
    *
    * @param error
    * @param message
    */
    public BaseException(DisplayableError error, String message){
        super(message);
        this.errorCode = error;
        
    }
    
    
    /**
    * BaseException Constructor
    *
    * @param error
    * @param message
    * @param cause
    */
    public BaseException(DisplayableError error, String message, Throwable cause){
        super(message, cause);
        this.errorCode = error;
    }

    
    /**
    * Description: TODO
    *
    * @return
    */
    public DisplayableError getError() {
        return errorCode;
    }
}
