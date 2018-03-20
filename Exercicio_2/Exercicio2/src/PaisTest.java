
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class PaisTest {
	Pais pais, copia;
	static int id = 1;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		
		pais = new Pais(id,"Brazuca",33213.32131,0);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carrega");
		
		Pais fixture = new Pais(1,"Brazuka",12321312,1321321);
		Pais novo = new Pais(1,null,0,0);
		novo.carregar();
		assertEquals("testa inclusao",novo, fixture);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa atualização", pais,copia);
	}
	
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setNome("aaaaa");
		copia.setNome("teste");
		pais.atualizar();
		pais.carregar();
		assertEquals("texta exclusão",pais,copia);
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopu(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		assertEquals("texta exclusão",pais,copia);
	}
}
