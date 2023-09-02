package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Boolean existsByMedicoIdAndData(Long id, LocalDateTime data);

    Boolean existsByPacienteAndDataBetween(Long id, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
