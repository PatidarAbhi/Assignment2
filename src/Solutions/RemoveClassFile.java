package Solutions;

import java.io.File;

public class RemoveClassFile {
	
	public boolean deleteClassFile()
	{
		String csvFile="C:\\JAVA BHAI JAVA\\SecondAssg\\src\\Static\\Class.csv";
		   File file = new File(csvFile);
		   int l=(int) file.length();
	        if (file.length() == 0) {
	            if (file.delete()) {
	                System.out.println(csvFile + " has been deleted because it was empty.");
	                return true;
	            } else {
	                System.out.println("Failed to delete " + csvFile + " because it was empty.");
	                return false;
	            }
	        }
	        else
	        {
	        	return false;
	        }
	}

}
