/**
 * 
 */
package jp.co.axa.apidemo.services;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImplTest.
 *
 * @author rashd
 */
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	/**
	 * The Class EmployeeServiceImplTestContextConfiguration.
	 */
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		/**
		 * Employee service.
		 *
		 * @return the employee service
		 */
		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;

	/** The employee repository. */
	@MockBean
	private EmployeeRepository employeeRepository;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		Employee alex = new Employee(123456L, "John Patterson", 0 ,"Sales");

//		Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
	}

	/**
	 * When valid name then employee should be found.
	 */
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
	    String name = "alex";
//	    Employee found = employeeService.getEmployeeByName(name);
	 
//	     assertThat(found.getName()).isEqualTo(name);
	 }
	
	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#retrieveEmployees()}.
	 */
	@Test
	public final void testRetrieveEmployees() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#getEmployee(java.lang.Long)}.
	 */
	@Test
	public final void testGetEmployee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#saveEmployee(jp.co.axa.apidemo.entities.Employee)}.
	 */
	@Test
	public final void testSaveEmployee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#deleteEmployee(java.lang.Long)}.
	 */
	@Test
	public final void testDeleteEmployee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#updateEmployee(jp.co.axa.apidemo.entities.Employee)}.
	 */
	@Test
	public final void testUpdateEmployee() {
		fail("Not yet implemented"); // TODO
	}

}
