package org.siva.employeemanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="this field is required")
	@Column(name="Name", nullable=false, length=40)
	private String name;
	@NotBlank(message="this field is required")
	@Column(name="Designation", nullable=false, length=40)
	private String designation;
	@NotBlank(message="this field is required")
	@Column(name="Email", nullable=false, length=40, unique=true)
	private String email;
	@NotBlank(message="this field is required")
	@Column(name="Mobile", nullable=false, length=10, unique=true)
	private String mobile;
	@NotNull(message="this field is required")
	@Column(name="Salary", nullable=false)
	private Double salary;
	@NotNull(message="this field is required")
	@Column(name="Deptno", nullable=false)
	private Integer deptno;

}
