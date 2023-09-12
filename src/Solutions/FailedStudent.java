package Solutions;

import java.util.List;
import java.util.stream.Collectors;

import Entity.StudentBean;

public class FailedStudent {

	public List<StudentBean> getFailedStudent(List<StudentBean> studentBeans) {
		return studentBeans.stream().filter(pass -> pass.getMarks() < 50).collect(Collectors.toList());
	}
}
