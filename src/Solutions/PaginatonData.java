package Solutions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Entity.StudentBean;

public class PaginatonData {

	 public List<StudentBean> findFemale(List<StudentBean> students, int start, int end, char gender){
	        return students.stream()
	                .skip(start)
	                .limit(end)
	                .filter(s -> s.getGender()==gender)
	                .collect(Collectors.toList());
	    }
	 
	    public List<StudentBean> femaleOrderByName(List<StudentBean> students, long start, long end, char gender){
	        return students.stream()
	                .skip(start - 1)
	                .limit(end - start + 1)
	                .filter(s -> s.getGender()==gender)
	                .sorted(Comparator.comparing(StudentBean::getName))
	                .collect(Collectors.toList());
	    }
	    public List<StudentBean> femaleOrderByMarks(List<StudentBean> students, int start, int end, char gender){
	        return students.stream()
	                .skip(start - 1)
	                .limit(end - start + 1)
	                .filter(s -> s.getGender()==gender)
	                .sorted(Comparator.comparing(StudentBean::getMarks).reversed())
	                .collect(Collectors.toList());
	    }

}
