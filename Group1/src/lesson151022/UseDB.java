package lesson151022;

public class UseDB {

	public static void main(String[] args) {

		int id = 1;

		Student t = DBManager.get(Student.class, id);

		if (t == null) {
			System.out.println("no such student with id " + id);
		} else {
			System.out.println(t.name);
		}

		Student t2 = new Student();

		DBManager.save(t2);

	}

}
