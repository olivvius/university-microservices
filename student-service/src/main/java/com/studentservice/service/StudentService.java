package com.studentservice.service;

import com.studentservice.entity.Student;
import com.studentservice.repository.StudentRepository;
import com.studentservice.request.CreateStudentRequest;
import com.studentservice.response.AddressResponse;
import com.studentservice.response.StudentResponse;
import com.studentservice.feignclients.AddressFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {


	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;

	@Autowired
	AddressFeignClient addressFeignClient;

	@Autowired
	CommonService commonService;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {


		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

		return studentResponse;
	}

/*	@CircuitBreaker(name = "adressService", fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById(long addressId){

		AddressResponse addressResponse = addressFeignClient.getById(addressId);

		return addressResponse;

	}

	public AddressResponse fallbackGetAddressById(long addressId, Throwable th){
		return new AddressResponse();
	}*/


}
