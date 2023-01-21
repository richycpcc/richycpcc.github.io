package io.catalyte.training;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> findByLastName(String lastName);
}
