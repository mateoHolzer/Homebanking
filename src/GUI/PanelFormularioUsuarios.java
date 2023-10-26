package GUI;

import Entidades.Usuario;
import Service.ServiceException;
import Service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormularioUsuarios extends JPanel {

    //Componentes
    private JPanel panelComponentes;
    JLabel jLabelDNI;
    JLabel jLabelNombre;
    JLabel jLabelApellido;
    JTextField jTextFieldDNI;
    JTextField jTextFieldNombre;
    JTextField jTextFieldApellido;

    //Botones
    private JPanel panelBotonera;
    JButton jButtonGuardar;
    JButton jButtonCancelar;

    private boolean modificacion;

    PanelManager panelManager;

    public void armarPanelFormularioUsuario(Usuario usuario){

        jTextFieldDNI.setText(String.valueOf(usuario.getDNI()));
        jTextFieldNombre.setText(usuario.getNombre());
        jTextFieldApellido.setText(usuario.getApellido());
        modificacion = true;
    }

    public void vaciarComponentes(){
        jTextFieldDNI.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        modificacion = false;
    }


    public void armarPanelFormularioUsuarios(PanelManager panelManager){

        this.panelManager = panelManager;
        jLabelDNI = new JLabel("ID: ");
        jLabelNombre = new JLabel("Nombre: ");
        jLabelApellido = new JLabel("Apellido: ");
        jTextFieldDNI = new JTextField(20);
        jTextFieldNombre = new JTextField(20);
        jTextFieldApellido = new JTextField(20);

        panelComponentes = new JPanel(new GridLayout(3,2));
        panelComponentes.add(jLabelDNI);
        panelComponentes.add(jTextFieldDNI);
        panelComponentes.add(jLabelNombre);
        panelComponentes.add(jTextFieldNombre);
        panelComponentes.add(jLabelApellido);
        panelComponentes.add(jTextFieldApellido);

        setLayout(new BorderLayout());
        add(panelComponentes, BorderLayout.CENTER);


        panelBotonera = new JPanel();
        jButtonGuardar = new JButton("Guardar");
        jButtonCancelar = new JButton("Cancelar");

        panelBotonera.add(jButtonGuardar);
        panelBotonera.add(jButtonCancelar);

        add(panelBotonera, BorderLayout.SOUTH);

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setDNI(Integer.parseInt(jTextFieldDNI.getText()));
                usuario.setNombre(jTextFieldNombre.getText());
                usuario.setApellido(jTextFieldApellido.getText());

                UsuarioService usuarioService = new UsuarioService();
                try {
                    if(modificacion){
                        usuarioService.modificarUsuario(usuario);
                    }else {
                        usuarioService.guardarUsuario(usuario);
                    }
                } catch (ServiceException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE );
                }

                panelManager.mostrarListaUsuario();
            }
        });

        jButtonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarComponentes();
                panelManager.mostrarListaUsuario();
            }
        });




    }

}
