package com.assignment.Demandtec.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.Demandtec.model.Moogle;

public interface MoogleRepository extends JpaRepository<Moogle, Integer>, MoogleRepositoryExt {

	
	  
		@Query(value="SELECT * FROM moogle_table WHERE MATCH(heading)"
			+ "AGAINST (?1)",nativeQuery=true)
		public List<Moogle> searchKeyword(String keyword);
		//	@Query(value="SELECT * FROM moogle_table WHERE heading=?1",nativeQuery=true)
		//	public List<Moogle> searchKeyword(String keyword);
}
