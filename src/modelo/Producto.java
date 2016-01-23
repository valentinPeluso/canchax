package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {

	private static final long serialVersionUID = -3646947927056325570L;	
	
	private long id;
	private String codigo;
	private String descripcion;
	private int cantidad;
	private float precio_compra;
	private float precio_venta;
	private String foto;	
	
	public Producto(String codigo, String descripcion, int cantidad,float precio_compra, float precio_venta, String foto) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;	
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.foto = foto;		
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column(nullable = true)
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Column(nullable = true)
	public float getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}
	public float getPrecio_venta() {
		return precio_venta;
	}
	@Column(nullable = true)
	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}
	@Column(nullable = true)
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
