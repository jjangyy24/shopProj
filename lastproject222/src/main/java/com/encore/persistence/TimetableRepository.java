package com.encore.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.encore.domain.Timetable;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable, Long>{
	List<Timetable> findByProductseq(Long productseq);
}
