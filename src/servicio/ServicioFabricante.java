/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Fabricante;
import excepcion.MiExcepcion;
import persistencia.FabricanteDAO;

/**
 *
 * @author admin
 */
public class ServicioFabricante {

    private FabricanteDAO f;

    public ServicioFabricante() {
        f = new FabricanteDAO();
    }

    public void crearFabricante(Integer codigo, String nombre) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }

            Fabricante fabricante = new Fabricante();

            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            f.guardarFabricante(fabricante);

        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void modificarFabricante(Integer codigo, String nombre) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }

            Fabricante fabricante = f.buscarFabricantePorCodigo(codigo);

            if (fabricante == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }

            fabricante.setNombre(nombre);

            f.modificarFabricante(fabricante);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void eliminarFabricante(Integer cod) throws MiExcepcion {
        try {
            if (cod == null || cod) {
                throw new MiExcepcion("DEBE INGRESAR UN CORREO");
            }

            Usuario fabricante = fabricanteDAO.buscarUsuarioPorCorreo(correo);

            if (fabricante == null) {
                throw new MiExcepcion("EL CORREO INGRESADO NO ESTÁ ASOCIADO A NINGÚN USUARIO");
            }

            fabricanteDAO.eliminarUsuario(correo);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void imprimirUsuarios() throws MiExcepcion {
        try {
            List<Fabricante> fabricantes = f.obtenerFabricante();

            if (fabricantes.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN USUARIOS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-20s%-15s%-15s\n", "CORREO", "NOMBRE", "APELLIDO"); // FORMATO DE IMPRESIÓN
                for (Fabricante aux : fabricantes) {
                    System.out.println(aux);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

}
