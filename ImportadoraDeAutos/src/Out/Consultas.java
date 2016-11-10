/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miler
 */
public class Consultas {
    
    
  ConexionBD con = new ConexionBD();
    Connection cn = con.conexion();
    
    
    public  DefaultTableModel obtenerVentas (){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID/ ventas");
        modelo.addColumn("Comprador");
        modelo.addColumn("Modelo de Auto");
        modelo.addColumn("Tipo de venta");
        
        
        String sql = "SELECT * FROM DetalleVenta";
        String datos[] = new String [4];
        Statement st;
        try{
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    modelo.addRow(datos);
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
               
    }
    public  DefaultTableModel  pedidos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID/ Pedido ");
        modelo.addColumn("Proveedora");
        modelo.addColumn("Fecha");
        modelo.addColumn("Modelo");
        
        
        String sql = "select Pedido.idPedido, Proveedor.Nombre , Pedido.fecha, Modelo.modelo from Pedido, DetallePedido, Vehiculo, Modelo, Proveedor where Pedido.idPedido = DetallePedido.Pedido and DetallePedido.Vehiculo = Vehiculo.nroMotor and Modelo.idModelo = Vehiculo.modelo and Proveedor.idProveedor = Pedido.proveedora";
              
        String datos[] = new String [4];
        Statement st;
        try{
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    modelo.addRow(datos);
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
               
    }
    
    
    
    
    
    public void reg(String ci,String nombre ,String apellidos ,String direccion )
    {
     try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO cliente (Nombre,dirección,crédito) VALUES (?,?,?)");
            pps.setString(1, ci);
            pps.setString(2, nombre);
            pps.setString(3, apellidos);

            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
            

        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    
    
    public ArrayList departementos(){
        
        
        ArrayList<String> departamento;
        departamento = new ArrayList();
        try {
            PreparedStatement departamentos = cn.prepareStatement("SELECT Departamento FROM Departamento");
            ResultSet deps = departamentos.executeQuery();
            while (deps.next()) {
                departamento.add(deps.getString("Departamento"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;
        
        
       
    }
    
    
    
    public ArrayList Herramientas(){
        
        
        ArrayList<String> Herramienta;
        Herramienta = new ArrayList();
        try {
            PreparedStatement Herramientas = cn.prepareStatement("SELECT Herramienta FROM Herramienta");
            ResultSet deps = Herramientas.executeQuery();
            while (deps.next()) {
                Herramienta.add(deps.getString("Herramienta"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Herramienta;
        
        
       
    }
    
    
    
    
    
    
    
    
}
