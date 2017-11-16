package model;
import java.io.Serializable;

	public class Pedido implements Serializable{
		private Long id;
		private String fecha;
		private String cliente;
		private String observacion;
		
		public Pedido (Long id, String fecha, String cliente, String observacion) {
			
			super();
			this.id = id;
			this.fecha = fecha;
			this.cliente = cliente;
			this.observacion = observacion;
		}
		public Pedido() {
				this(0L, "", "", "");
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getObservacion() {
			return observacion;
		}
		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", observacion=" + observacion + "]";
		}
		
		
		
	}


