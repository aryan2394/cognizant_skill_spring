package in.shriji.priyaPritam.DTO;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponseDTO {
    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String error;
    private String path;
    private Map<String,String> errorFields;

    public ValidationExceptionResponseDTO(LocalDateTime timeStamp, int status, String message, String error, String path, Map<String, String> errorFields) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        this.errorFields = errorFields;
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

    public Map<String, String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(Map<String, String> errorFields) {
        this.errorFields = errorFields;
    }
}
