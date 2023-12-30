package boot.smp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import boot.smp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
	
	//JPQL 
	public User findByUserId(String userId);
	
	
	
	/*
	 * 
	 * 
	 * //JPQL
	 * 
	 * @Query("SELECT S FROM Student S") public List<User> getAllStudent();
	 * 
	 * //JPQL
	 * 
	 * @Query("SELECT S FROM Student S WHERE S.studentName =:variableName") public
	 * List<User> getStudentByName(@Param("variableName") String name);
	 * 
	 * //HQL
	 * 
	 * @Query(value="SELECT * FROM STUDENT_REPO" , nativeQuery = true) public
	 * List<User> getStudents();
	 * 
	 * public void deleteByStudentName(String name);
	 */

}
