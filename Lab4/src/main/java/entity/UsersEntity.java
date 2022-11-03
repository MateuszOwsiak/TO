package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@NamedQuery(
        name = "UsersByLogin",
        query = "SELECT t from UsersEntity t WHERE t.uLogin=?1"
)

@Entity
@Table(name = "users", schema = "lab3")
public class UsersEntity implements IUser{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "u_id")
    private int uId;
    @Basic
    @Column(name = "u_login")
    private String uLogin;
    @Basic
    @Column(name = "u_imie")
    private String uImie;
    @Basic
    @Column(name = "u_nazwisko")
    private String uNazwisko;
    @Basic
    @Column(name = "u_haslo")
    private String uHaslo;
    @OneToMany(mappedBy = "usersByNuId")
    private Collection<NotesEntity> notesByUId;

    public static TypedQuery<UsersEntity> getUsersByLogin(EntityManager man, String login){
        return man.createNamedQuery("UsersByLogin",UsersEntity.class).setParameter(1,login);
    }


    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuLogin() {
        return uLogin;
    }

    public void setuLogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getuImie() {
        return uImie;
    }

    public void setuImie(String uImie) {
        this.uImie = uImie;
    }

    public String getuNazwisko() {
        return uNazwisko;
    }

    public void setuNazwisko(String uNazwisko) {
        this.uNazwisko = uNazwisko;
    }

    public String getuHaslo() {
        return uHaslo;
    }

    public void setuHaslo(String uHaslo) {
        this.uHaslo = uHaslo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (uId != that.uId) return false;
        if (uLogin != null ? !uLogin.equals(that.uLogin) : that.uLogin != null) return false;
        if (uImie != null ? !uImie.equals(that.uImie) : that.uImie != null) return false;
        if (uNazwisko != null ? !uNazwisko.equals(that.uNazwisko) : that.uNazwisko != null) return false;
        if (uHaslo != null ? !uHaslo.equals(that.uHaslo) : that.uHaslo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (uLogin != null ? uLogin.hashCode() : 0);
        result = 31 * result + (uImie != null ? uImie.hashCode() : 0);
        result = 31 * result + (uNazwisko != null ? uNazwisko.hashCode() : 0);
        result = 31 * result + (uHaslo != null ? uHaslo.hashCode() : 0);
        return result;
    }

    public Collection<NotesEntity> getNotesByUId() {
        return notesByUId;
    }

    public void setNotesByUId(Collection<NotesEntity> notesByUId) {
        this.notesByUId = notesByUId;
    }

    @Override
    public void create(EntityManager man) {
        String tytul, tresc="";
        System.out.println("TWORZENIE NOWEJ NOTATKI");
        Scanner in = new Scanner(System.in);
        System.out.print("Tytuł notatki: ");
        tytul = in.nextLine();
        System.out.println("Treść notatki: ");
        tresc = in.nextLine();
        EntityTransaction tr = man.getTransaction();
        try {
            tr.begin();
            NotesEntity newNote = new NotesEntity();
            newNote.setTytul(tytul);
            newNote.setTresc(tresc);
            newNote.setNuId(this.uId);
            this.setNotesByUId(new ArrayList<NotesEntity>());
            this.getNotesByUId().add(newNote);
            newNote.setUsersByNuId(this);
            man.persist(newNote);
            tr.commit();
        }finally {
            if(tr.isActive())tr.rollback();
        }
    }

    @Override
    public void read(EntityManager man) {
        Scanner in = new Scanner(System.in);
        int choice;
        System.out.println("TWOJE NOTATKI");
        List<NotesEntity> notes = NotesEntity.getNotesByUID(man,this.getuId()).getResultList();
        if(notes.size()== 0){
            System.out.println("Nie masz żadnej notatki do wyświetlenia");
        }
        else {
            System.out.println("Którą notatkę chcesz wyświetlic: ");
            for (int i = 1; i <= notes.size(); i++) {
                System.out.println(i + "." + notes.get(i - 1).getTytul());
            }
            while (true) {
                System.out.print("Wybór: ");
                choice = Integer.parseInt(in.nextLine());
                if (choice <= 0 || choice > notes.size()) {
                    System.out.println("Nieprawidłowy wybór");
                }
                else{
                    System.out.println(notes.get(choice-1).getTresc());
                    break;
                }
            }
        }
    }

    @Override
    public void update(EntityManager man) {
        EntityTransaction tr = man.getTransaction();
        try{
            tr.begin();
            Scanner in = new Scanner(System.in);
            int choice;
            System.out.println("TWOJE NOTATKI");
            List<NotesEntity> notes = NotesEntity.getNotesByUID(man,this.uId).getResultList();
            if(notes.size()== 0){
                System.out.println("Nie masz żadnej notatki do edytowania");
            }else{
                System.out.println("Którą notatkę chcesz edytować: ");
                for (int i = 1; i <= notes.size(); i++) {
                    System.out.println(i + "." + notes.get(i - 1).getTytul());
                }
                while (true) {
                    System.out.print("Wybór: ");
                    choice = Integer.parseInt(in.nextLine());
                    if (choice <= 0 || choice > notes.size()) {
                        System.out.println("Nieprawidłowy wybór");
                    } else {
                        System.out.println("Podaj nową treść notatki: ");
                        String tresc = in.nextLine();
                        notes.get(choice-1).setTresc(tresc);
                        System.out.println("Pomyślnie edytowano notakę");
                        tr.commit();
                        break;
                    }
                }
            }
        }finally {
            if(tr.isActive())tr.rollback();
        }
    }

    @Override
    public void delete(EntityManager man) {
        EntityTransaction tr = man.getTransaction();
        try{
            tr.begin();

            Scanner in = new Scanner(System.in);
            int choice;
            System.out.println("TWOJE NOTATKI");
            List<NotesEntity> notes = NotesEntity.getNotesByUID(man,this.uId).getResultList();
            if(notes.size()== 0){
                System.out.println("Nie masz żadnej notatki do usunięcia");
            }
            else {
                System.out.println("Którą notatkę chcesz usunąć: ");
                for (int i = 1; i <= notes.size(); i++) {
                    System.out.println(i + "." + notes.get(i - 1).getTytul());
                }
                while (true) {
                    System.out.print("Wybór: ");
                    choice = Integer.parseInt(in.nextLine());
                    if (choice <= 0 || choice > notes.size()) {
                        System.out.println("Nieprawidłowy wybór");
                    }
                    else{
                        NotesEntity n = man.find(NotesEntity.class,notes.get(choice-1).getnId());
                        man.remove(n);
                        man.flush();
                        System.out.println("Pomyślnie usunięto notatkę");
                        tr.commit();
                        break;
                    }
                }
            }
        }finally{
            if(tr.isActive())tr.rollback();;
        }
    }
}
