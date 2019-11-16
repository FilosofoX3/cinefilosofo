package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SessaoDia", schema = "cinema", catalog = "")
public class SessaoDiaEntity {
    private String sessaoDiaId;
    private Date dia;

    @Id
    @Column(name = "sessao_dia_id", nullable = false)
    public String getSessaoDiaId() {
        return sessaoDiaId;
    }

    public void setSessaoDiaId(String sessaoDiaId) {
        this.sessaoDiaId = sessaoDiaId;
    }

    @Basic
    @Column(name = "dia", nullable = true)
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessaoDiaEntity that = (SessaoDiaEntity) o;

        if (sessaoDiaId != null ? !sessaoDiaId.equals(that.sessaoDiaId) : that.sessaoDiaId != null) return false;
        if (dia != null ? !dia.equals(that.dia) : that.dia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessaoDiaId != null ? sessaoDiaId.hashCode() : 0;
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        return result;
    }
}
