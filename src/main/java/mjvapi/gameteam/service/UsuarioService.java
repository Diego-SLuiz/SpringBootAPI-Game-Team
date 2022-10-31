package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
import mjvapi.gameteam.dto.usuario.UsuarioResponseBody;
import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.repository.EnderecoRepository;
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

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Usuario {%s} não encontrado", id)));
    }

    public UsuarioResponseBody salvarUsuario(UsuarioModel usuario) {
        return new UsuarioResponseBody(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioResponseBody novoUsuario(UsuarioRequestBody usuarioRequest) {
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

        return salvarUsuario(usuario);
    }

    public UsuarioResponseBody atualizarUsuario(Long id, UsuarioRequestBody usuarioRequest) {
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

        return salvarUsuario(usuario);
    }

}
