/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Datos.DataBase;

/**
 *
 * @author Alumno
 */
public class VentanaBaja extends Ventana{

    JLabel id;
    JTextField id;
    
    public VentanaBaja(DataBase bd) {
        super(bd);
    }

    @Override
    public void setTitle() {
        this.setTitle("Baja Almacén");
    }

    @Override
    public void confirmar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        etiquetas = new JLabel [nombreEtiquetas.length];        
        camposText =new JTextField[nombreEtiquetas.length];
        
        for (int x=0;x<nombreEtiquetas.length;x++) {
            camposText[x] = new JTextField();
            camposText[x].setName(nombreEtiquetas[x]);
            etiquetas[x]=new JLabel(nombreEtiquetas[x]);
            cuerpo.add(etiquetas[x]);
            cuerpo.add(camposText[x]);            
       }                
        contenedor.add(cuerpo);
    
    }
    
}
