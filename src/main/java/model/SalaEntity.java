package model;

import javax.persistence.*;

@Entity
@Table(name = "Sala", schema = "cinema")
public class SalaEntity {
    @Id
    @Column(name = "sala_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaId;

    @Basic
    @Column(name = "capacidade", nullable = false)
    private Byte capacidade;

    @Basic
    @Column(name = "quatro_d", nullable = false)
    private Byte quatroD;

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }

    public Byte getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Byte capacidade) {
        this.capacidade = capacidade;
    }

    public Byte getQuatroD() {
        return quatroD;
    }

    public void setQuatroD(Byte quatroD) {
        this.quatroD = quatroD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaEntity that = (SalaEntity) o;

        if (salaId != null ? !salaId.equals(that.salaId) : that.salaId != null) return false;
        if (capacidade != null ? !capacidade.equals(that.capacidade) : that.capacidade != null) return false;
        if (quatroD != null ? !quatroD.equals(that.quatroD) : that.quatroD != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = salaId != null ? salaId.hashCode() : 0;
        result = 31 * result + (capacidade != null ? capacidade.hashCode() : 0);
        result = 31 * result + (quatroD != null ? quatroD.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return salaId.toString();
    }
}
