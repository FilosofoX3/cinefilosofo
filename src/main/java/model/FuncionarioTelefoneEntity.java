package model;

import javax.persistence.*;

@Entity
@Table(name = "FuncionarioTelefone", schema = "cinema")
public class FuncionarioTelefoneEntity {
    @Id
    @Column(name = "funcionario_telefone_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioTelefoneId;

    @Basic
    @Column(name = "funcionario_id", nullable = false)
    private Long funcionarioId;

    @Basic
    @Column(name = "telefone", nullable = true, length = 50)
    private String telefone;

    public Long getFuncionarioTelefoneId() {
        return funcionarioTelefoneId;
    }

    public void setFuncionarioTelefoneId(Long funcionarioTelefoneId) {
        this.funcionarioTelefoneId = funcionarioTelefoneId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuncionarioTelefoneEntity that = (FuncionarioTelefoneEntity) o;

        if (funcionarioTelefoneId != null ? !funcionarioTelefoneId.equals(that.funcionarioTelefoneId) : that.funcionarioTelefoneId != null)
            return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = funcionarioTelefoneId != null ? funcionarioTelefoneId.hashCode() : 0;
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        return result;
    }


}
