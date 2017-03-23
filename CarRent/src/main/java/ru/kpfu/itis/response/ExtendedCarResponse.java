package ru.kpfu.itis.response;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class ExtendedCarResponse extends CarResponse {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
