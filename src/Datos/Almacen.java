/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author katia abigail
 */
public class Almacen {
    private String id;
    private String razonSocial;
    private String sedeSocial;
    private String telf;
    private String codPostal;

    public Almacen(String razonSocial, String sedeSocial, String telf, String codPostal) {
        this.razonSocial = razonSocial;
        this.sedeSocial = sedeSocial;
        this.telf = telf;
        this.codPostal = codPostal;
    }
    
    public Almacen(String id, String razonSocial, String sedeSocial, String telf, String codPostal) {
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
    
    public String[] getDatos(){
        String[] datos=new String[4];
        datos[0]=getRazonSocial();
        datos[1]=getSedeSocial();
        datos[2]=getTelf();
        datos[3]=getCodPostal();
        
        return datos;
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
    public String getCodPostal() {
        return codPostal;
    }
    
    
    
}
