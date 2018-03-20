package Model;
import Model.Pais;
import Controller.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PaisDAO {
	
	
	public void incluir(Pais to) {
		String sqlInsert = "INSERT INTO tblpais(nome, populacao, area) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setInt(2, to.getPopulacao());
			stm.setDouble (3, to.getArea());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizar(Pais to) {
		String sqlUpdate = "UPDATE tblpais SET nome=?, populacao=?, area=? WHERE id_pk=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setInt(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	public void excluir(Pais to) {
		String sqlDelete = "DELETE FROM tblpais WHERE id_pk = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, to.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	public Pais carregar(int id) {
		Pais to = new Pais(id);
			String sqlSelect = "SELECT nome, populacao,area FROM tblpais WHERE tblpais.id_pk = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						to.setNome(rs.getString("nome"));
						to.setArea(rs.getDouble("area"));
						to.setPopulacao(rs.getInt("populacao"));						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		return to;
	}
}
