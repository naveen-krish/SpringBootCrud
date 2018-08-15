package lab.springboot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab.springboot.model.Employee;
import lab.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	@RequestMapping(value="employee",method=RequestMethod.GET)
	public List<Employee> list(){
		System.out.println(" empList ");
		return empRepository.findAll();
	}
	
	@RequestMapping(value="employee",method=RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		System.out.println(" saveAndFlush Employee ");
		 return empRepository.saveAndFlush(employee);
	}
	
	@RequestMapping(value="employee/{id}",method=RequestMethod.GET)
	public Employee get(@PathVariable Long id) {
		System.out.println(" Employee.get(id) "+id);
		 return empRepository.findOne(id);
	}
	
	@RequestMapping(value="employee/{id}",method=RequestMethod.PUT)
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
		
		Employee existingEmployee = empRepository.findOne(id);
		BeanUtils.copyProperties(employee, existingEmployee);
		return empRepository.saveAndFlush(existingEmployee);
		
	}

	 @RequestMapping(value="employee/{id}",method=RequestMethod.DELETE)
	 public Employee delete(@PathVariable Long id) {
		 Employee existingEmployee = empRepository.findOne(id);
		  empRepository.delete(existingEmployee);
		  return existingEmployee;
	 }
}
