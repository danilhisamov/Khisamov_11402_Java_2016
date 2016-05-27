package sample.server;

import org.springframework.http.HttpStatus;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class MyCustomException extends RuntimeException {
    private HttpStatus statusCode;

    public MyCustomException(HttpStatus status) {
        statusCode = status;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
