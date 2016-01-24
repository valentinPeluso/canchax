package factorys;

import modelo.Senia;

public class SeniaConcreteFactory extends SeniaFactory{

	public SeniaConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Senia create(float cantidad, String descripcion, String telefono) {
		// TODO Auto-generated method stub
		return new Senia(cantidad,descripcion,telefono);
	}

}
