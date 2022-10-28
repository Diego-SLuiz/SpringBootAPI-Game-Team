package mjvapi.gameteam.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "senha", length = 50, nullable = false)
    private String senha;

    @Column(name = "dataRegistro", nullable = false)
    private LocalDate dataRegistro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoModel endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<PedidoModel> listaPedidos = new ArrayList<PedidoModel>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public List<PedidoModel> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidoModel> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
