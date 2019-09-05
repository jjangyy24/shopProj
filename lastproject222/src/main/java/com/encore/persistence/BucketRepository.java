package com.encore.persistence;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.encore.domain.Bucket;

public interface  BucketRepository extends CrudRepository<Bucket, Long>{
	
	List<Bucket> findByUserseq(Long num);
	
	List<Bucket> findByOrderseq(Long num);
	
	
	@Modifying
	@Transactional
	@Query(value ="update bucket set condition='payment', orderseq=?1 where condition='bucket' and checked=1 and userseq=?2",nativeQuery = true)
	void afterpayment(Long num,Long idnum);
	
	@Modifying
	@Transactional
	@Query(value ="update product_order set orderstate='주문취소',canceldate=sysdate where orderseq=?1",nativeQuery = true)
	void cancelproduct_order(Long num);
	
	@Modifying
	@Transactional
	@Query(value ="update bucket set condition='cancel' where orderseq=?1",nativeQuery = true)
	void cancelbucket(Long num);
	
	List<Bucket> findByStoreseq(Long seq);
}
