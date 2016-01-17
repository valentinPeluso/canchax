package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Producto implements Serializable {

	private static final long serialVersionUID = -3646947927056325570L;

	public Producto(long id, String codigo, String descripcion, int cantidad, Usuario provedor, float precio_compra,
			float precio_venta, String foto) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.provedor = provedor;
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

	public Producto(String codigo, String descripcion, Usuario provedor, int cantidad, float precio_compra,
			float precio_venta, String foto) {
		// TODO Auto-generated constructor stub
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.provedor = provedor;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.foto = foto;
	}
	
	@Id
	@GeneratedValue
	private long id;
	private String codigo;
	private String descripcion;
	
	@Column(nullable = true)
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Usuario provedor;
	
	@Column(nullable = true)
	private float precio_compra;
	@Column(nullable = true)
	private float precio_venta;
	
	@Column(nullable = true)
	private String foto;
	
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Usuario getProvedor() {
		return provedor;
	}
	public void setProvedor(Usuario provedor) {
		this.provedor = provedor;
	}
	public float getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}
	public float getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	

}
