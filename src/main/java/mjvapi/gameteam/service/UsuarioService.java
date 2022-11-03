package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
import mjvapi.gameteam.model.BibliotecaModel;
import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.model.PedidoModel;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private BibliotecaService bibliotecaService;

    @Autowired
    private PedidoService pedidoService;

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Usuario {%s} não encontrado", id)));
    }

    public void salvarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void novoUsuario(UsuarioRequestBody usuarioRequest) {
        UsuarioModel usuario = new UsuarioModel();

        if (usuarioRequest.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"nome\" não pode ser nulo");
        }
        if (usuarioRequest.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"email\" não pode ser nulo");
        }
        if (usuarioRequest.getSenha() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo \"senha\" não pode ser nulo");
        }

        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setRegistro(LocalDate.now());

        if (usuarioRequest.getEndereco() != null) {
            EnderecoModel endereco = enderecoService.buscarEndereco(usuarioRequest.getEndereco());
            usuario.setEndereco(endereco);
        }

        salvarUsuario(usuario);
    }

    public void atualizarUsuario(Long id, UsuarioRequestBody usuarioRequest) {
        UsuarioModel usuario = buscarUsuario(id);

        if (usuarioRequest.getNome() != null) {
            usuario.setNome(usuarioRequest.getNome());
        }
        if (usuarioRequest.getEmail() != null) {
            usuario.setEmail(usuarioRequest.getEmail());
        }
        if (usuarioRequest.getSenha() != null) {
            usuario.setSenha(usuarioRequest.getSenha());
        }
        if (usuarioRequest.getEndereco() != null) {
            EnderecoModel endereco = enderecoService.buscarEndereco(usuarioRequest.getEndereco());
            usuario.setEndereco(endereco);
        }
        if (usuarioRequest.getBiblioteca() != null) {
            BibliotecaModel biblioteca = bibliotecaService.buscarBiblioteca(usuarioRequest.getBiblioteca());
            usuario.setBiblioteca(biblioteca);
        }

        salvarUsuario(usuario);
    }

    public void adicionarPedido(Long id, Long pedidoId) {
        UsuarioModel usuario = buscarUsuario(id);
        PedidoModel pedido = pedidoService.buscarPedido(pedidoId);

        if (usuario.getPedidos().contains(pedido)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Pedido {%s} já existe para o Usuario {%s}", pedidoId, id));
        }

        usuario.getPedidos().add(pedido);
        salvarUsuario(usuario);
    }

    public void removerPedido(Long id, Long pedidoId) {
        UsuarioModel usuario = buscarUsuario(id);
        PedidoModel pedido = pedidoService.buscarPedido(pedidoId);

        if (!usuario.getPedidos().contains(pedido)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Pedido {%s} não existe para o Usuario {%s}", pedidoId, id));
        }

        usuario.getPedidos().remove(pedido);
        salvarUsuario(usuario);
    }

}
