package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDao {
	public int criar(Pais pais) {
		String sqlInsert = "INSERT INTO pais(nome, pupulacao, area VALUES (?,?,?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);){
				stm.setString(1,pais.getNome());
				stm.setDouble(2,pais.getArea());
				stm.setInt(3, pais.getPopu());
				stm.execute();
				
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();){
					if (rs.next()) {
						pais.setId(rs.getInt(1));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return pais.getId();
  }
	
	public void atualizar(Pais pais) {
		String sqlUpdate = "UPDATE pais SET nome=?, area=?,populacao = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
				stm.setString(1, pais.getNome());
				stm.setDouble(2, pais.getArea());
				stm.setInt(3, pais.getPopu());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id){
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, id);
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pais carregar(int id) {
		Pais pais = new Pais();
		pais.setId(id);
		String sqlSelect = "SELECT nome, area, populacao FROM pais WHERE pais.id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, pais.getId());
			try(ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setArea(Double.parseDouble(rs.getString("area")));
					pais.setPopu(Integer.parseInt(rs.getString("populacao")));
				}else {
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopu(0);
					pais.setArea(0);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return pais;
	}
}