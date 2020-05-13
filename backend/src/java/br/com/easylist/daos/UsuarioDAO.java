/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easylist.daos;

import br.com.easylist.entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {

    private Connection conexao;
    private String url = "jdbc:mysql://localhost/easylist"; //Nome da base de dados
    private String user = "root"; //nome do usuário do MySQL
    private String password = ""; //senha do MySQL

    public UsuarioDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int save(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario VALUES (null,?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getSenha());
        preparedStatement.setBoolean(4, usuario.isInativo());
       
        return preparedStatement.executeUpdate();
    }

    public int update(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET  nome = ?, email = ?, senha = ? WHERE id = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getSenha());
        preparedStatement.setInt(4, usuario.getId());
        return preparedStatement.executeUpdate();
    }
    
    public List<Usuario> selects(String nome) throws SQLException {
        String sql = null;
        if (nome == null || nome.isEmpty()) {
            sql = "SELECT * FROM usuario";
        } else {
            sql = "SELECT * FROM usuario WHERE nome like '%" + nome + "%'";
        }
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Usuario> results = new ArrayList();
        while (resultSet.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            results.add(usuario);
        }
        return results;
    }

    public Usuario select(String nome, String senha) throws SQLException {
        String sql = "SELECT id, nome FROM usuario WHERE email = ? && senha = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, senha);
        ResultSet resultSet = preparedStatement.executeQuery();
        Usuario usuario = null;
        if (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            return usuario;
        } else {
            return null;
        }
    }
public Usuario delete(int id) throws SQLException {
      
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        
            return null;
    }

    
     public Usuario selectUser(int id) throws SQLException {
        String sql = "SELECT u.id, u.nome, u.email,u.senha, u.inativo FROM usuario as u WHERE id = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Usuario usuario = null;
        if (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setInativo(resultSet.getBoolean("inativo"));
            return usuario;
        } else {
            return null;
        }
    }
    public boolean closeConnection() {
        try {
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

  


}
