package com.techymeet.SpringbootRepositorycurd.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.techymeet.SpringbootRepositorycurd.Entity.UserVo;
@Repository
public interface UserRepository extends JpaRepository<UserVo,Integer >  {

	List<UserVo> findByfirstName(String name);
	@Query(value="SELECT *FROM user where first_name like %:name%",nativeQuery = true)
	List<UserVo> searchByUserName(String name);


	
}
