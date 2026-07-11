package in.shriji.priyaPritam.exception;

import in.shriji.priyaPritam.DTO.ExceptionResponseDTO;
import in.shriji.priyaPritam.DTO.ValidationExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request)
    {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                LocalDateTime.now(),
                404,
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity
                .status(404)
                .body(exceptionResponseDTO);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDuplicateResourceException(DuplicateResourceException ex,HttpServletRequest request)
    {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                LocalDateTime.now(),
                409,
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity
                .status(409)
                .body(exceptionResponseDTO);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpServletRequest request)
    {
        Map<String,String> fieldErrors=new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error->fieldErrors.put(error.getField(),error.getDefaultMessage()));
        ValidationExceptionResponseDTO exceptionResponseDTO=new ValidationExceptionResponseDTO(
                LocalDateTime.now(),
                400,
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Error",
                request.getRequestURI(),
                fieldErrors
        );
        return ResponseEntity
                .status(400)
                .body(exceptionResponseDTO);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException ex,HttpServletRequest request) {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                LocalDateTime.now(),
                500,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity
                .status(500)
                .body(exceptionResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleGenericException(Exception ex,HttpServletRequest request) {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                LocalDateTime.now(),
                404,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Something went wrong",
                request.getRequestURI()

        );
        return ResponseEntity
                .status(500)
                .body(exceptionResponseDTO);
    }
}
