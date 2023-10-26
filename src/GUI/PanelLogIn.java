package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogIn extends JPanel {

    private JPanel panelComponentes;
    JLabel jLabelUsuario;
    JLabel jLabelPassword;
    JTextField jTextFieldUsuario;
    JPasswordField jPasswordField;
    JLabel jLabelMensaje;

    private JPanel panelBotonera;
    JButton jButtonOK;
    JButton jButtonCancelar;

    PanelManager panelManager;

    public void armarLoginUsuarios(PanelManager panelManager){

        this.panelManager = panelManager;
        jLabelUsuario = new JLabel("Usuario: ");
        jLabelPassword = new JLabel("Password");
        jTextFieldUsuario = new JTextField(20);
        jPasswordField = new JPasswordField();
        jLabelMensaje = new JLabel();

        panelComponentes = new JPanel(new GridLayout(3, 1));
        panelComponentes.add(jLabelUsuario);
        panelComponentes.add(jTextFieldUsuario);
        panelComponentes.add(jLabelPassword);
        panelComponentes.add(jPasswordField);
        panelComponentes.add(jLabelMensaje);

        setLayout(new BorderLayout());
        add(panelComponentes, BorderLayout.CENTER);

        panelBotonera = new JPanel();
        jButtonOK = new JButton("OK");
        jButtonCancelar = new JButton("Cancelar");

        panelBotonera.add(jButtonOK);
        panelBotonera.add(jButtonCancelar);

        add(panelBotonera, BorderLayout.SOUTH);
        setSize(450,350);



        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = jTextFieldUsuario.getText();
                String password = jPasswordField.getText();

                if (user.trim().equals("Administrador") && password.trim().equals("admin")) {
                    jLabelMensaje.setText(" Hola " + user + "");
                    panelManager.mostrarListaUsuario();
                } else {
                   jLabelMensaje.setText(" Usuario Incorrecto");
                }

            }
        });

    }




}
