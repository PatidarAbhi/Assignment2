package Solutions;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Entity.StudentBean;

public class RankOfStudent {
	 public Map<String, List<StudentBean>> ranking(List<StudentBean> students)
	    {
	        Map<String, List<StudentBean>> rank = new LinkedHashMap<>();
	        List<StudentBean> first = students.stream().sorted(Comparator.comparing(StudentBean::getMarks).reversed()).findFirst().stream().collect(Collectors.toList());
	        List<StudentBean> second = students.stream().sorted(Comparator.comparing(StudentBean::getMarks).reversed()).skip(1).findFirst().stream().collect(Collectors.toList());
	        List<StudentBean> third = students.stream().sorted(Comparator.comparing(StudentBean::getMarks).reversed()).skip(2).findFirst().stream().collect(Collectors.toList());

	        rank.put("First Rank", first);
	        rank.put("Second Rank", second);
	        rank.put("Third Rank", third);

	        List<StudentBean> pass = students.stream().sorted(Comparator.comparing(StudentBean::getMarks).reversed()).skip(3).filter(s -> s.getMarks() >= 50).collect(Collectors.toList());
	        rank.put("Pass", pass);

	        List<StudentBean> fail = students.stream().sorted(Comparator.comparing(StudentBean::getMarks).reversed()).skip(3).filter(s -> s.getMarks() < 50).collect(Collectors.toList());
	        rank.put("Fail", fail);

	        return rank;
	    }

}
