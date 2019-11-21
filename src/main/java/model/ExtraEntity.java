package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "extra", schema = "cinema")
public class ExtraEntity {
    @Id
    @Column(name = "extra_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraId;

    @Basic
    @Column(name = "nome", nullable = false)
    private String nome;

    @Basic
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Basic
    @Column(name = "descricao", nullable = true)
    private String descricao;

    public Long getExtraId() {
        return extraId;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraEntity that = (ExtraEntity) o;

        if (extraId != null ? !extraId.equals(that.extraId) : that.extraId != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (preco != null ? !preco.equals(that.preco) : that.preco != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = extraId != null ? extraId.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
