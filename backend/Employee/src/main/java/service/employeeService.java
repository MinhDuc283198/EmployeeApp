package service;

import java.util.List;

import org.springframework.http.HttpStatus;

import Entity.EmployeeEntity;
import dto.EmployeeDTO;

public interface employeeService {

	List<EmployeeDTO> findAll();
	EmployeeDTO getByid(long id);
	HttpStatus saveEmployee(EmployeeDTO employeeDTO);
	void deleteEmployee(long id);
	HttpStatus updateEmployee(EmployeeDTO employeeDTO, long id);
	HttpStatus updateEmployeefake(EmployeeDTO employeeDTO);
}
