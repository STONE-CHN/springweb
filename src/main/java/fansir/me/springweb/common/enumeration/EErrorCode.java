package fansir.me.springweb.common.enumeration;

import java.util.Arrays;

import fansir.me.springweb.common.exception.DisplayableError;

/**
 * Class Name: EBizError Description: business errors which may be recoverable, or should be displayed on web page.
 * 
 *
 */
public enum EErrorCode implements DisplayableError {
    // Default error
    COMM_INTERNAL_ERROR("COMM0001"),

    // Errors for internal technical issues.
    TECH_PARAM_REQUIRED("TECH0001"), TECH_DATA_NOT_EXIST("TECH0002"), TECH_DATA_INVALID("TECH0003"), TECH_OPTIMISTIC_LOCK(
            "TECH0004"),

    NULL("", ""), PRODUCT_NOT_FOUND("PROD0001", "product.not.found"), PROD_ALREADY_EXISTS("PROD0002",
            "product.already.exists");

    private String errorCode;

    // this field is only for display, do not set it if it is not needed.
    private String displayMsg;

    private Object[] args;

    private static final String DEFAULT_ERROR_MSG = "error.common.unknown";

    private EErrorCode(String errorCode, String displayMsg) {
        this.errorCode = errorCode;
        this.displayMsg = displayMsg;
    }

    private EErrorCode(String errorCode, String displayMsg, String[] args) {
        this.errorCode = errorCode;
        this.displayMsg = displayMsg;
        if (args != null) {
            this.args = Arrays.copyOf(args, args.length);
        }
    }

    private EErrorCode(String errorCode) {
        this.errorCode = errorCode;
        this.displayMsg = DEFAULT_ERROR_MSG;
    }

    @Override
    public boolean isBizError() {
        return !displayMsg.equals(DEFAULT_ERROR_MSG);
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getDisplayMsg() {
        return displayMsg;
    }

    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }

    /**
     * @return return the value of the var args
     */
    @Override
    public Object[] getArgs() {
        return args;
    }

}
