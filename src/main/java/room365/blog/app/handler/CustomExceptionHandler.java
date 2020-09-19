package room365.blog.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import room365.blog.app.error.PostNotFoundErrorResponse;
import room365.blog.app.exception.PostNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(PostNotFoundException.class)
//    public void handlePostNotFound(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.NOT_FOUND.value());
//    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<PostNotFoundErrorResponse> handlePostNotFoundException(Exception e, WebRequest webRequest) {
        PostNotFoundErrorResponse response = new PostNotFoundErrorResponse();
        response.setError(e.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
