package Datos;
import java.sql.*;
public class DConexion
{
    static String bd="tienda_cafeteria_pasteleria";
    static String usuario="DEIVY";
    static String clave="2003";
    static String url="jdbc:mysql://localhost/"+bd;
    static String dirDriv="com.mysql.jdbc.Driver";
    protected Connection conn;
    protected Statement stmt;
    
    public void conectar ()throws Exception
    {
        Class.forName(dirDriv);
        this.conn =DriverManager.getConnection(url,usuario,clave);
        this.stmt=conn.createStatement();
        System.out.println("Conecto con exito");
    }
    public void desconectar()throws Exception
    {
        if(stmt != null && conn!=null)
        {
            try
            {
                this.stmt.close();
                this.conn.close();
            }
            catch (SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    
    
    // Método para obtener la conexión
    public Connection getConnection() {
        return this.conn; // Devolver la conexión
    }
    public void insertDate(String sql) throws Exception
    {
        conectar();
        stmt.execute(sql);
        desconectar();
    }
    public void updateDate (String sql) throws Exception
    {
        conectar();
        stmt.executeUpdate(sql);
        desconectar();
    }
    public void deleteDate (String sql) throws Exception
    {
        conectar();
        stmt.executeUpdate(sql);
        desconectar();
    }
    public ResultSet showDate(String sql) throws Exception
    {
        ResultSet rs;
        conectar();
        rs=stmt.executeQuery(sql);
        desconectar();
        return rs;
    }
}