package dao;

import java.util.List;

import model.Pedido;

public interface PedidoDAO {
	
	void createPedido(Pedido pedido);
	Pedido readPedido(Long id);
	List<Pedido> readAllPedidos();
	void updatePedido(Pedido pedido);
	void deletePedido(Long id);
	

}
