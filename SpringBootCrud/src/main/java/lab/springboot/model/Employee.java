package lab.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	Integer age;
	String department;
	String doj;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	
	Employee(){}
	
	public Employee(Long id,String name,String department,String doj,Integer age) {
		this.id =id;
		this.name=name;
		this.department=department;
		this.doj=doj;
		this.age=age;
	}

	public Integer getAge() {
		return age;
	}

	public String getDepartment() {
		return department;
	}

	public String getDoj() {
		return doj;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
