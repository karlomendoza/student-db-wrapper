package k3m.mx.test.eurekastudent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import k3m.mx.test.eurekastudent.entities.Student;

@RestController
public class StudentController {
	
	

	@RequestMapping(value ="/getStudentsForSchool/{schoolname}", method=RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		List<Student> students = schooDB.get(schoolname);
		if (students == null) {
            students = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            students.add(std);
        }
        return students;
	}
	
    private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
    
    static {
        schooDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        Student std = new Student("Sajal", "Class IV");
        lst.add(std);
        std = new Student("Lokesh", "Class V");
        lst.add(std);
 
        schooDB.put("abcschool", lst);
 
        lst = new ArrayList<Student>();
        std = new Student("Kajal", "Class III");
        lst.add(std);
        std = new Student("Sukesh", "Class VI");
        lst.add(std);
 
        schooDB.put("xyzschool", lst);
 
    }
 
}
