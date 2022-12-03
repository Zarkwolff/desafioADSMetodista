package controller;

import Persist.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.Morador;

public class daoMorador {
    
    private Connection con;
    
    //Criando o Construtor
    public daoMorador(){
        this.con = new Conexao().getConnection();
    }
    
    //Escrevendo os métodos para manipulação dos registros
    public void gravar(Morador m){
        
        String sql="INSERT INTO morador(nome, cpf, endereço, cidade, telefone,"
                + "email) VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, m.getNome());
            smt.setString(2, m.getCpf());
            smt.setString(3, m.getEndereco());
            smt.setString(4, m.getCidade());
            smt.setString(5, m.getTelefone());
            smt.setString(6, m.getEmail());
            smt.execute();
            smt.close();
            
        }
        catch (SQLException e){
            
            throw new RuntimeException(e);
        }
    }
    
}
