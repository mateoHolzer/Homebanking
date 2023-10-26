package com.company;

import Entidades.Usuario;
import Service.ServiceException;
import Service.UsuarioService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hola mundo, este va a ser un homebanking algun dia");

        UsuarioService usuarioService = new UsuarioService();

        Usuario usuario1 = new Usuario();
        usuario1.setDNI(44236662);
        usuario1.setNombre("Mateo");
        usuario1.setApellido("Holzer");
        /*
        try {
            usuarioService.guardarUsuario(usuario1);
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        Usuario usuario2 = null;
        try {
            usuario2 = usuarioService.buscarUsuario(44236662);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println("DNI: " + usuario2.getDNI() + " Nombre: " + usuario2.getNombre() + " Apellido: " + usuario2.getApellido());



        try {
            usuarioService.eliminarUsuario(44236662);
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        Usuario usuario3 = null;

        try {
            usuario3 = usuarioService.buscarUsuario(44236662);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        usuario3.setNombre("Mateo Luciano");

        try {
            usuarioService.modificarUsuario(usuario3);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        */

        ArrayList usuarios = null;

        try {
            usuarios = usuarioService.buscarTodos();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        for(Object obj : usuarios){
            Usuario us = (Usuario) obj;
            System.out.println("DNI: " + us.getDNI() + " Nombre y Apellido: " + us.getApellido() + ", " + us.getNombre());
        }

    }
}
