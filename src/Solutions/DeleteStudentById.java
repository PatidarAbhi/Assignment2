package Solutions;

import java.util.List;
import java.util.stream.Collectors;

import Entity.StudentBean;

public class DeleteStudentById {
	
	public List<StudentBean> deleteStudentByAdmin(int id,List<StudentBean> list)
	{
	     return list.stream().filter(a->a.getId()!=id).collect(Collectors.toList());
	}
	
	//delete from csv
	
	
}
