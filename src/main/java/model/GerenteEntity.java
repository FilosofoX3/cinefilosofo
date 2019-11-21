package model;

import javax.persistence.*;
import controller.BilheteriaBiz;

@Entity
@Table(name = "Gerente", schema = "cinema")
public class GerenteEntity {
    @Id
    @Column(name = "gerente_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gerenteId;

    @Basic
    @Column(name = "funcionario_id", nullable = false)
    private Long funcionarioId;

    public Long getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(Long gerenteId) {
        this.gerenteId = gerenteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GerenteEntity that = (GerenteEntity) o;

        if (gerenteId != null ? !gerenteId.equals(that.gerenteId) : that.gerenteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gerenteId != null ? gerenteId.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
       return new BilheteriaBiz().getPessoaNome(getFuncionarioId());
    }
}
