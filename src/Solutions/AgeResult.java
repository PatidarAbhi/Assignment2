package Solutions;

import java.util.List;
import java.util.stream.Collectors;

import Entity.ClassBean;
import Entity.StudentBean;

public class AgeResult {

	public List<StudentBean> fetchStudentByAge(List<StudentBean> studentBeans) {
		return studentBeans.stream().filter(a->a.getAge()>20).collect(Collectors.toList());
		
	}
}
