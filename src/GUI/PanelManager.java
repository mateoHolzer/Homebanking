package GUI;

import Entidades.Usuario;

import javax.swing.*;

public class PanelManager {

    private PanelListaUsuarios panelListaUsuarios;
    private PanelFormularioUsuarios panelFormularioUsuario;
    private PanelLogIn panelLogIn;

    private JFrame frame;

    public void armarPanelManager(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelLogIn = new PanelLogIn();
        panelLogIn.armarLoginUsuarios(this);

        panelFormularioUsuario = new PanelFormularioUsuarios();
        panelFormularioUsuario.armarPanelFormularioUsuarios(this);

        panelListaUsuarios = new PanelListaUsuarios();
        panelListaUsuarios.armarPanelListaUsuarios(this);


        frame.setVisible(true);
        frame.pack();
    }

    public void mostrarLoginUsuario(PanelManager panelManager){
        panelLogIn.armarLoginUsuarios(panelManager);
        mostrar(panelLogIn);
    }

    public void mostrarFormularioUsuario(){
        panelFormularioUsuario.vaciarComponentes();
        mostrar(panelFormularioUsuario);
    }

    public void mostrarFormularioUsuario(Usuario usuario){
        panelFormularioUsuario.armarPanelFormularioUsuario(usuario);
        mostrar(panelFormularioUsuario);
    }

    public void mostrarListaUsuario(){
        panelListaUsuarios.refrezcarListado();
        mostrar(panelListaUsuarios);
    }

    private void mostrar(JPanel panel){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.pack();
    }
}
