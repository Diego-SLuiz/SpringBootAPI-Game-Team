package mjvapi.gameteam.service;

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
        return enderecoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void salvarEndereco(EnderecoModel endereco) {
        enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public void novoEndereco(EnderecoModel enderecoBody) {
        salvarEndereco(enderecoBody);
    }

    public void atualizarEndereco(Long id, EnderecoModel enderecoBody) {
        EnderecoModel endereco = buscarEndereco(id);

        if (enderecoBody.getBairro() != null) {
            endereco.setBairro(enderecoBody.getBairro());
        }

        if (enderecoBody.getCep() != null) {
            endereco.setCep(enderecoBody.getCep());
        }

        if (enderecoBody.getCidade() != null) {
            endereco.setCidade(enderecoBody.getCidade());
        }

        if (enderecoBody.getComplemento() != null) {
            endereco.setComplemento(enderecoBody.getComplemento());
        }

        if (enderecoBody.getLogradouro() != null) {
            endereco.setLogradouro(enderecoBody.getLogradouro());
        }

        if (enderecoBody.getPais() != null) {
            endereco.setPais(enderecoBody.getPais());
        }

        if (enderecoBody.getUf() != null) {
            endereco.setUf(enderecoBody.getUf());
        }

        salvarEndereco(endereco);
    }

}
