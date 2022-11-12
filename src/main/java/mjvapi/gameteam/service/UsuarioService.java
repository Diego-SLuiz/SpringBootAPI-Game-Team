package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.pedido.PedidoResponseBody;
import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
import mjvapi.gameteam.dto.usuario.UsuarioResponseBody;
import mjvapi.gameteam.model.BibliotecaModel;
import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.model.PedidoModel;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.repository.UsuarioRepository;

import mjvapi.gameteam.util.BuscarEnderecoPorCep;
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

    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Usuario {%s} não encontrado", id)));
    }

    public UsuarioModel save(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioResponseBody> buscarUsuarios() {
        return UsuarioResponseBody.converterEmListaDto(findAll());
    }

    public UsuarioResponseBody buscarUsuario(Long id) {
        return UsuarioResponseBody.converterEmDto(findById(id));
    }

    public void deletarUsuario(Long id) {
        deleteById(id);
    }

    public UsuarioResponseBody novoUsuario(UsuarioRequestBody usuarioRequest) {
        UsuarioModel usuario = UsuarioRequestBody.converterEmUsuario(usuarioRequest);
        usuario.setRegistro(LocalDate.now());

        EnderecoModel endereco = enderecoService.novoEndereco(usuarioRequest.getCep());
        usuario.setEndereco(enderecoService.save(endereco));

        BibliotecaModel biblioteca = bibliotecaService.novaBiblioteca();
        usuario.setBiblioteca(bibliotecaService.save(biblioteca));

        PedidoModel pedido = pedidoService.novoPedido();
        usuario.getPedidos().add(pedidoService.save(pedido));

        return UsuarioResponseBody.converterEmDto(save(usuario));
    }

    public UsuarioResponseBody atualizarUsuario(Long id, UsuarioRequestBody usuarioRequest) {
        UsuarioModel usuario = findById(id);

        if (usuarioRequest.getNome() != null) {
            usuario.setNome(usuarioRequest.getNome());
        }
        if (usuarioRequest.getEmail() != null) {
            usuario.setEmail(usuarioRequest.getEmail());
        }
        if (usuarioRequest.getSenha() != null) {
            usuario.setSenha(usuarioRequest.getSenha());
        }
        if (usuarioRequest.getCep() != null) {
            EnderecoModel endereco = BuscarEnderecoPorCep.buscar(usuarioRequest.getCep());
            usuario.setEndereco(endereco);
        }

        return UsuarioResponseBody.converterEmDto(save(usuario));
    }

    public List<PedidoResponseBody> buscarPedidos(Long id) {
        UsuarioModel usuario = findById(id);

        return PedidoResponseBody.converterEmListaDto(usuario.getPedidos());
    }

    public List<PedidoResponseBody> adicionarPedido(Long id) {
        UsuarioModel usuario = findById(id);
        PedidoModel pedido = pedidoService.novoPedido();
        usuario.getPedidos().add(pedidoService.save(pedido));
        save(usuario);

        return PedidoResponseBody.converterEmListaDto(usuario.getPedidos());
    }

    public List<PedidoResponseBody> removerPedido(Long id, Long pedidoId) {
        UsuarioModel usuario = findById(id);
        PedidoModel pedido = pedidoService.findById(pedidoId);

        if (!usuario.getPedidos().contains(pedido)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Pedido {%s} não existe para o Usuario {%s}", pedidoId, id));
        }

        usuario.getPedidos().remove(pedido);
        save(usuario);

        return PedidoResponseBody.converterEmListaDto(usuario.getPedidos());
    }

}
