package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Entity.EmployeeEntity;
import dto.EmployeeDTO;
import respository.EmployeeRespsitory;

@Service
public class employeeServiceImpl implements employeeService {
	@Autowired
	private EmployeeRespsitory employeeRes;
	@Override
	public List<EmployeeDTO> findAll()
	{
		List<EmployeeDTO> lstDto=new ArrayList<EmployeeDTO>();
		for (EmployeeEntity i:employeeRes.findAll()) {
			EmployeeDTO dto=new EmployeeDTO();
			dto.setId(i.getId());
			dto.setName(i.getName());
			dto.setAddress(i.getAddress());
			lstDto.add(dto);
		}
		return lstDto;
		
	}
	@Override
	public EmployeeDTO getByid(long id)
	{
		EmployeeDTO dto=new EmployeeDTO();
		EmployeeEntity entity=employeeRes.findById(id);
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		return dto;
		
	}
	@Override 
	public HttpStatus saveEmployee(EmployeeDTO employeeDTO)
	{
		EmployeeEntity entity=new EmployeeEntity();
		entity.setName(employeeDTO.getName());
		entity.setAddress(employeeDTO.getAddress());
		employeeRes.save(entity);
		return HttpStatus.OK;
	}
	@Override
	public HttpStatus updateEmployee(EmployeeDTO employeeDTO,long id)
	{
		EmployeeEntity employeeEntity=employeeRes.findById(id);
		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setAddress(employeeDTO.getAddress());
		employeeRes.save(employeeEntity);
		return HttpStatus.OK;
	}
	@Override
	public HttpStatus updateEmployeefake(EmployeeDTO employeeDTO)
	{
		EmployeeEntity entity=employeeRes.findById(employeeDTO.getId());
		entity.setId(employeeDTO.getId());
		entity.setName(employeeDTO.getName());
		entity.setAddress(employeeDTO.getAddress());
		employeeRes.save(entity);
		return HttpStatus.OK;
	}
	@Override
	public void deleteEmployee(long id)
	{
		EmployeeEntity entity=employeeRes.findById(id);
		employeeRes.delete(entity);
	}

	

}
