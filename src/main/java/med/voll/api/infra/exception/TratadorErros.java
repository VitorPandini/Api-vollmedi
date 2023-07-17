package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErros {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception){
        var except=exception.getFieldErrors();
        return ResponseEntity.badRequest().body(except.stream().map(DadosErroValidatacao ::new).toList());
    }

    private record DadosErroValidatacao(String campo,String mensagem){

        public DadosErroValidatacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }

}
