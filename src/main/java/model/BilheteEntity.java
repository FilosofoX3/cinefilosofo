package model;

import javax.persistence.*;

@Entity
@Table(name = "Bilhete", schema = "cinema", catalog = "")
public class BilheteEntity {
    private String bilheteId;
    private String clienteNome;
    private String clienteCpf;

    @Id
    @Column(name = "bilhete_id", nullable = false)
    public String getBilheteId() {
        return bilheteId;
    }

    public void setBilheteId(String bilheteId) {
        this.bilheteId = bilheteId;
    }

    @Basic
    @Column(name = "cliente_nome", nullable = true, length = 100)
    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    @Basic
    @Column(name = "cliente_cpf", nullable = true, length = 11)
    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BilheteEntity that = (BilheteEntity) o;

        if (bilheteId != null ? !bilheteId.equals(that.bilheteId) : that.bilheteId != null) return false;
        if (clienteNome != null ? !clienteNome.equals(that.clienteNome) : that.clienteNome != null) return false;
        if (clienteCpf != null ? !clienteCpf.equals(that.clienteCpf) : that.clienteCpf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bilheteId != null ? bilheteId.hashCode() : 0;
        result = 31 * result + (clienteNome != null ? clienteNome.hashCode() : 0);
        result = 31 * result + (clienteCpf != null ? clienteCpf.hashCode() : 0);
        return result;
    }
}
