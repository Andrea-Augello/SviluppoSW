package Autenticazione;

import javax.swing.*;

public abstract class LoginForm {

    protected LoginControl control;
    protected JFrame frame;

    public LoginForm(LoginControl control) {
        this.control = control;
    }

    abstract public void reset();

    abstract public void dispose();
}
