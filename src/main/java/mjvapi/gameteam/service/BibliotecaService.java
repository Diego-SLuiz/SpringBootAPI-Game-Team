package mjvapi.gameteam.service;

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

    public List<BibliotecaModel> buscarTodos() {
        return bibliotecaRepository.findAll();
    }

    public BibliotecaModel buscarBiblioteca(Long id) {
        return bibliotecaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Biblioteca {%s} não encontrada", id)));
    }

    public void salvarBiblioteca(BibliotecaModel biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    public void deletarBiblioteca(Long id) {
        bibliotecaRepository.deleteById(id);
    }

    public void novaBiblioteca() {
        BibliotecaModel biblioteca = new BibliotecaModel();
        biblioteca.setQuantidadeJogos(0);
        salvarBiblioteca(biblioteca);
    }

    public void adicionarJogoParaBiblioteca(Long id, Long jogoId) {
        BibliotecaModel biblioteca = buscarBiblioteca(id);
        JogoModel jogo = jogoService.buscarJogo(jogoId);

        if (biblioteca.getJogos().contains(jogo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Jogo {%s} já existe na Biblioteca {%s}", jogo.getId(), biblioteca.getId()));
        }

        biblioteca.getJogos().add(jogo);
        biblioteca.setQuantidadeJogos(biblioteca.getQuantidadeJogos() + 1);
        salvarBiblioteca(biblioteca);
    }

    public void removerJogoDaBiblioteca(Long id, Long jogoId) {
        BibliotecaModel biblioteca = buscarBiblioteca(id);
        JogoModel jogo = jogoService.buscarJogo(jogoId);

        if (!biblioteca.getJogos().contains(jogo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Jogo {%s} não existe na Biblioteca {%s}", jogo.getId(), biblioteca.getId()));
        }

        biblioteca.getJogos().remove(jogo);
        biblioteca.setQuantidadeJogos(biblioteca.getQuantidadeJogos() - 1);
        salvarBiblioteca(biblioteca);
    }

}
