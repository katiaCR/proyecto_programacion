/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author katia abigail
 */
public class Almacen {
    private String id;
    private String razonSocial;
    private String sedeSocial;
    private String telf;
    private int codPostal;

    public Almacen(String razonSocial, String sedeSocial, String telf, int codPostal) {
        this.razonSocial = razonSocial;
        this.sedeSocial = sedeSocial;
        this.telf = telf;
        this.codPostal = codPostal;
    }
    
    public Almacen(String id, String razonSocial, String sedeSocial, String telf, int codPostal) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.sedeSocial = sedeSocial;
        this.telf = telf;
        this.codPostal = codPostal;
    }

    public void muestraDatos(){
        System.out.println("id: " +  id + 
                " razon_social: " + razonSocial +
                " sede_social: " + sedeSocial +
                " teléfono_contacto: " + telf +
                " código_postal: " + codPostal);    
    }
    
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @return the sedeSocial
     */
    public String getSedeSocial() {
        return sedeSocial;
    }

    /**
     * @return the telf
     */
    public String getTelf() {
        return telf;
    }

    /**
     * @return the codPostal
     */
    public int getCodPostal() {
        return codPostal;
    }
    
    
    
}
