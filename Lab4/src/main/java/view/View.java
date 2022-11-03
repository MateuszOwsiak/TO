package view;

import entity.IUser;
import entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class View implements IView{
    private Scanner in = new Scanner(System.in);
    public EntityManagerFactory fac;
    public EntityManager man;

    @Override
    public void view() {

        int choice;
        fac = Persistence.createEntityManagerFactory("default");
        man = fac.createEntityManager();
        while(true) {
            System.out.println("Aplikacja służąca do zarządzania notatkami");
            System.out.println("Wybierz jedną z opcji:");
            System.out.println("1.Zaloguj się");
            System.out.println("2.Załóż konto");
            System.out.println("3.Zakończ");
            System.out.print("Wybór: ");
            choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1: {
                    String login, haslo;
                    UsersEntity loggedUser;
                    System.out.println("LOGOWANIE");
                    while (true) {
                        System.out.print("Podaj login: ");
                        login = in.nextLine();
                        System.out.print("Podaj haslo: ");
                        haslo = in.nextLine();
                        loggedUser = IView.login(man, login, haslo);
                        if (loggedUser == null) {
                            System.out.println("Nieprawdiłowe dane, sprawdź jeszcze raz");
                        } else {
                            System.out.println("Pomyślnie zalogowano");
                            break;
                        }
                    }
                    boolean t = true;
                    while (t) {
                        System.out.println("Witaj " + loggedUser.getuImie() + " " + loggedUser.getuNazwisko() + "! Co chcesz zrobić: ");
                        System.out.println("1.Dodaj nową notatkę");
                        System.out.println("2.Przeglądnij swoje notatki");
                        System.out.println("3.Edytuj notatkę");
                        System.out.println("4.Usuń notatkę");
                        System.out.println("5.Wyloguj się");
                        System.out.print("Wybór: ");
                        choice = Integer.parseInt(in.nextLine());
                        switch (choice) {
                            case 1: {
                                try {
                                    loggedUser.create(man);
                                    System.out.println("Pomyślnie utworzono notatkę");
                                } catch (Exception ex) {
                                    System.out.println("Błąd podczas tworzenia notatki - " + ex.getStackTrace());
                                }
                            }
                            break;
                            case 2: {
                                loggedUser.read(man);
                            }
                            break;
                            case 3: {
                                try {
                                    loggedUser.update(man);
                                } catch (Exception ex) {
                                    System.out.println("Błąd podczas edytowania notatki - " + ex.getStackTrace());
                                }
                            }
                            break;
                            case 4: {
                                try {
                                    loggedUser.delete(man);
                                } catch (Exception ex) {
                                    System.out.println("Błąd podczas usuwania notatki - " + ex.getStackTrace());
                                }
                            }break;
                            case 5: {
                                System.out.println("Pomyślnie wylogowano!");
                                loggedUser = null;
                                t = false;
                            }
                            break;
                            default: {
                                System.out.println("Wybrano nieprawidłową opcje");
                            }
                            break;
                        }
                    }
                }
                break;
                case 2: {
                    String login, imie, nazwisko, haslo;
                    System.out.println("REJESTRACJA");
                    while (true) {
                        System.out.print("Podaj login: ");
                        login = in.nextLine();
                        List<UsersEntity> list = UsersEntity.getUsersByLogin(man, login).getResultList();
                        if (list.size() != 0) {
                            System.out.println("Podany login jest już w użyciu");
                        } else
                            break;
                    }
                    System.out.print("Podaj imie: ");
                    imie = in.nextLine();
                    System.out.print("Podaj nazwisko: ");
                    nazwisko = in.nextLine();
                    System.out.print("Podaj hasło: ");
                    haslo = in.nextLine();
                    IView.register(man, login, imie, nazwisko, IUser.encrypt_password(haslo));
                    System.out.println("Użytkownik zarejestrowany pomyślnie");
                }
                break;
                case 3: {
                    System.exit(0);
                }
                break;
                default: {
                    System.out.println("Nieprawidłowa opcja");
                }
                break;
            }
        }
    }
}
