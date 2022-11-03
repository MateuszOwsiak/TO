package view;

import entity.UsersEntity;
import entity.IUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public interface IView {

    public void view();
    public static UsersEntity login(EntityManager man,String login,String haslo){
            List<UsersEntity>users = UsersEntity.getUsersByLogin(man,login).getResultList();
            for(UsersEntity u: users){
                String password = u.getuHaslo();
                if(IUser.check_password(haslo,password)){
                    return u;
                }
            }
        return null;
    }
    public static void register(EntityManager man,String login,String imie,String nazwisko,String haslo){

        EntityTransaction tr = man.getTransaction();
        try{
            tr.begin();
            UsersEntity newUserEntity = new UsersEntity();
            newUserEntity.setuImie(imie);
            newUserEntity.setuLogin(login);
            newUserEntity.setuNazwisko(nazwisko);
            newUserEntity.setuHaslo(haslo);
            man.persist(newUserEntity);
            tr.commit();
        }finally {
            if(tr.isActive())tr.rollback();
        }

    }

}
