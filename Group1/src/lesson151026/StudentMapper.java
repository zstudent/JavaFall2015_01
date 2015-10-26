package lesson151026;

import org.apache.ibatis.annotations.Select;

import lesson151022.Student;

public interface StudentMapper {  // ORM  Object-relation mapping

	@Select("select * from student where id = #{id}")
	Student getStudent(int id);
	
}
