package model;

import javax.persistence.*;

@Entity
@Table(name = "clienteinteresse", schema = "cinema")
public class ClienteInteresseEntity {
    @Id
    @Column(name = "interesse_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interesseId;

    @Basic
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Basic
    @Column(name = "genero_id", nullable = false)
    private Long generoId;

    public Long getInteresseId() {
        return interesseId;
    }

    public void setInteresseId(Long interesseId) {
        this.interesseId = interesseId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteInteresseEntity that = (ClienteInteresseEntity) o;

        if (interesseId != null ? !interesseId.equals(that.interesseId) : that.interesseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return interesseId != null ? interesseId.hashCode() : 0;
    }
}
