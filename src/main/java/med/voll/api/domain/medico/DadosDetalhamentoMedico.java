package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm,String telefone, Especialidade especialidade,
                                      Endereco endereco) {
    public DadosDetalhamentoMedico(Medico dadosDoMedico){
        this(dadosDoMedico.getId(), dadosDoMedico.getNome(), dadosDoMedico.getEmail(), dadosDoMedico.getCrm(), dadosDoMedico.getTelefone(), dadosDoMedico.getEspecialidade()
        ,dadosDoMedico.getEndereco());
    }
}
