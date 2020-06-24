package kz.bitlab.TestSpring.controllers.exceptionHandler;

import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(SystemServiceException.class)
    public ResponseEntity<SystemServiceException> exception(SystemServiceException e) {
        return new ResponseEntity<SystemServiceException>(e, HttpStatus.BAD_REQUEST);
    }

}
