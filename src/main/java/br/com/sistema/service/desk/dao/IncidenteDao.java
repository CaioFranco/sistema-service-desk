package br.com.sistema.service.desk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.service.desk.conf.DatabaseConf;
import br.com.sistema.service.desk.models.Cliente;
import br.com.sistema.service.desk.models.Incidente;
import br.com.sistema.service.desk.models.Status;

public class IncidenteDao {

	private Connection connection;
	private PreparedStatement ps;
	
	public void gravar(Incidente incidente) {
		connection = DatabaseConf.getConexaoMySQL();
		String query = ""
				+ "INSERT  INTO  incidente (atendente, cliente, descricao, status, creation_time) VALUES  (?,?,?,?,now());";
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1, incidente.getIdAtendente());
			ps.setLong(2, incidente.getIdCliente());
			ps.setString(3, incidente.getDescricao());
			ps.setString(4, incidente.getStatus());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
	}

	public List<Incidente> listar() {
		connection = DatabaseConf.getConexaoMySQL();
		List<Incidente> lista = new ArrayList<>();
		String query = ""
				+ "SELECT * FROM incidente;";
		try {
			ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			Incidente incidente;
			while (rs.next()) {
				incidente = new Incidente();
				incidente.setId(rs.getLong("id"));
				incidente.setIdCliente(rs.getLong("cliente"));
				incidente.setIdAtendente(rs.getLong("atendente"));
				incidente.setDescricao(rs.getString("descricao"));
				incidente.setStatus(rs.getString("status"));
				incidente.setCreationTime(rs.getDate("creation_time"));
				lista.add(incidente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
		
		return lista;
	}

	public void encerrar(Long id) {
		connection = DatabaseConf.getConexaoMySQL();
		String query = ""
				+ "UPDATE incidente SET status = ? WHERE id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, Status.ENCERRADO.getDescricao());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConf.FecharConexao();
		}
	}
}
