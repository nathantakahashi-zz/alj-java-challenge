package jp.co.axa.apidemo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
//@Value

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8869817068674469541L;

	/** The id. */
	@Getter
    @Setter
    @Id
	@Column(name="ID")
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

}
