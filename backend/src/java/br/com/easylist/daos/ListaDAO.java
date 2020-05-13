/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easylist.daos;

import br.com.easylist.entidades.Lista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListaDAO {

    private Connection conexao;
    private String url = "jdbc:mysql://localhost/easylist"; //Nome da base de dados
    private String user = "root"; //nome do usuário do MySQL
    private String password = ""; //senha do MySQL

    public ListaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ListaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int save(Lista lista) throws SQLException {
        String sql = "INSERT INTO lista VALUES (null,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, lista.getNome());
        preparedStatement.setInt(2, lista.getUsuarioID());
        preparedStatement.setBoolean(3, lista.isInativo());
        return preparedStatement.executeUpdate();
    }

    public int update(Lista lista) throws SQLException {
        String sql = "UPDATE lista SET  nome = ? WHERE id = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, lista.getNome());
        preparedStatement.setInt(2, lista.getId());
        return preparedStatement.executeUpdate();
    }
    
        public List<Lista> selectsListsUser(int id) throws SQLException {
        String sql = null;
     
            sql = "SELECT l.id, l.nome, l.inativo, u.id FROM lista AS l JOIN usuario AS u ON u.id = l.usuarioID WHERE u.id = ?";
            
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
          preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Lista> results = new ArrayList();
        while (resultSet.next()) {
            Lista lista = new Lista();
            lista.setId(resultSet.getInt("l.id"));
            lista.setNome(resultSet.getString("l.nome"));
            lista.setUsuarioID(resultSet.getInt("u.id"));
            lista.setInativo(resultSet.getBoolean("l.inativo"));
            results.add(lista);
        }
        return results;
    }
            
            
            
            

    public List<Lista> selects(String nome) throws SQLException {
        String sql = null;
        if (nome == null || nome.isEmpty()) {
            sql = "SELECT * FROM lista";
        } else {
            sql = "SELECT * FROM lista WHERE nome like '%" + nome + "%'";
        }
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Lista> results = new ArrayList();
        while (resultSet.next()) {
            Lista lista = new Lista();
            lista.setId(resultSet.getInt("id"));
            lista.setNome(resultSet.getString("nome"));
            results.add(lista);
        }
        return results;
    }

    public Lista select(int id) throws SQLException {
        String sql = "SELECT * FROM lista WHERE id = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Lista lista = null;
        if (resultSet.next()) {
            lista = new Lista();
            lista.setId(resultSet.getInt("id"));
            lista.setNome(resultSet.getString("nome"));
            return lista;
        } else {
            return null;
        }
    }

    public boolean closeConnection() {
        try {
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ListaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Lista delete(int id) throws SQLException {
      
            String sql = "DELETE FROM lista WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        
            return null;
    }

}
