package Autenticazione;

import javax.swing.*;

public abstract class LoginForm {

    protected LoginControl control;
    protected JFrame frame;

    public LoginForm(LoginControl control) {
        this.control = control;
    }

    public void dispose() {
        frame.dispose();
    }

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract void reset();
}
