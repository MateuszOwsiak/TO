package entity;

import javax.persistence.*;

@NamedQuery(
        name = "NotesByUID",
        query = "SELECT t from NotesEntity t WHERE t.nuId=?1"
)
@Entity
@Table(name = "notes", schema = "lab3")
public class NotesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "n_id")
    private int nId;
    @Basic
    @Column(name = "nu_id")
    private Integer nuId;
    @Basic
    @Column(name = "tytul")
    private String tytul;
    @Basic
    @Column(name = "tresc")
    private String tresc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nu_id", referencedColumnName = "u_id",insertable = false,updatable = false)
    private UsersEntity usersByNuId;

    public static TypedQuery<NotesEntity>getNotesByUID(EntityManager man, int ID){
        return man.createNamedQuery("NotesByUID", NotesEntity.class).setParameter(1,ID);
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public Integer getNuId() {
        return nuId;
    }

    public void setNuId(Integer nuId) {
        this.nuId = nuId;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotesEntity that = (NotesEntity) o;

        if (nId != that.nId) return false;
        if (nuId != null ? !nuId.equals(that.nuId) : that.nuId != null) return false;
        if (tytul != null ? !tytul.equals(that.tytul) : that.tytul != null) return false;
        if (tresc != null ? !tresc.equals(that.tresc) : that.tresc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nId;
        result = 31 * result + (nuId != null ? nuId.hashCode() : 0);
        result = 31 * result + (tytul != null ? tytul.hashCode() : 0);
        result = 31 * result + (tresc != null ? tresc.hashCode() : 0);
        return result;
    }

    public UsersEntity getUsersByNuId() {
        return usersByNuId;
    }

    public void setUsersByNuId(UsersEntity usersByNuId) {
        this.usersByNuId = usersByNuId;
    }
}
