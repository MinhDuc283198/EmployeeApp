package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.EmployeeEntity;

@Repository
public interface EmployeeRespsitory extends JpaRepository<EmployeeEntity, String> {

	EmployeeEntity findById(long id);

	EmployeeEntity findByName(String name);

	
	
}
