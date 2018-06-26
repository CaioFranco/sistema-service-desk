package br.com.sistema.service.desk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.service.desk.conf.DatabaseConf;
import br.com.sistema.service.desk.models.Cliente;

public class ClienteDao {
	
	private Connection connection;
	private PreparedStatement ps;
	
	public void gravar(Cliente cliente) {
		connection = DatabaseConf.getConexaoMySQL();
		String query = ""
				+ "INSERT  INTO  clientes (nome, empresa) VALUES (?,?);";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmpresa());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
	}
	
	public Cliente obter(Long id) {
		connection = DatabaseConf.getConexaoMySQL();
		Cliente cliente = new Cliente();
		String query = ""
				+ "SELECT * FROM clientes WHERE id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmpresa(rs.getString("empresa"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
		
		return cliente;
	}

	public List<Cliente> listar() {
		connection = DatabaseConf.getConexaoMySQL();
		List<Cliente> lista = new ArrayList<>();
		String query = ""
				+ "SELECT * FROM clientes;";
		try {
			ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			Cliente cliente;
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmpresa(rs.getString("empresa"));
				lista.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
		
		return lista;
	}
}
