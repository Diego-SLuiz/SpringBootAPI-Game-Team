package mjvapi.gameteam.service;

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

    public List<JogoModel> buscarTodos() {
        return jogoRepository.findAll();
    }

    public JogoModel buscarJogo(Long id) {
        return jogoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Jogo {%s} não encontrado", id)));
    }

    public void salvarJogo(JogoModel jogo) {
        jogoRepository.save(jogo);
    }

    public void deletarJogo(Long id) {
        jogoRepository.deleteById(id);
    }

    public void novoJogo() {
        JogoModel jogo = new JogoModel();
        salvarJogo(jogo);
    }

    public void atualizarJogo(Long id, Long produtoId) {
        JogoModel jogo = buscarJogo(id);
        ProdutoModel produto = produtoService.buscarProduto(produtoId);

        jogo.setProduto(produto);
        salvarJogo(jogo);
    }

}
