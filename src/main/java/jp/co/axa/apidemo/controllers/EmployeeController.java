package jp.co.axa.apidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    /** The employee service. */
    @Autowired
    private EmployeeService employeeService;

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
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    /**
     * Gets the employee.
     *
     * @param employeeId the employee id
     * @return the employee
     */
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    /**
     * Save employee.
     *
     * @param employee the employee
     */
    @PostMapping("/employees")
    public void saveEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
    }

    /**
     * Delete employee.
     *
     * @param employeeId the employee id
     */
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    /**
     * Update employee.
     *
     * @param employee the employee
     * @param employeeId the employee id
     */
    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employeeService.updateEmployee(employee);
        }
    }
}
