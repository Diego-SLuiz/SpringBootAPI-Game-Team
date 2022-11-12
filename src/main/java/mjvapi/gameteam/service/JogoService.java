package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.jogo.JogoRequestBody;
import mjvapi.gameteam.dto.jogo.JogoResponseBody;
import mjvapi.gameteam.model.BibliotecaModel;
import mjvapi.gameteam.model.JogoModel;
import mjvapi.gameteam.model.ProdutoModel;
import mjvapi.gameteam.repository.BibliotecaRepository;
import mjvapi.gameteam.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private ProdutoService produtoService;

    public List<JogoModel> findAll() {
        return jogoRepository.findAll();
    }

    public JogoModel findById(Long id) {
        return jogoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Jogo {%s} não encontrado", id)));
    }

    public JogoModel save(JogoModel jogo) {
        return jogoRepository.save(jogo);
    }

    public void deleteById(Long id) {
        findById(id);
        jogoRepository.deleteById(id);
    }

    public List<JogoResponseBody> buscarJogos() {
        return JogoResponseBody.converterEmListaDto(findAll());
    }

    public JogoResponseBody buscarJogo(Long id) {
        return JogoResponseBody.converterEmDto(findById(id));
    }

    public JogoModel novoJogo(Long produtoId) {
        ProdutoModel produto = produtoService.findById(produtoId);
        JogoModel jogo = new JogoModel();
        jogo.setProduto(produto);

        return save(jogo);
    }

    public JogoResponseBody atualizarJogo(Long id, JogoRequestBody jogoBody) {
        JogoModel jogo = findById(id);

        if (jogoBody.getProduto() != null) {
            ProdutoModel produto = produtoService.findById(jogoBody.getProduto());
            jogo.setProduto(produto);
        }

        return JogoResponseBody.converterEmDto(jogo);
    }

}
