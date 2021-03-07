package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.glassfish.gmbal.ParameterNames;

import dto.EmployeeDTO;
import service.employeeService;
import service.employeeServiceImpl;

@RestController
//@CrossOrigin (origins = "http: // localhost: 4200")
//@RequestMapping("/api")
public class employeeController {
	@Autowired
	private employeeService employeeSer;
	@GetMapping("/")
	@ResponseBody
	public List<EmployeeDTO> findAll()
	{
		return employeeSer.findAll();
	}
	@GetMapping("/{id}")
	@ResponseBody
	public EmployeeDTO getByName(@PathVariable("id") Long id)
	{
		return employeeSer.getByid(id);
	}
	@PostMapping("/save")
	@ResponseBody
	public HttpStatus createEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		employeeSer.saveEmployee(employeeDTO);
		return HttpStatus.OK;
	}
	@PutMapping("/update")
	@ResponseBody
	public EmployeeDTO editEmployee(@RequestBody EmployeeDTO employeeDTO )
	{
		employeeSer.updateEmployeefake(employeeDTO);
		return employeeDTO;
	
	}
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteEmployee(@PathVariable("id") Long id)
	{
		employeeSer.deleteEmployee(id);
	}
}
