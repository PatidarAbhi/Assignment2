package Solutions;

import java.io.FileWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Entity.ClassBean;
import Entity.StudentBean;

public class DeleteClass {
   
	public void deleteClassIfEmpty(List<StudentBean> list,List<ClassBean> classBeans)
	{
		Set<Integer> classNames=list.stream().map(a->a.getClassId()).collect(Collectors.toSet());
		//classNames.forEach(System.out::println);
		List<ClassBean> classBeans2=classBeans.stream().filter(a->classNames.contains(a.getId())).collect(Collectors.toList());
		//classBeans2.forEach(System.out::println);
		try {
			String path = "C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\class.csv";
			FileWriter studFileWriter= new FileWriter(path);
			 studFileWriter.write("id,name\n");
	            for (ClassBean cl : classBeans2) {
	                studFileWriter.write(cl.getId() + "," + cl.getName()+ "\n");
	            }
	            studFileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
