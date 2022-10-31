package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.endereco.EnderecoRequestBody;
import mjvapi.gameteam.dto.endereco.EnderecoResponseBody;
import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> buscarTodos() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel buscarEndereco(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Endereco {%s} não encontrado",  id)));
    }

    public EnderecoResponseBody salvarEndereco(EnderecoModel endereco) {
        return new EnderecoResponseBody(enderecoRepository.save(endereco));
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public EnderecoResponseBody novoEndereco(EnderecoRequestBody enderecoRequest) {
        EnderecoModel endereco = new EnderecoModel();

        if (enderecoRequest.getPais() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"pais\" não pode ser nulo");
        }
        if (enderecoRequest.getCidade() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"cidade\" não pode ser nulo");
        }
        if (enderecoRequest.getLogradouro() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"logradouro\" não pode ser nulo");
        }
        if (enderecoRequest.getBairro() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"bairro\" não pode ser nulo");
        }
        if (enderecoRequest.getCep() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"cep\" não pode ser nulo");
        }
        if (enderecoRequest.getNumero() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"numero\" não pode ser nulo");
        }
        if (enderecoRequest.getUf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"uf\" não pode ser nulo");
        }

        endereco.setPais(enderecoRequest.getPais());
        endereco.setCidade(enderecoRequest.getCidade());
        endereco.setLogradouro(enderecoRequest.getLogradouro());
        endereco.setBairro(enderecoRequest.getBairro());
        endereco.setComplemento(enderecoRequest.getComplemento());
        endereco.setCep(enderecoRequest.getCep());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setUf(enderecoRequest.getUf());

        return salvarEndereco(endereco);
    }

    public EnderecoResponseBody atualizarEndereco(Long id, EnderecoRequestBody enderecoRequest) {
        EnderecoModel endereco = buscarEndereco(id);

        if (enderecoRequest.getPais() != null) {
            endereco.setPais(enderecoRequest.getPais());
        }
        if (enderecoRequest.getCidade() != null) {
            endereco.setCidade(enderecoRequest.getCidade());
        }
        if (enderecoRequest.getLogradouro() != null) {
            endereco.setLogradouro(enderecoRequest.getLogradouro());
        }
        if (enderecoRequest.getBairro() != null) {
            endereco.setBairro(enderecoRequest.getBairro());
        }
        if (enderecoRequest.getComplemento() != null) {
            endereco.setComplemento(enderecoRequest.getComplemento());
        }
        if (enderecoRequest.getCep() != null) {
            endereco.setCep(enderecoRequest.getCep());
        }
        if (enderecoRequest.getNumero() != null) {
            endereco.setNumero(enderecoRequest.getNumero());
        }
        if (enderecoRequest.getUf() != null) {
            endereco.setUf(enderecoRequest.getUf());
        }

        return salvarEndereco(endereco);
    }

}
