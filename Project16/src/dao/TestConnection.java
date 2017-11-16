package dao;

import java.util.List;

import model.Pedido;

public class TestConnection {
	public static void main(String[] args) {
		PedidoDAOImpl pedidoDAOImpl = new PedidoDAOImpl();
		pedidoDAOImpl.createPedido(new Pedido(6L, "Potero","GSILBN","Vespertino"));
		
		List<Pedido> pedidos = pedidoDAOImpl.readAllPedidos();
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
			
		}
	}

}
