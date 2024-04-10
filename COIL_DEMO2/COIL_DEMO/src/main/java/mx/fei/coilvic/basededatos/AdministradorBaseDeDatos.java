/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elrevo
 */
public class AdministradorBaseDeDatos {
    private Connection conexion;
    private final String BASEDEDATOS_NOMBRE="jdbc:mysql://127.0.0.1/coil_vic";
    private final String BASEDEDATOS_USUARIO="admincoilvic";
    private final String BASEDEDATOS_CONTRASENA="1234";
    
    public Connection obtenerConexion() throws SQLException{
        conectar();
        return conexion;
    }
    
    private void conectar() throws SQLException{
        conexion=DriverManager.getConnection(BASEDEDATOS_NOMBRE,BASEDEDATOS_USUARIO,BASEDEDATOS_CONTRASENA);
    }
    
    public void cerrarConexion(){
        if(conexion!=null){
            try {
                if(!conexion.isClosed()){
                    conexion.close();
                }
            } catch (SQLException exception) {                
                Logger.getLogger(AdministradorBaseDeDatos.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }
    
     
}
