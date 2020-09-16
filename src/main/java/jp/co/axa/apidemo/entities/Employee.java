package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    /** The id. */
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /** The name. */
    @Getter
    @Setter
    @Column(name="EMPLOYEE_NAME")
    private String name;

    /** The salary. */
    @Getter
    @Setter
    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;

    /** The department. */
    @Getter
    @Setter
    @Column(name="DEPARTMENT")
    private String department;
    
    /**
     * Instantiates a new employee.
     *
     * @param id the id
     * @param name the name
     * @param salary the salary
     * @param department the department
     */
    public Employee(Long id, String name, Integer salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

}
