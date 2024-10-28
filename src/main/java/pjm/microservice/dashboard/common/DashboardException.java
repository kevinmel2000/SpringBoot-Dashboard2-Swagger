package pjm.microservice.dashboard.common;

import pjm.microservice.dashboard.config.Constant;

import java.security.GeneralSecurityException;

public class DashboardException extends GeneralSecurityException {
    private static final long serialVersionUID = 1L;
    private final String code;

    public DashboardException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public DashboardException(String message) {
        super(message);
        this.code = Constant.STATUS_ERROR_MSG;
    }

    public DashboardException(String message, String code) {
        super(message);
        this.code = code;
    }

    public DashboardException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
