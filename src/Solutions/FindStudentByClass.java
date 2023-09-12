package Solutions;

import java.util.List;
import java.util.stream.Collectors;

import Entity.ClassBean;
import Entity.StudentBean;

public class FindStudentByClass {
	
	public List<StudentBean> findStudentByClassName(List<StudentBean> studentBeans,String className,List<ClassBean> beans) {
	List<Integer> list=	beans.stream().filter(c->c.getName().equalsIgnoreCase(className)).map(a->a.getId()).collect(Collectors.toList());
	 return studentBeans.stream().filter(a->list.contains(a.getId())).collect(Collectors.toList());
	}

}
