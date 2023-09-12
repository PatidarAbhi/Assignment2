package MainClass;

import java.util.List;
import java.util.Map;

import Entity.AddressBean;
import Entity.ClassBean;
import Entity.StudentBean;
import FileReading.CsvFileRead;
import Solutions.AgeResult;
import Solutions.DeleteClass;
import Solutions.DeleteStudentById;
import Solutions.FailedStudent;
import Solutions.FindStudentByCity;
import Solutions.FindStudentByClass;
import Solutions.FindStudentByPincode;
import Solutions.PaginatonData;
import Solutions.PassedStudent;
import Solutions.RankOfStudent;
import Solutions.RemoveClassFile;

public class MainClass {

	public static void main(String[] args) {
		CsvFileRead csvFileRead = new CsvFileRead();
		List<ClassBean> Classbeans = csvFileRead.readClassFile();
		List<StudentBean> studentBeans = csvFileRead.readStudnetCsvFile();
		List<AddressBean> addressBeans = csvFileRead.readAdressCsvFile();

		// Find all students of pincode X(ex X = 482002). I can pass different filters
		// like gender, age, class
		System.out.println("question 1");
		FindStudentByPincode byPincode=new FindStudentByPincode();
		List<StudentBean> beans =byPincode.findStudentByPinCode("452002", addressBeans, studentBeans);
		beans.forEach(System.out::println);
		System.out.println();

		// Find all students of city ex X = Indore. I can pass different filters like
		// gender, age, class
		System.out.println("question 2");
		List<StudentBean> byCity = new FindStudentByCity().findStudentByCity("Indore", addressBeans, studentBeans);
		byCity.forEach(System.out::println);
		System.out.println();

		// marks < 50 failed else passed
		// Give ranks to highest mark achievers.
		// Highest marks - First
		//
		// Third Highest marks - third
		// Rest of all pass / fail
		System.out.println("question 3");
		RankOfStudent studentList = new RankOfStudent();
		Map<String, List<StudentBean>> rank = studentList.ranking(studentBeans);
		for (Map.Entry<String, List<StudentBean>> map : rank.entrySet()) {
			System.out.println(map);
		}
		System.out.println();

		// Get the passed students. I can pass different filters like gender, age,
		// class, city, pincode
		System.out.println("question 4");
		PassedStudent passedStudent = new PassedStudent();
		List<StudentBean> passedStud = passedStudent.getPassedStudent(studentBeans);
		passedStud.forEach(System.out::println);
		System.out.println();

		// Get the failed students. I can pass different filters like gender, age,
		// class, city, pincode
		System.out.println("question 5");
		FailedStudent failedStudent = new FailedStudent();
		List<StudentBean> failedStu = failedStudent.getFailedStudent(studentBeans);
		failedStu.forEach(System.out::println);
		System.out.println();

		// Find all student of class X (ex X = A). I can pass different filters like
		// gender, age, class, city, pincode
		System.out.println("question 6");
		FindStudentByClass byClass = new FindStudentByClass();
		List<StudentBean> classX = byClass.findStudentByClassName(studentBeans, "A", Classbeans);
		classX.forEach(System.out::println);
		System.out.println();

		// It should fail if student record is having age > 20.
		System.out.println("question 8");
		AgeResult ageResult = new AgeResult();
		List<StudentBean> failedIf20 = ageResult.fetchStudentByAge(studentBeans);
		failedIf20.forEach(System.out::println);
		System.out.println();

		// I should be able to delete student. After that it should delete the
		// respective obj from Address & Student.
		// DeleteStudentById byId=new DeleteStudentById();
		System.out.println("question 9");
		int idToDelete = 7;
		studentBeans.removeIf(a -> a.getId() == idToDelete);
		addressBeans.removeIf(a -> a.getId() == idToDelete);
		csvFileRead.writeStduentCsvFile(studentBeans);
		csvFileRead.writeAddressCsvFile(addressBeans);
        
		System.out.println("question 10");
		//delete class if no student in that class
		DeleteClass class1 = new DeleteClass();
		class1.deleteClassIfEmpty(studentBeans, Classbeans);
		System.out.println();
		
		System.out.println("question 11");
//      Give start and end for pagination
		PaginatonData data=new PaginatonData();
        char gender = 'F';
      List<StudentBean> paginatedFemale = data.findFemale(studentBeans, 1, 9, gender);
      System.out.println("Female List from" + 1 + " to " + 9);
      paginatedFemale.forEach(System.out::println);

		// Order by name
		System.out.println();
		List<StudentBean> orderByName = data.femaleOrderByName(studentBeans, 5, 8, gender);
		System.out.println("Order By Name :");
		orderByName.forEach(System.out::println);
		
		// Order by marks
		System.out.println();
		List<StudentBean> orderByMarks = data.femaleOrderByMarks(studentBeans, 5, 8, gender);
		System.out.println("Order By Marks :");
		orderByMarks.forEach(System.out::println);
		

	}

}
