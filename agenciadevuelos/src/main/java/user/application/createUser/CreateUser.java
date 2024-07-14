package user.application.createUser;
import user.domain.User;
import user.domain.ServiceUser;

public class CreateUser {
private ServiceUser serviceAuthUser;

public CreateUser(ServiceUser serviceAuthUser) {
    this.serviceAuthUser = serviceAuthUser;
}

 public void execute(User user) {
        serviceAuthUser.CreateUser(user);
    }

}
