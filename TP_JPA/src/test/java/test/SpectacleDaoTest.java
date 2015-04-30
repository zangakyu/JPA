package test;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Spectacle;
import dao.SpectacleDao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ninja_squad.dbsetup.DbSetup;
import org.junit.Ignore;
//import com.ninja_squad.iut.tpjpa.model.Spectacle;
//import com.ninja_squad.iut.tpjpa.model.TypeDeSpectacle;

public class SpectacleDaoTest {

	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private SpectacleDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emFactory = Persistence.createEntityManagerFactory("TP_JPA");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emFactory.close();
	}

	@Before
	public void setUp() throws Exception {
		em = emFactory.createEntityManager();
		dao = new SpectacleDao(em);
		loadTestData();
		em.getTransaction().begin();
	}

	private void loadTestData() {
		DbSetup dbSetup = new DbSetup(TestData.TEST_DESTINATION, 
				                      TestData.STANDARD_OPERATION);
		dbSetup.launch();
	}
	
	@After
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}

	
	@Test
	public void findAllTest(){
				
		List<Spectacle> listeSpectacle = dao.findAll();
		
		assertEquals(2, listeSpectacle.size());
		assertEquals("CONCERT",listeSpectacle.get(0).getType().toString());
		assertEquals("THEATRE",listeSpectacle.get(1).getType().toString());
	
	}
	
	@Test
	public void findByIdTest(){
		
		Spectacle s = dao.findById((long) 1);
		assertEquals("THEATRE",s.getType().toString());
		
		s = dao.findById((long) 2);
		assertEquals("CONCERT",s.getType().toString());
		
	}
	
	@Test
	public void findByArtisteTest(){
		Spectacle s = dao.findByArtiste("Troupe des Mathurins");
		assertEquals("THEATRE",s.getType().toString());
	}
		
}
