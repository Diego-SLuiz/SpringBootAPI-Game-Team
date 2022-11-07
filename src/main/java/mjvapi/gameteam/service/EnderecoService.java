package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.endereco.EnderecoRequestBody;
import mjvapi.gameteam.dto.endereco.EnderecoResponseBody;
import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.repository.EnderecoRepository;
import mjvapi.gameteam.util.BuscarEnderecoPorCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel findById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Endereco {%s} não encontrado",  id)));
    }

    public EnderecoModel save(EnderecoModel endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<EnderecoResponseBody> buscarEnderecos() {
        return EnderecoResponseBody.converterEmListaDto(findAll());
    }

    public EnderecoResponseBody buscarEndereco(Long id) {
        return EnderecoResponseBody.converterEmDto(findById(id));
    }

    public EnderecoModel novoEndereco(String cep) {
        EnderecoModel endereco = BuscarEnderecoPorCep.buscar(cep);

        return save(endereco);
    }

    public EnderecoResponseBody atualizarEndereco(Long id, EnderecoRequestBody enderecoRequest) {
        return null;
    }

}
