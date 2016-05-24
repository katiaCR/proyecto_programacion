/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Almacen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Alumno2
 */
public class DataBase {
    
    String servidor= "jdbc:oracle:thin:@localhost:";
    String bd;/*= "1521:xe";*/
    String password;/*= "case";*/
    String user;/*= "central";*/
    Connection conexion=null;
    
    public DataBase(String bd, String user, String password) {
        this.bd = bd;
        this.user = user;
        this.password = password;
    }
    
    public boolean buscaRegistro(String nombreBuscar){
        return false;
    }
    
    public boolean abrirConexion() {
        boolean estado = false;
        
        try {
            //Cargamos el driver
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new OracleDriver());
            //Crear conexion a la BDD
            conexion = DriverManager.getConnection(servidor + bd, user, password);
            estado = true;
        } catch (SQLException ex) { System.out.println("SQL Exception: " +ex.getLocalizedMessage());
        } catch (Exception ex) { System.out.println("Exception General: " +ex.getLocalizedMessage());
        }
        
        return estado;
    }
    
    private boolean compruebaID(String cadena){
        return cadena.length()>0 && cadena.length() <=4;
    }
     
     public void alta(Almacen al){
        PreparedStatement st;
        //sustituimos las variables por un ?        
        String sentencia = 
        "INSERT INTO almacenes (id_almacen, razon_social , sede_social, telefono_contacto, codigo_postal) VALUES (id_alm_sec.NEXTVAL,?,?,?,?)";
        
        String datos[]=al.getDatos();
        System.out.println(sentencia);
        try{
            st= conexion.prepareStatement(sentencia);
            st.setString(1,datos[0]);
            st.setString(2,datos[1]);
            st.setString(3,datos[2]);
            st.setInt(4,al.getCodPostal());
            System.out.println("Alta: " + st.toString());
            st.executeUpdate();
            st.close();        
            
        } catch (SQLException ex) {
            System.out.println("Error con la base de datos: " + ex.getMessage());
        }
    }
    
     public int baja(Almacen al){      
        int n=0;
        PreparedStatement st;
        String sentencia = "DELETE FROM almacenes WHERE id_almacen = ?";
         
         try{
            st= conexion.prepareStatement(sentencia);
            st.setString(1,al.getId());
            System.out.println("Baja: " + st.toString());
            //en la n estara la sentencia que deseas ejecutar
            n = st.executeUpdate();
            st.close();        
        } catch (SQLException ex) {
            System.out.println("Error con la base de datos: " + ex.getMessage());
        }
         finally {
             return n;
         }
    }
     
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch(SQLException e) { System.out.println(e.getMessage());
        }
    }
    
    public void cierraResultSet(ResultSet rs) {
        try {
            //cerramos el rs. porque garbage no puede eliminar el heap
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error con la base de datos: " + ex.getMessage());
        }
    }
    public int ejecutaUpdate(String statement) {
        int n = 0;
        
        try {
            Statement st = conexion.createStatement();
            System.out.println("Sentencia: " +statement);
            n = st.executeUpdate(statement); //Para que la ejecute.
        } catch (SQLException ex) {
            System.out.println("Exception: " +ex.getLocalizedMessage());
        }
        
        return n;
    }
    
    public ResultSet ejecutaConsulta(String consulta){
        Statement st=null;
        ResultSet rs =null;
        try {
            st=conexion.createStatement();
            rs=st.executeQuery(consulta);
            
        } catch (SQLException ex) {
            System.out.println("Error sql: " + ex.getMessage());
        }
        return rs;
    }
    
    public void recorreResultado(ResultSet rs){
        try{
            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3)+ "\t" + rs.getString(4));
            }
        }catch(SQLException ex){
            System.out.println("Error sql: " + ex.getMessage());
        }
    }
    
    public ArrayList listado(){
        //con el get string del rs hacer uno y guardarlo en un alumno
        // en el constructor del alumno nombre sera getstring(1) y asi guardar en un alumno y luego el alumno en un arraylist
        ArrayList <Almacen> listado = null;  
        if(abrirConexion()){
            ResultSet rs= null;
            rs=ejecutaConsulta("SELECT * from alumnos");
            
            try {
                while(rs.next()){
                    listado.add(new Almacen(rs.getString(1),rs.getString(3), rs.getString(5), rs.getString(6), rs.getInt(7)));                    
                }
                
            } catch (SQLException ex) {
                System.out.println("Error al cargar datos");
            }
            cierraResultSet(rs);
            return listado;
        }else{
            System.out.println("No se han encontrado Alumno");
            return listado;
        }
    }
    
}
    /*
    PreparesStatement updateSales =con.prepareStatement("UPDATECOFFEES SET SALES =? WHERE COF_NAME LIKE ? ");
    updateSales.setInt(1; 75);
    updateSales.setString(2,"Colombia");
    updateSales.executeUpdate();
    */
    
    
    /*public int baja (String nombre){
    
    
    }*/
    