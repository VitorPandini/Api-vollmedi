package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {


    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta= dados.data();
        var domingo=dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var antesAbeturaClinica= dataConsulta.getHour() <7;
        var depoisDoEncerramento = dataConsulta.getHour() >18;
        if(domingo || antesAbeturaClinica || depoisDoEncerramento){
            throw new ValidacaoException("Consulta fora do Horario de funcionamento da clinica");
        }
    }
}
