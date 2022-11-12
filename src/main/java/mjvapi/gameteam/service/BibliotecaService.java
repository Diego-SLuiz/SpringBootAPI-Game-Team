package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.biblioteca.BibliotecaResponseBody;
import mjvapi.gameteam.dto.jogo.JogoResponseBody;
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

    public BibliotecaResponseBody adicionarJogoParaBiblioteca(Long id, Long produtoId) {
        BibliotecaModel biblioteca = findById(id);

        for (JogoModel jogo: biblioteca.getJogos()) {
            if (jogo.getProduto().getId() == (produtoId)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Jogo com Produto {%s} já existe na Biblioteca {%s}", jogo.getProduto().getId(), id));
            }

        }

        JogoModel jogo = jogoService.novoJogo(produtoId);
        jogoService.save(jogo);
        biblioteca.getJogos().add(jogo);
        biblioteca.setQuantidadeJogos(biblioteca.getJogos().size());

        return BibliotecaResponseBody.converterEmDto(save(biblioteca));
    }

    public BibliotecaResponseBody removerJogoDaBiblioteca(Long id, Long produtoId) {
        BibliotecaModel biblioteca = findById(id);
        Long jogoId = null;

        for (JogoModel jogo: biblioteca.getJogos()) {
            if (jogo.getProduto().getId() == produtoId) {
                jogoId = jogo.getId();
            }
        }

        if (jogoId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Jogo com Produto {%s} não existe na Biblioteca {%s}", produtoId, id));
        }

        JogoModel jogo = jogoService.findById(jogoId);
        biblioteca.getJogos().remove(jogo);
        biblioteca.setQuantidadeJogos(biblioteca.getJogos().size());
        save(biblioteca);
        jogoService.deleteById(jogoId);

        return BibliotecaResponseBody.converterEmDto(biblioteca);
    }

}
