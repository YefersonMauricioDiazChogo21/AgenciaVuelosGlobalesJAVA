package auth.application;
import auth.domain.AuthUser;
import auth.domain.ServiceAuthUser;

public class CreateUser {
private ServiceAuthUser serviceAuthUser;

public CreateUser(ServiceAuthUser serviceAuthUser) {
    this.serviceAuthUser = serviceAuthUser;
}

 public void execute(AuthUser authUser) {
        serviceAuthUser.CreateUser(authUser);
    }

}
