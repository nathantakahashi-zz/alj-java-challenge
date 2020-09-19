/**
 * 
 */
package jp.co.axa.apidemo.services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.repositories.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImplTest.
 *
 * @author rashd
 */
@Ignore	
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

	}
	
	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#saveEmployee(jp.co.axa.apidemo.entities.Employee)}.
	 */
	@Test
	public void testSaveEmployee() {
//		Employee empl = new Employee(1L, "john", 0 ,"Sales");
//		assertTrue(employeeService.saveEmployee(empl));
	}
	
	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#getEmployee(java.lang.Long)}.
	 */
	@Test
	public void testGetEmployee() {
//		Employee empl = new Employee(1L, "john", 0 ,"Sales");
//		employeeRepository.save(empl);
//		Employee employee = employeeService.getEmployee(1L);
//		Assert.assertEquals(employee, empl);
	}
	
	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#retrieveEmployees()}.
	 */
	@Test
	public final void testRetrieveEmployees() {
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(new Employee(1L, "John Patterson", 456000 ,"Sales"));
//		empList.add(new Employee(2L, "Patrik Sattle", 355000 ,"IT"));
//		empList.add(new Employee(3L, "Nick Riviera", 274000 ,"Security"));	
//		empList.forEach(empl -> employeeRepository.save(empl));
//		
//		List<Employee> employeeRetList = employeeService.retrieveEmployees();
//		Assert.assertEquals(empList, employeeRetList);
	}


	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#deleteEmployee(java.lang.Long)}.
	 */
	@Test
	public final void testDeleteEmployee() {
		assertTrue(employeeService.deleteEmployee(1L));
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.services.EmployeeServiceImpl#updateEmployee(jp.co.axa.apidemo.entities.Employee)}.
	 */
	@Test
	public final void testUpdateEmployee() {
//		Employee empl = new Employee(1L, "nick", 0 ,"Business Development");
//		assertTrue(employeeService.updateEmployee(empl));
	}

}
