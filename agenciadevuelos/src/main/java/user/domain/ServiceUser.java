package user.domain;

public interface ServiceUser {
    
void CreateUser(User user);
User UpdateUserById(int id,String user,String contraseña,int rolnumber);
User FindUserById(int id);
User ValidationUser(int id,String contraseña);
}
