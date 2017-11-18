package fbd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fbd.model.Villano;

public class VillanoDAOlmpl   implements VillanoDAO{
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;
	public VillanoDAOlmpl dao;

	public VillanoDAOlmpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/villano", "postgres", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createVillano(Villano villano) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("INSERT INTO villano (colorbigote,colorsombrero,aspecto) values(?,?,?);");
				prepareStatement.setString(1, villano.getColorBigote());
				prepareStatement.setString(2, villano.getColorSombrero());
				prepareStatement.setString(3, villano.getAspecto());
		
			
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Villano readVillano(int id) {
		Villano villano = null;
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM villano WHERE id=?;");
				prepareStatement.setInt(1, id);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					villano = new Villano(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return villano;
	}

	@Override
	public List<Villano> readAllVillanos() {
		List<Villano> villanos = new ArrayList<Villano>();
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM villano;");
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Villano villano = new Villano(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4)
							);
					villanos.add((Villano) villano);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return villanos;
	}

	@Override
	public void updateVillano(Villano villano) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("UPDATE villano  SET colorbigote = ?, colorsombrero=?, aspecto=?  WHERE id=?;");
				prepareStatement.setString(1, villano.getColorBigote());
				prepareStatement.setString(2, villano.getColorSombrero());
				prepareStatement.setString(3, villano.getAspecto());
				prepareStatement.setInt(4, villano.getId());
				prepareStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteVillano(int id) {
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("DELETE FROM villano  WHERE id=?;");
				prepareStatement.setInt(1, id);
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
