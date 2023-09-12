package FileReading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.AddressBean;
import Entity.ClassBean;
import Entity.StudentBean;

public class CsvFileRead {
	public List<ClassBean> readClassFile() {
		List<ClassBean> classBean = new ArrayList<>();
		String path = "C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\class.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] fields = line.split(",");
                if(fields.length!=1||fields.length<=0) {
				ClassBean bean = new ClassBean();
				bean.setId((Integer.parseInt(fields[0])));
				bean.setName(fields[1]);
				classBean.add(bean);
                }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classBean;
	}

	public List<AddressBean> readAdressCsvFile() {
		List<AddressBean> adressBeans = new ArrayList<>();
		String path = "C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\Address.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] fields = line.split(",");

				AddressBean bean = new AddressBean();
				bean.setId((Integer.parseInt(fields[0])));
				bean.setPinCode(fields[1]);
				bean.setCity(fields[2]);
				bean.setStudentId(Integer.parseInt(fields[3]));
				adressBeans.add(bean);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adressBeans;
	}

	public List<StudentBean> readStudnetCsvFile() {
		List<StudentBean> studentBeans = new ArrayList<>();
		String path = "C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\Student.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] fields = line.split(",");

				StudentBean bean = new StudentBean();
				bean.setId((Integer.parseInt(fields[0])));
				bean.setName(fields[1]);
				bean.setClassId(Integer.parseInt(fields[2]));
				bean.setMarks(Float.parseFloat(fields[3]));
				bean.setGender(fields[4].charAt(0));
				bean.setAge(Integer.parseInt(fields[5]));
				studentBeans.add(bean);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studentBeans;
	}
	
	public void writeStduentCsvFile(List<StudentBean> students)
	{
		String path="C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\Student.csv";
		// Write data to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Write the header
           bw.write("id,name,class_id,marks,gender,age");
            bw.newLine();

            // Write data for each student and their address
            for (int i = 0; i < students.size(); i++) {
              StudentBean student=students.get(i);
                bw.write(student.getId() + "," + student.getName() + "," + student.getClassId() + ","
                        + student.getMarks() + "," + student.getGender() + "," + student.getAge());
                bw.newLine();
            }

            System.out.println("Data has been written to " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void writeAddressCsvFile(List<AddressBean> addressBeans)
	{
		String path="C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\Address.csv";
		// Write data to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Write the header
           bw.write("id ,pin_code,city,student_id");
            bw.newLine();

            // Write data for each student and their address
            for (int i = 0; i < addressBeans.size(); i++) {
              AddressBean address=addressBeans.get(i);
                bw.write(address.getId() + "," + address.getPinCode() + "," + address.getCity()+ ","
                        + address.getStudentId());
                bw.newLine();
            }
            System.out.println("Data has been written to " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
