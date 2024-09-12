import controller.RegisterController;
import controller.LoginController;
import model.UserModel;
import view.RegisterView;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();

        
        RegisterView registerView = new RegisterView();
        new RegisterController(model, registerView);

      
    }
}
