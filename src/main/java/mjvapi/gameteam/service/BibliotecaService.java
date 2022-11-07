package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.biblioteca.BibliotecaResponseBody;
import mjvapi.gameteam.model.BibliotecaModel;
import mjvapi.gameteam.model.JogoModel;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BibliotecaService {
    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private JogoService jogoService;

    public List<BibliotecaModel> findAll() {
        return bibliotecaRepository.findAll();
    }

    public BibliotecaModel findById(Long id) {
        return bibliotecaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Biblioteca {%s} não encontrada", id)));
    }

    public BibliotecaModel save(BibliotecaModel biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public List<BibliotecaResponseBody> buscarBibliotecas() {
        return BibliotecaResponseBody.converterEmListaDto(findAll());
    }

    public BibliotecaResponseBody buscarBiblioteca(Long id) {
        return BibliotecaResponseBody.converterEmDto(findById(id));
    }

    public BibliotecaModel novaBiblioteca() {
        BibliotecaModel biblioteca = new BibliotecaModel();
        biblioteca.setQuantidadeJogos(0);

        return save(biblioteca);
    }

    public BibliotecaResponseBody adicionarJogoParaBiblioteca(Long id, Long jogoId) {
        return null;
    }

    public BibliotecaResponseBody removerJogoDaBiblioteca(Long id, Long jogoId) {
        return null;
    }

}
