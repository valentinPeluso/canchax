package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private List<Producto> productos_comprado;
	private float monto_total;
	private Date fecha;

	public Compra(List<Producto> productos_comprado, float monto_total, Date fecha) {
		super();
		this.productos_comprado = productos_comprado;
		this.monto_total = monto_total;
		this.fecha = fecha;
	}
	public Compra() {
		// TODO Auto-generated constructor stub
	}	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "compra_producto", joinColumns = { 
            @JoinColumn(name = "ID_COMPRA", nullable = false, updatable = false) }, 
            inverseJoinColumns = { 
                    @JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) })    
    @Column(nullable = true)
	public List<Producto> getProductos_comprado() {
		return productos_comprado;
	}
	public void setProductos_comprado(List<Producto> productos_comprado) {
		this.productos_comprado = productos_comprado;
	}
	public float getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(float monto_total) {
		this.monto_total = monto_total;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
