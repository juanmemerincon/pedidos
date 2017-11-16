package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDAOImpl;
import model.Pedido;

/**
 * Servlet implementation class PedidoController1
 */
@WebServlet("/PedidoController1")
public class PedidoController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	private List<Pedido> pedidos;
	private PedidoDAOImpl pedidoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoController1() {
    	pedido = new Pedido();
        pedidos = new ArrayList<Pedido>();
        pedidoDAO = new PedidoDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
if (request.getParameter("btn_save")!= null) {
			
			pedido.setFecha(request.getParameter("fecha"));
			pedido.setCliente(request.getParameter("cliente"));
			pedido.setObservacion(request.getParameter("observacion"));
				
				
			if(pedido.getId()==0L) {
				pedidoDAO.createPedido(pedido);
				}else {
				pedidoDAO.updatePedido(pedido);
			}
			
			pedidos = pedidoDAO.readAllPedidos();
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("pedido_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			pedido = new Pedido();
			request.getRequestDispatcher("pedido_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				pedido = pedidoDAO.readPedido(id);
				
			}catch (Exception e) {
				
				pedido = new Pedido();
			}
			request.setAttribute("pedido", pedido);
			
			request.getRequestDispatcher("pedido_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			pedidoDAO.deletePedido(id);
			pedidos = pedidoDAO.readAllPedidos();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("pedido_list.jsp").forward(request, response);
		}else {
			pedidos = pedidoDAO.readAllPedidos();
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("pedido_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
