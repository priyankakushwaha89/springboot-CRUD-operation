package com.student.student_detail;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{

	java.util.List<Student> findByName(String name);

	java.util.List<Student> findByCity(String city);
}
