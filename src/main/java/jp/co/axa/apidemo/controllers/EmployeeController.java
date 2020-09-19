package jp.co.axa.apidemo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import lombok.AllArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@Validated
@RestController
@RequestMapping("/api/v1")
@Api(value="axaApiDemo")
@AllArgsConstructor
public class EmployeeController {

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;
	
    /** The model mapper. */
    @Autowired
    private ModelMapper modelMapper;

	/**
	 * Sets the employee service.
	 *
	 * @param employeeService the new employee service
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}  

	/**
	 * Gets the employees.
	 *
	 * @return the employees
	 */
	@ResponseBody
	@GetMapping("/employees")
	public List<EmployeeDto> getEmployees() {
		List<EmployeeDto> employeesDto = new ArrayList<>();
		try {
			List<Employee> employeeList = employeeService.retrieveEmployees();
			
			for(Employee employee : employeeList) {
				EmployeeDto emplDto = modelMapper.map(employee, EmployeeDto.class);
				employeesDto.add(emplDto);
			}
			
		} catch(Exception ex) {
			return Collections.emptyList();
		}
		return employeesDto;
	}

	/**
	 * Gets the employee.
	 *
	 * @param employeeId the employee id
	 * @return the employee
	 */
	@GetMapping("/employees/{employeeId}")
	public EmployeeDto getEmployee(@PathVariable(name="employeeId")Long employeeId) {
		EmployeeDto employeeDto = null;
		try {
			Employee employee = employeeService.getEmployee(employeeId);
			employeeDto = modelMapper.map(employee, EmployeeDto.class);
		} catch(Exception ex) {
			return new EmployeeDto();
		}
		return employeeDto;
	}

	/**
	 * Save employee.
	 *
	 * @param employeeDto the employee dto
	 * @return the response entity
	 */
	@PostMapping("/employees/save")
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto employeeDto){
		try {
			Employee employee = modelMapper.map(employeeDto, Employee.class);
			employeeService.saveEmployee(employee);
		} catch(Exception ex) {
			return new ResponseEntity<>("Failed Employee Save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Employee Saved Successfully", HttpStatus.OK);
	}

	/**
	 * Update employee.
	 *
	 * @param employeeDto the employee dto
	 * @param employeeId the employee id
	 * @return the response entity
	 */
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDto employeeDto,
			@PathVariable(name="employeeId")Long employeeId){
		try {
			Employee employee = modelMapper.map(employeeDto, Employee.class);
			Employee empl = employeeService.getEmployee(employeeId);
			if(empl != null){
				employeeService.updateEmployee(employee);
			}
		} catch(Exception ex) {
			return new ResponseEntity<>("Failed Employee Update", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Employee Updated Successfully", HttpStatus.OK);
	}

	/**
	 * Delete employee.
	 *
	 * @param employeeId the employee id
	 * @return the response entity
	 */
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
		try {
			employeeService.deleteEmployee(employeeId);
		} catch(Exception ex) {
			return new ResponseEntity<>("Failed Employee Delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
	}

}
