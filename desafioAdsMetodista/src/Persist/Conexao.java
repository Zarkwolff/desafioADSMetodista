
package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    //Criando a conexão com o banco
    public Connection getConnection(){
        try{
            String servidor = "jdbc:mysql://localhost:3306/condominio";
            String user = "root";
            String pass = "";
            
            return DriverManager.getConnection(servidor, user, pass);
        }
        catch(SQLException e){
            
            throw new RuntimeException(e);
        }   
    }
}
