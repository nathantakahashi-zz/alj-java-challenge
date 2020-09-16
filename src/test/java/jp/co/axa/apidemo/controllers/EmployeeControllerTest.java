/**
 * 
 */
package jp.co.axa.apidemo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;


// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeControllerTest.
 *
 * @author rashd
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    /** The mvc. */
    @Autowired
    private MockMvc mvc;
 
    /** The service. */
    @MockBean
    private EmployeeService service;
    
    /**
     * Given employees when get employees then return json array.
     *
     * @throws Exception the exception
     */
    @WithMockUser(value = "spring")
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
        
        Employee john = createTestEmployee("John Patterson");
     
        List<Employee> allEmployees = Arrays.asList(john);
     
        given(service.retrieveEmployees()).willReturn(allEmployees);
     
        mvc.perform(get("/api/v1/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0]", is(john)));
    }
    
    /**
     * Given employees when get employees then status 200.
     *
     * @throws Exception the exception
     */
    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
     
    	Employee bob = createTestEmployee("bob");
     
        mvc.perform(get("/api/v1/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[0].name", is("bob")));
    }
    
	/**
	 * Test method for {@link jp.co.axa.apidemo.controllers.EmployeeController#getEmployees()}.
	 */
	@Test
	public final void testGetEmployees() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.controllers.EmployeeController#getEmployee(java.lang.Long)}.
	 */
	@Test
	public final void testGetEmployee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.controllers.EmployeeController#saveEmployee(jp.co.axa.apidemo.entities.Employee)}.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public final void testSaveEmployee() throws Exception {
		
        Employee john = createTestEmployee("John Patterson");
     
        given(service.saveEmployee(john));
     
        mvc.perform(post("/api/v1/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.controllers.EmployeeController#deleteEmployee(java.lang.Long)}.
	 */
	@Test
	public final void testDeleteEmployee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jp.co.axa.apidemo.controllers.EmployeeController#updateEmployee(jp.co.axa.apidemo.entities.Employee, java.lang.Long)}.
	 */
	@Test
	public final void testUpdateEmployee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Creates the test employee.
	 *
	 * @param name the name
	 * @return the employee
	 */
	Employee createTestEmployee(String name){
		return new Employee(123456L, name, 0 ,"Sales");
	}
	
}
