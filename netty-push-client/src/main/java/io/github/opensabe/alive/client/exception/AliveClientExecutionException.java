package io.github.opensabe.alive.client.exception;


public class AliveClientExecutionException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AliveClientExecutionException(String message) {
        super(message);
    }

    public AliveClientExecutionException(String message, Throwable t) {
        super(message, t);
    }

}
