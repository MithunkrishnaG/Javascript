package com.project.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.college.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
