package model;

import javax.persistence.*;

@Entity
@Table(name = "cliente", schema = "cinema")
public class ClienteEntity {
    @Id
    @Column(name = "cliente_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Basic
    @Column(name = "pessoa_id", nullable = false)
    private Long pessoaId;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (clienteId != null ? !clienteId.equals(that.clienteId) : that.clienteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return clienteId != null ? clienteId.hashCode() : 0;
    }
}
