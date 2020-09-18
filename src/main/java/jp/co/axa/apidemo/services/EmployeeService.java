package jp.co.axa.apidemo.services;

import java.util.List;

import jp.co.axa.apidemo.entities.Employee;

/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {

    /**
     * Retrieve employees.
     *
     * @return the list
     */
    public List<Employee> retrieveEmployees();

    /**
     * Gets the employee.
     *
     * @param employeeId the employee id
     * @return the employee
     */
    public Employee getEmployee(Long employeeId);

    /**
     * Save employee.
     *
     * @param employee the employee
     * @return true, if successful
     */
    public boolean saveEmployee(Employee employee);

    /**
     * Delete employee.
     *
     * @param employeeId the employee id
     * @return true, if successful
     */
    public boolean deleteEmployee(Long employeeId);

    /**
     * Update employee.
     *
     * @param employee the employee
     * @return true, if successful
     */
    public boolean updateEmployee(Employee employee);
}