import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pais {
	private int id;
	private String nome;
	private double popu;
	private double area; 	

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Pais() {

	}

	public Pais(int id, String nome, double popu, double area) {
		this.setId(id);
		this.setNome(nome);
		this.setPopu(popu);
		this.setArea(area);
	}

	// obtem conexao

	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/vendas?user=root&password=root");
	}

	// criar

	public void criar() {
		String sqlInsert = "INSERT INTO pais(nome,popu,area) VALUES (?,?,?)";

		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setDouble(2, getPopu());
			stm.setDouble(3, getArea());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);

					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// atualizar
	public void atualizar() {
		String sqlUpdate = "UPDATE pais SET nome=?,populacao=?,area=? WHERE id=?";

		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setDouble(2, getPopu());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void excluir() {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		
		try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1,getId());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void carregar() {
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, getId());
	try(ResultSet rs = stm.executeQuery();)
	{
		if (rs.next()) {
			setNome(rs.getString("nome"));
			setPopu(rs.getDouble("populacao"));
			setArea(rs.getDouble("area"));
		} else {
			setId(-1);
			setNome(null);
			setPopu(0);
			setArea(0);
		}
	}catch(
	SQLException e)
	{
		e.printStackTrace();
	}}catch(
	SQLException e1)
	{
		System.out.print(e1.getStackTrace());
	}
}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPopu() {
		return popu;
	}

	public void setPopu(double popu) {
		this.popu = popu;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	} 
	
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + popu + ", area=" + area + "]";
	}
	
	public Pais maiorNumHabi(){
		String sqlMaiorCli ="SELECT id,nome,Max(populacao),area FROM cliente";
		Pais paisMaiorPopu = new Pais();
		
		
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlMaiorCli);)
		{
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next()) {
					paisMaiorPopu.setId(rs.getInt("id"));
					paisMaiorPopu.setNome(rs.getString("nome"));
					paisMaiorPopu.setPopu(rs.getDouble("populacao"));
					paisMaiorPopu.setArea(rs.getDouble("area"));
				}
				}catch(
				SQLException e)
			{
					e.printStackTrace();
			}}catch(
			SQLException e1)
		{
				System.out.println(e1.getStackTrace());
		}
		return paisMaiorPopu;
	}
	
	public Pais menorArea(){
		String sqlMenorPais ="SELECT id,nome,populacao,Min(area) FROM pais";
		Pais menorArea = new Pais();
		
		
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlMenorPais);)
		{
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next()) {
					menorArea.setId(rs.getInt("id"));
					menorArea.setNome(rs.getString("nome"));
					menorArea.setPopu(rs.getDouble("populacao"));
					menorArea.setArea(rs.getDouble("area"));
				}
				}catch(
				SQLException e)
			{
					e.printStackTrace();
			}}catch(
			SQLException e1)
		{
				System.out.println(e1.getStackTrace());
		}
		return menorArea;
	}
	
	public void vetor3paises() {
		String sql3vetor = "SELECT TOP 3 nome FROM pais";
		String[] vetor = new String[3];
		
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql3vetor);)
		{
			try(ResultSet rs = stm.executeQuery();)
			{
				for(int i=0;i < 2;i++) {
					
					if(rs.next()) {
						vetor[i] = rs.getString("nome");	
					}
				}
				}catch(
				SQLException e)
			{
					e.printStackTrace();
			}}catch(
			SQLException e1)
		{
				System.out.println(e1.getStackTrace());
		}
		for (int i = 0; i < vetor.length; i++) {
		    System.out.println(vetor[i]);
		}
		
	}
}
	
	
	
	