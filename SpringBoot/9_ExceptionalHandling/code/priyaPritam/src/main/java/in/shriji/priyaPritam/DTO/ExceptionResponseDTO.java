package in.shriji.priyaPritam.DTO;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {
    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String error;
    private String path;

    public ExceptionResponseDTO(LocalDateTime timeStamp, int status, String message, String error, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
