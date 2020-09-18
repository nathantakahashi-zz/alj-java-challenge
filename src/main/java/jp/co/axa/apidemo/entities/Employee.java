package jp.co.axa.apidemo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 * The Class Employee.
 */
@Value
@Builder
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = -8869817068674469541L;

	/** The id. */
	@Getter
	@Setter
	@Id
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
	@JsonCreator
	public Employee(@JsonProperty("id") Long id,
			@JsonProperty("name") String name,
			@JsonProperty("salary") Integer salary,
			@JsonProperty("department") String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public Employee(){
		super();
	}

}
