package lesson151026;

import org.apache.ibatis.annotations.Select;

public interface DeptMapper {

	@Select("select * from dept where id = #{id}")
	Department getDept(int id);
	
}
