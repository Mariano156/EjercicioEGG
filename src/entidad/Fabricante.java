/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author admin
 */
public class Fabricante {
    private String nombre;  
  private int codigo;  

    public Fabricante() {
    }

    public Fabricante(String nombre, int codigoFabricante) {
        this.nombre = nombre;
        this.codigo = codigoFabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
    

