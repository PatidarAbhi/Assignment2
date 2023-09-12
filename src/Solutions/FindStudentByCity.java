package Solutions;

import java.util.List;
import java.util.stream.Collectors;

import Entity.AddressBean;
import Entity.StudentBean;

public class FindStudentByCity {

	public List<StudentBean> findStudentByCity(String city, List<AddressBean> addressBeans,
			List<StudentBean> studentBean) {
		List<Integer> integers = addressBeans.stream()
				.filter(addressBean -> addressBean.getCity().equalsIgnoreCase(city)).map(a -> a.getStudentId())
				.collect(Collectors.toList());

		return studentBean.stream().filter(a -> integers.contains(a.getId())).collect(Collectors.toList());

	}
}
