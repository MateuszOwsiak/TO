package entity;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.EntityManager;

public interface IUser {

    public void create(EntityManager man);
    public void read(EntityManager man);
    public void update(EntityManager man);
    public void delete(EntityManager man);

    public static String encrypt_password(String password){
        String encrypted_pass = BCrypt.hashpw(password,BCrypt.gensalt());
        return encrypted_pass;
    }

    public static boolean check_password(String candidate_password,String encrypted_password){
        if(BCrypt.checkpw(candidate_password,encrypted_password))
            return true;
        else
            return false;
    }
}
