package jp.co.axa.apidemo.repositories;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeRepositoryTest.
 */
@RunWith(SpringRunner.class)
public class EmployeeRepositoryTest {

	/** The entity manager. */

	/** The employee repository. */
	@Mock
	public EmployeeRepository employeeRepository;
	
    @Autowired
    public TestEntityManager entityManager;

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
		Employee employee = new Employee(123456L, "John Patterson", 0 ,"Sales");
		assertNotNull(employeeRepository.save(employee));
	}

	/**
	 * Test find all.
	 */
	@Test
	@Order(3)
	public final void testFindAll() {
		List<Employee> employees = employeeRepository.findAll();
	}

	/**
	 * Test find by id.
	 */
	@Test
	@Order(4)
	public final void testFindById() {
		// given
		Long employeeId = 123456L;

		// when
		Optional<Employee> found = employeeRepository.findById(employeeId);

		// then
		System.out.println();
		//assertThat(found.get().).isEqualTo(alex.getName());
	}

	/**
	 * Delete by id.
	 */
	@Test
	@Order(5)
	public final void deleteById() {
		Long employeeId = 123456L;
		employeeRepository.deleteById(employeeId);
	}

}
