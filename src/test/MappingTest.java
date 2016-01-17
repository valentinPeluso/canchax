package test;
import daos.CanchaDAO;
import daos.implementaciones.CanchaDAOHibernateJPA;
import factorys.CanchaConcreteFactory;
import factorys.CanchaFactory;
import modelo.Cancha;
import modelo.Predio;

public class MappingTest {

	public MappingTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanchaDAO cancha_dao = new CanchaDAOHibernateJPA();
		CanchaFactory cancha_factory = new CanchaConcreteFactory();
		Cancha cancha = cancha_factory.create("descripcion",new Predio());
		cancha_dao.save(cancha);

	}

}
