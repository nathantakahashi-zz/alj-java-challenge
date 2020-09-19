package jp.co.axa.apidemo.dto;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDto.
 */
public class EmployeeDto {

	/** The id. */
	@Getter
	@Setter
	private Long id;

	/** The name. */
	@Getter
	@Setter
	private String name;

	/** The salary. */
	@Getter
	@Setter
	private Integer salary;

	/** The department. */
	@Getter
	@Setter
	private String department;
}
