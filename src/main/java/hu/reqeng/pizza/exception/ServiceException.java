package hu.reqeng.pizza.exception;

import hu.reqeng.pizza.model.Cart;

public class ServiceException extends Exception {
    protected final int code;

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
