package herramientas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;





public class Conector {

    
    public Connection conectar(){
        
        Connection c = null;
        
        try {
        Class.forName("oracle.jdbc.OracleDriver").newInstance();
        c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "UREST","1234");
     
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("Error de conexion: "+ex.getMessage());
        }
        
        return c;
    }
    
    
    
    public void desconectar(Connection c){
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar:"+ex.getMessage());
        }
    }
    
    public void transacciones(Connection c, String sql){
        try {
            Statement st = c.createStatement();
            st.executeUpdate(sql);
            this.desconectar(c);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet consultas(Connection c, String sql){
    
        ResultSet rs = null;
        
        try {
            Statement st = c.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rs;
    }
    
    
    
    public int filas (Connection c,String sql){
    
            ResultSet rs = null;
            int filas = 0;
            
            
            
        try {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.last();
            filas = rs.getRow();
            rs.beforeFirst();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        return filas;
    }
    
    
    public int columnas(Connection c, String sql){
    
      
        ResultSet rs = null;
        int columnas = 0;
        
        try {
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    return columnas;
    }
    
    
    
    
    
    
    
    
    
}
