package model;

import controller.BilheteriaBiz;

import javax.persistence.*;

@Entity
@Table(name = "Vendedor", schema = "cinema")
public class VendedorEntity {
    @Id
    @Column(name = "vendedor_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendedorId;

    @Basic
    @Column(name = "funcionario_id", nullable = false)
    private Long funcionarioId;

    @Basic
    @Column(name = "gerente_id", nullable = false)
    private Long gerenteId;

    @Basic
    @Column(name = "meta_vendas", nullable = true)
    private int metaVendas;

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(Long gerenteId) {
        this.gerenteId = gerenteId;
    }

    public int getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(int metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendedorEntity that = (VendedorEntity) o;

        if (vendedorId != null ? !vendedorId.equals(that.vendedorId) : that.vendedorId != null) return false;
        if (gerenteId != null ? !gerenteId.equals(that.gerenteId) : that.gerenteId != null) return false;
        if (metaVendas != 0 ? metaVendas != that.metaVendas : that.metaVendas != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vendedorId != null ? vendedorId.hashCode() : 0;
        result = 31 * result + (gerenteId != null ? gerenteId.hashCode() : 0);
        result = 31 * result + metaVendas;
        return result;
    }

    @Override
    public String toString() {
        String pessoaNome = new BilheteriaBiz().getPessoaNome(funcionarioId);
        return pessoaNome;
    }

}
