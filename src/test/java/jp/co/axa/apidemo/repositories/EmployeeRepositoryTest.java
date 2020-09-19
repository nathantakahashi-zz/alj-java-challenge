package jp.co.axa.apidemo.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeRepositoryTest.
 */
@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	/** The entity manager. */

	/** The employee repository. */
	@Mock
	public EmployeeRepository employeeRepository;

	/** The entity manager. */
	@Autowired
	public TestEntityManager entityManager;

	/** The emp list. */
	static List<Employee> empList;

	/**
	 * Before all test methods.
	 */
	@BeforeClass
	public static void beforeAllTestMethods() {
		empList = new ArrayList<Employee>();
	}

	/**
	 * Injected components are not null.
	 */
	@Test
	@Order(1)
	public void injectedComponentsAreNotNull(){
		assertNotNull(entityManager);
		assertNotNull(employeeRepository);
	}

	/**
	 * Save employee OK.
	 */
	@Test
	@Order(2)
	public final void saveEmployee_OK() {
		try{
			empList.forEach(empl -> employeeRepository.save(empl));
		} catch(Exception ex) {
			assertTrue(false); 
		}
		assertTrue(true);
	}

	/**
	 * Test find all.
	 */
	@Test
	@Order(3)
	public final void testFindAll() {
		List<Employee> employees = employeeRepository.findAll();
		Assert.assertEquals(employees, empList);
	}

	/**
	 * Test find by id.
	 */
	@Test
	@Order(4)
	public final void testFindById() {
		Long employeeId = 1L;

		Optional<Employee> empl = employeeRepository.findById(employeeId);
		assertFalse(empl.isEmpty());
		assertTrue(empl.isPresent());
		
	}

	/**
	 * Delete by id.
	 */
	@Test
	@Order(5)
	public final void deleteById() {
		try {
			employeeRepository.deleteById(1L);
			employeeRepository.deleteById(2L);
			employeeRepository.deleteById(3L);
		} catch(Exception ex) {
			assertTrue(false); 
		}
		assertTrue(true);
	}

}
