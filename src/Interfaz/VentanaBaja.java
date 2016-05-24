/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Datos.Almacen;
import Datos.DataBase;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class VentanaBaja extends Ventana{

    JLabel etiquetaID;
    JTextField id;
    DataBase db;
    
    public VentanaBaja(DataBase db) {
        this.db=db;
    }

    @Override
    public void setTitle() {
        this.setTitle("Baja Almacén");
    }

    @Override
    public void confirmar() {
        if(id.getText().length()>0){
                if(db.baja(new Almacen(id.getText()))>0){
                    System.out.println("Almacen dado de baja con exito");
                    this.dispose();
                }
        } else{
            ventanaError("tienes que introducir un nombre");
        }
    }    
    @Override
    public void textoBotonAux() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aux() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void creaCuerpo() {   
        
        cuerpo.setLayout(new GridLayout(2,1,5,5));     
        //EL ID debe ser borrardo y en alta poner insert into (sec.nexvalue)
        String nombreEtiquetas [] = {"razón social", "sede social", "telefono contacto", "codigo postal"};               
        etiquetaID = new JLabel("id: ");        
        id =new JTextField();
        
            cuerpo.add(etiquetaID);
            cuerpo.add(id);            
        contenedor.add(cuerpo);    
    }
    
}
