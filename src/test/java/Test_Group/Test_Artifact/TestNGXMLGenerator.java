package Test_Group.Test_Artifact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;
import java.util.List;

public class TestNGXMLGenerator {

	public static void main(String[] a) {

		String testCases = "";
		String line = "";
		String filePath = System.getProperty("user.home") + "\\Desktop\\" + java.time.LocalDate.now() + "\\" + a[0] + ".txt";

		try {
			File f = new File(filePath);
			FileReader freader = new FileReader(f);
			BufferedReader bReader = new BufferedReader(freader);

			while ((line = bReader.readLine()) != null) {
				testCases += " " + line;
			}

			bReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("List of test-cases:" + testCases);

		String[] testCasesList = testCases.split("  ");

		// This generates suite tags
		XmlSuite suite = new XmlSuite();
		suite.setName("TestCasesListForVM");

		// Adding test tag under suite tag
		XmlTest test = new XmlTest(suite);
		test.setName("TestCasesListForVMTest");

		// Adding class tag under test tag
		List<XmlClass> classes = new ArrayList<XmlClass>();

		String path = "Test_Group.Test_Artifact.Test";

		for (int i = 0; i < testCasesList.length; i++) {
			classes.add(new XmlClass(path + testCasesList[i].trim()));
		}

		test.setXmlClasses(classes);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);

		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
		testng.run();
	}

}
