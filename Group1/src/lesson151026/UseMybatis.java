package lesson151026;

import java.io.IOException;
import java.io.Reader;

import lesson151022.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMybatis {
	
	private static SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) {

		try {
			Reader resourceReader = Resources.getResourceAsReader("lesson151026/config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(
					resourceReader);
			
			sqlSessionFactory.getConfiguration().addMapper(StudentMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		doWork();
		
	}

	private static void doWork() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = mapper.getStudent(1);
			System.out.println(student.getName());
		} finally {
			session.close();
		}

	}
	
	
	
}
