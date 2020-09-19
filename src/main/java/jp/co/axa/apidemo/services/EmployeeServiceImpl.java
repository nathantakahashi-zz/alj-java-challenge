package jp.co.axa.apidemo.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImpl.
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/** The error. */
	private String error = "ERROR: ";

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
			logger.error(error, ex.getMessage());
			return Collections.emptyList(); 
		}

		return employees;
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
			logger.error(error, ex.getMessage());
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
			logger.error(error, ex.getMessage());
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
			logger.error(error, ex.getMessage());
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
			logger.error(error, "ERROR: "+ ex.getMessage());
			return false;
		}
		return true;
	}
}