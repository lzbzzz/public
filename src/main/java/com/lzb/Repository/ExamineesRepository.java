package com.lzb.Repository;

import com.lzb.model.examinees;
import com.lzb.model.role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamineesRepository extends JpaRepository<examinees,Integer> {
}
