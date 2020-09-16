package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImpl.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Sets the employee repository.
	 *
	 * @param employeeRepository the new employee repository
	 */
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	/**
	 * Retrieve employees.
	 *
	 * @return the list
	 */
	@Cacheable(value="employee")
	public List<Employee> retrieveEmployees() {

		List<Employee> employees;

		try {
			employees = employeeRepository.findAll();
		} catch(Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			return null;
		}

		return new ArrayList<Employee>();
	}

	/**
	 * Gets the employee.
	 *
	 * @param employeeId the employee id
	 * @return the employee
	 */
	@Cacheable(value="employee")
	public Employee getEmployee(Long employeeId) {

		Optional<Employee> optEmp;

		try {
			optEmp = employeeRepository.findById(employeeId);
		} catch(Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			return null;
		}
		if(optEmp.isEmpty()) return null;

		return optEmp.get();
	}

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return true, if successful
	 */
	@CachePut(value="employee")
	public boolean saveEmployee(Employee employee){

		try {
			employeeRepository.save(employee);
		} catch(Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Delete employee.
	 *
	 * @param employeeId the employee id
	 * @return true, if successful
	 */
	@CacheEvict(value = "employee", allEntries=true)
	public boolean deleteEmployee(Long employeeId){

		try {
			employeeRepository.deleteById(employeeId);
		} catch(Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @return true, if successful
	 */
	@CacheEvict(value = "employee", allEntries=true)
	public boolean updateEmployee(Employee employee) {

		try {
			employeeRepository.save(employee);
		} catch(Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			return false;
		}
		return true;
	}
}