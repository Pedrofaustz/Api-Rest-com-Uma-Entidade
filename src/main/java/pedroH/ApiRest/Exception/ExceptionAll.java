package pedroH.ApiRest.Exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAll {
    @ExceptionHandler(MethodArgumentNotValidException.class) // Erros com limites definidos no Entity
    public String handleValidationException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();
    }
    @ExceptionHandler(value = MatchException.class) // Tratamento de Erros Gerais!
    public String handleMatchException(MatchException e) {
        return e.getMessage();
    }

}
