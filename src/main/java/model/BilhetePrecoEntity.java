package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bilhetepreco", schema = "cinema")
public class BilhetePrecoEntity {
    @Id
    @Column(name = "bilhete_preco_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bilhetePrecoId;

    @Basic
    @Column(name = "bilhete_id", nullable = false)
    private Long bilheteId;

    @Basic
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    public Long getBilhetePrecoId() {
        return bilhetePrecoId;
    }

    public void setBilhetePrecoId(Long bilhetePrecoId) {
        this.bilhetePrecoId = bilhetePrecoId;
    }

    public Long getBilheteId() {
        return bilheteId;
    }

    public void setBilheteId(Long bilheteId) {
        this.bilheteId = bilheteId;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BilhetePrecoEntity that = (BilhetePrecoEntity) o;

        if (bilhetePrecoId != null ? !bilhetePrecoId.equals(that.bilhetePrecoId) : that.bilhetePrecoId != null)
            return false;
        if (preco != null ? !preco.equals(that.preco) : that.preco != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bilhetePrecoId != null ? bilhetePrecoId.hashCode() : 0;
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        return result;
    }
}
