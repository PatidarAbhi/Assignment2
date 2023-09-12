package Solutions;

import java.util.List;
import java.util.stream.Collectors;

import Entity.AddressBean;
import Entity.ClassBean;
import Entity.StudentBean;
import FileReading.CsvFileRead;

public class FindStudentByPincode {
	public List<StudentBean> findStudentByPinCode(String pinCode, List<AddressBean> beans,
			List<StudentBean> studentBean) {
		List<Integer> studentId = beans.stream().filter(st -> st.getPinCode().equals(pinCode))
				.map(a -> a.getStudentId()).collect(Collectors.toList());
		return studentBean.stream().filter(a -> studentId.contains(a.getId())).collect(Collectors.toList());
	}
}
