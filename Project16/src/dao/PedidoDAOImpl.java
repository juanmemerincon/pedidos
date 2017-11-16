package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidoDAOImpl implements PedidoDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public PedidoDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "postgres", "juanmeme");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createPedido(Pedido pedido) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO pedidos (fecha, cliente,"
									+ "observacion)values (?,?,?);");
			preparedStatement.setString(1,pedido.getFecha() );
			preparedStatement.setString(2,pedido.getCliente() );
			preparedStatement.setString(3,pedido.getObservacion());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pedido readPedido(Long id) {
		Pedido pedido = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT id, fecha, cliente,observacion FROM pedidos WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					pedido = new Pedido(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
											resultSet.getString(4));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return pedido;
	}

	@Override
	public List<Pedido> readAllPedidos() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT id, fecha, cliente, observacion FROM pedidos");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Pedido pedido = new Pedido(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getString(3),
									resultSet.getString(4));
					pedidos.add(pedido);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return pedidos;
	}

	@Override
	public void updatePedido(Pedido pedido) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE pedidos SET fecha=?, "
											+ "cliente=?,"
										+ "observacion=? WHERE id=?;");
				preparedStatement.setString(1,pedido.getFecha() );
				preparedStatement.setString(2,pedido.getCliente() );
				preparedStatement.setString(3,pedido.getObservacion());
				preparedStatement.setLong(4, pedido.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deletePedido(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM pedidos WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

}
