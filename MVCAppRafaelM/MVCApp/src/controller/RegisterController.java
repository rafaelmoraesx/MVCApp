package controller;

import model.User;
import model.UserModel;
import view.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;

public class RegisterController {
    private UserModel model;
    private RegisterView view;

    public RegisterController(UserModel model, RegisterView view) {
        this.model = model;
        this.view = view;

        this.view.addRegisterListener(new RegisterListener());
        this.view.addLoginListener(new LoginListener());
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            if (!username.isEmpty() && !password.isEmpty()) {
                model.addUser(new User(username, password));
                JOptionPane.showMessageDialog(view, "Registro feito com sucesso");
                view.dispose();
                new LoginView();
            } else {
                JOptionPane.showMessageDialog(view, "Registro não sucedido, campo não preenchido");
            }
        }
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            new LoginView();
        }
    }
}
