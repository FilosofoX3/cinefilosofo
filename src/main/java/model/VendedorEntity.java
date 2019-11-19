package model;

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
    @Column(name = "usuario_id", nullable = true, length = 35)
    private String usuarioId;

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

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendedorEntity that = (VendedorEntity) o;

        if (vendedorId != null ? !vendedorId.equals(that.vendedorId) : that.vendedorId != null) return false;
        if (usuarioId != null ? !usuarioId.equals(that.usuarioId) : that.usuarioId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vendedorId != null ? vendedorId.hashCode() : 0;
        result = 31 * result + (usuarioId != null ? usuarioId.hashCode() : 0);
        return result;
    }
}
