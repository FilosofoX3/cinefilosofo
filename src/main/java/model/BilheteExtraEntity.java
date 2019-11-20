package model;

import javax.persistence.*;

@Entity
@Table(name = "bilheteextra", schema = "cinema")
public class BilheteExtraEntity {
    @Id
    @Column(name = "bilhete_extra_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bilheteExtraId;

    @Basic
    @Column(name = "extra_id", nullable = false)
    private Long extraId;

    @Basic
    @Column(name = "bilhete_id", nullable = false)
    private Long bilheteId;

    public Long getBilheteExtraId() {
        return bilheteExtraId;
    }

    public void setBilheteExtraId(Long bilheteExtraId) {
        this.bilheteExtraId = bilheteExtraId;
    }

    public Long getExtraId() {
        return extraId;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }

    public Long getBilheteId() {
        return bilheteId;
    }

    public void setBilheteId(Long bilheteId) {
        this.bilheteId = bilheteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BilheteExtraEntity that = (BilheteExtraEntity) o;

        if (bilheteExtraId != null ? !bilheteExtraId.equals(that.bilheteExtraId) : that.bilheteExtraId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bilheteExtraId != null ? bilheteExtraId.hashCode() : 0;
    }
}
