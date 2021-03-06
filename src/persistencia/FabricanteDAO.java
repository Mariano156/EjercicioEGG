/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Fabricante;
import excepcion.MiExcepcion;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante f) throws MiExcepcion {
        try {
            if (f == null) {
                throw new MiExcepcion("FABRICANTE INVÁLIDO");
            }
            // SENTENCIA SQL DE INSERCIÓN -- INSERT INTO `tienda`.`fabricante` (`codigo`, `nombre`) VALUES ('10', 'pHILLIPS');
            String sql = "INSERT INTO fabricante (codigo, nombre) "
                    + "VALUES('" + f.getCodigo()
                    + "', '" + f.getNombre() + "');";
            insertarModificarEliminar(sql);

        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR USUARIO");
        }

    }

    public Fabricante buscarFabricantePorCodigo(int cod) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + cod + "';";
            consultarBase(sql);
            Fabricante f = null;

            while (resultado.next()) {
                f = new Fabricante();

                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
            }
            return f;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIO");
        } finally {
            desconectarBase();
        }

    }

    public void modificarFabricante(Fabricante f) throws MiExcepcion {

        try {
            if (f == null) {
                throw new MiExcepcion("FABRICANTE INVÁLIDO");
            }
            // SENTENCIA SQL DE MODIFICACIÓN
            String sql = "UPDATE fabricante SET nombre = '" + f.getNombre() + "', "
                    + "WHERE codigo = '" + f.getCodigo() + "';";

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR FABRICANTE");
        }

    }

}
