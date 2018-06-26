package br.com.sistema.service.desk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.service.desk.conf.DatabaseConf;
import br.com.sistema.service.desk.models.Atendente;

public class AtendenteDao {

	private Connection connection;
	private PreparedStatement ps;
	
	public void gravar(Atendente atendente) {
		connection = DatabaseConf.getConexaoMySQL();
		String query = ""
				+ "INSERT  INTO atendentes (nome) VALUES  (?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, atendente.getNome());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
	}
	
	public Atendente obter(Long id) {
		connection = DatabaseConf.getConexaoMySQL();
		Atendente atendente = new Atendente();
		String query = ""
				+ "SELECT * FROM atendentes WHERE id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				atendente.setId(rs.getLong("id"));
				atendente.setNome(rs.getString("nome"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
		
		return atendente;
	}

	public List<Atendente> listar() {
		connection = DatabaseConf.getConexaoMySQL();
		List<Atendente> lista = new ArrayList<>();
		String query = ""
				+ "SELECT * FROM atendentes;";
		try {
			ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			Atendente atendente;
			while (rs.next()) {
				atendente = new Atendente();
				atendente.setId(rs.getLong("id"));
				atendente.setNome(rs.getString("nome"));
				lista.add(atendente);
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
