package io.catalyte.training;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping
  public ResponseEntity<List<Employee>> getEmployees() {
    return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

    Optional<Employee> employee = employeeRepository.findById(id);

    if (employee.isPresent()) {
      return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    } else {
      throw new EmployeeNotFoundException();
    }
  }

  @GetMapping("/search")
  public ResponseEntity<List<Employee>> findEmployeesByLastName(
      @RequestParam("lastname") String name) {

    return new ResponseEntity<>(employeeRepository.findByLastName(name), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {

    boolean employeeExists = employeeRepository.existsById(id);

    if (employeeExists) {
      employeeRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      throw new EmployeeNotFoundException();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> replaceEmployee(
      @RequestBody Employee newEmployee, @PathVariable Long id) {

    boolean employeeExists = employeeRepository.existsById(id);

    if (employeeExists) {
      return new ResponseEntity<>(employeeRepository.save(newEmployee), HttpStatus.OK);
    } else {
      throw new EmployeeNotFoundException();
    }
  }

  @PostMapping
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
  }
}
