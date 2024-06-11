package rs.ac.singidunum.aplikacija_za_clanstvo_u_teretani.error;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        ExceptionModel model = new ExceptionModel();
        model.setMessage("Data integrity violation");
        model.setName(e.getClass().getSimpleName());
        model.setPath(request.getServletPath());
        return model;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleException(Exception e, HttpServletRequest request) {
        ExceptionModel model = new ExceptionModel();
        model.setMessage(e.getMessage());
        model.setName(e.getClass().getSimpleName());
        model.setPath(request.getServletPath());
        return model;
    }
    }

