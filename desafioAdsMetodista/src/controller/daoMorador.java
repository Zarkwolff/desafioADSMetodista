package controller;

import Persist.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
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
    
    public void consultar(Morador m){
        
        String sql = "SELECT * from morador WHERE idMorador ="+ m.getIdMorador();
        
        try{
            
        Statement smt = con.createStatement();
        
        ResultSet rs = smt.executeQuery(sql);
        
        if(rs.next()){
            m.setNome(rs.getString("nome"));
            m.setCpf(rs.getString("cpf"));
            m.setEndereco(rs.getString("endereço"));
            m.setCidade(rs.getString("cidade"));
            m.setTelefone(rs.getString("telefone"));
            m.setEmail(rs.getString("email"));
        }else{
            JOptionPane.showMessageDialog(null, "Morador não"
                    + " cadastrado!");
        }
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    public void alterar(Morador m){
        
        String sql = "UPDATE morador SET nome=?, cpf=?, endereço=?, "
                + "cidade=?, telefone=?, email=? WHERE idMorador=?";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, m.getNome());
            smt.setString(2, m.getCpf());
            smt.setString(3,m.getEndereco());
            smt.setString(4, m.getCidade());
            smt.setString(5, m.getTelefone());
            smt.setString(6, m.getEmail());
            smt.setInt(7, m.getIdMorador());
            
            smt.execute();
            smt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    public void deletar(Morador m){
        
        String sql = "DELETE from morador WHERE idMorador=?";
        
        try{
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, m.getIdMorador());
        
        smt.execute();
        smt.close();
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
