package com.tekion.udemyjpahibernate;

import com.tekion.udemyjpahibernate.datasource.model.*;
import com.tekion.udemyjpahibernate.datasource.repository.CourseRepository;
import com.tekion.udemyjpahibernate.datasource.repository.CourseSpringDataRepository;
import com.tekion.udemyjpahibernate.datasource.repository.EmployeeRepository;
import com.tekion.udemyjpahibernate.datasource.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

@SpringBootApplication
public class UdemyJpaHibernateApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(UdemyJpaHibernateApplication.class);
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	CourseSpringDataRepository repository;


	@Override
	public void run(String... args) throws Exception {
//		logger.info("{}",courseRepository.findById(1001));
//		courseRepository.deleteById(1001);
//		logger.info("{}", courseRepository.save(new Course("Hello3")));
//		logger.info("{}", courseRepository.findAll());
//		logger.info("{}", studentRepository.saveStudentWithPassport());
//		logger.info("{}", studentRepository.findAll());
//		studentRepository.findStudentWithPassport(702);
//		studentRepository.retrievePassportAssociatedStudent(702);

//		courseRepository.addReviewsForCourse(100, List.of(new Review("Rating 3", "Review 3")));
//		logger.info("{}",courseRepository.getReviewsForCourse(100));
//		logger.info("{}",courseRepository.getCourseForReview(52));
//
//		courseRepository.retrieveCourseAndStudents(2102);

//		studentRepository.saveStudentWithCourse();
//		employeeRepository.insert(new FullTimeEmployee("Ankit", new BigDecimal("10000")));
//		employeeRepository.insert(new PartTimeEmployee("Ankit D. Raj", new BigDecimal("100000")));
//		logger.info("{}", employeeRepository.findAll());
		List<Course> courses = repository.findAll();
//		List<String> properties = new ArrayList<>();
//		List<Course> sortedCourses = repository.findAll(Sort.by(Sort.Direction.DESC,"name"));
//
//		Pageable pageable = PageRequest.of(1, 3, Sort.by(Sort.Direction.DESC,"name"));
//		Page<Course> pageCourses = repository.findAll(pageable);
//		Pageable nextPage  = pageCourses.nextPageable();
//		Page<Course> pageNextCourses = repository.findAll(nextPage);
//		pageCourses.getContent();
//		repository.findByName("ANki");
//		repository.findByName("ANki");
	}

	public static void main(String[] args) {
		SpringApplication.run(UdemyJpaHibernateApplication.class, args);
	}

}
