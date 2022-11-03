package mjvapi.gameteam.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "biblioteca")
public class BibliotecaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidadeJogos", nullable = false)
    private Integer quantidadeJogos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private List<JogoModel> jogos = new ArrayList<JogoModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeJogos() {
        return quantidadeJogos;
    }

    public void setQuantidadeJogos(Integer quantidadeJogos) {
        this.quantidadeJogos = quantidadeJogos;
    }

    public List<JogoModel> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoModel> jogos) {
        this.jogos = jogos;
    }

}
