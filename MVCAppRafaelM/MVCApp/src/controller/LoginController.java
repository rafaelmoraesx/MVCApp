package controller;

import model.UserModel;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RegisterView;

public class LoginController {
    private final UserModel model;
    private final LoginView view;

    public LoginController(UserModel model, LoginView view) {
        this.model = model;
        this.view = view;

        this.view.addLoginListener(new LoginListener());
        this.view.addRegisterListener(new RegisterListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            if (model.authenticate(username, password) != null) {
                JOptionPane.showMessageDialog(view, "Login feito com sucesso");
              
            } else {
                JOptionPane.showMessageDialog(view, "Nome ou senha incorreta");
            }
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            new RegisterView();
        }
    }
}
