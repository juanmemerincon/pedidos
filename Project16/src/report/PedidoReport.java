package report;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDAOImpl;
import dao.PedidoDAO;
import dao.PedidoDAOImpl;
import model.Pedido;
import model.Pedido;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class PedidoReport
 */
@WebServlet("/PedidoReport")
public class PedidoReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoReport() {
        super();
        dao = new PedidoDAOImpl() {
			
			@Override
			public void updatePedido(Pedido pedido) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Pedido readPedido(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Pedido> readAllPedidos() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deletePedido(Long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createPedido(Pedido pedido) {
				// TODO Auto-generated method stub
				
			}
		};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\Rincon\\newworkspace\\Project16\\src\\report\\Blank_Letter.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			// data.put("Image", this.getServletContext().getRealPath("/")+"/images/helloWorld.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnetion());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
