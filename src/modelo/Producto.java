package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Producto implements Serializable {

	public Producto(String codigo, String descripcion, int cantidad, List<Provedor> usuarios_venden_producto,
			float precio_compra, float precio_venta, String foto, List<Predio> predios_venden_producto) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.usuarios_venden_producto = usuarios_venden_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.foto = foto;
		this.predios_venden_producto = predios_venden_producto;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = -3646947927056325570L;
	
	@Id
	@GeneratedValue
	private long id;
	private String codigo;
	private String descripcion;
	
	@Column(nullable = true)
	private int cantidad;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "productos")
	private List<Provedor> usuarios_venden_producto;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "productos")
	private List<Predio> predios_venden_producto;
	
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
	public List<Provedor> getUsuarios_venden_producto() {
		return usuarios_venden_producto;
	}
	public void setUsuarios_venden_producto(List<Provedor> usuarios_venden_producto) {
		this.usuarios_venden_producto = usuarios_venden_producto;
	}

	public List<Predio> getPredios_venden_producto() {
		return predios_venden_producto;
	}

	public void setPredios_venden_producto(List<Predio> predios_venden_producto) {
		this.predios_venden_producto = predios_venden_producto;
	}
	
	

}
