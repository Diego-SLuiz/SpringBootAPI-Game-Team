package mjvapi.gameteam.model;

import javax.persistence.*;

@Entity
@Table(name = "pedido_item")
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
