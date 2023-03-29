package com.javapratik.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javapratik.sms.entity.Student;
import com.javapratik.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Student stu1= new Student( "Pratik","Pande","pratik998@gmail.com");
		 * studentRepo.save(stu1); Student stu2= new Student(
		 * "Akash","Dubey","akash455@gmail.com"); studentRepo.save(stu2); Student stu3=
		 * new Student( "Amar","Singh","amar499@gmail.com"); studentRepo.save(stu3);
		 */
		


	}

}
