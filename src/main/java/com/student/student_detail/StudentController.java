package com.student.student_detail;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController // :Rest stands for representational state transfers

public class StudentController
{
	@Autowired
	StudentRepository erepo;
	
	@RequestMapping("/test")
	public String test()
	{
		return "hello you are hacked";
	}
	// To create data
	@RequestMapping("/savedata")
	public String save(@RequestBody Student s)
	{
		 erepo.save(s);
		 return "Data is saved into the database";
	}
	
	//To read data
	@RequestMapping("/findall")
	public List<Student> alldata()
	{
		return erepo.findAll();
	}
	@RequestMapping("/{id}")
	public Optional<Student> byId(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	
	@RequestMapping("/name/{name}")
	public List<Student> byName(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	
	@RequestMapping("/city/{city}")
	public List<Student> byCity(@PathVariable String city)
	{
		return erepo.findByCity(city);
	}
	//To update data
	@RequestMapping("upd/{id}")
	public String update(@RequestBody Student st,@PathVariable int id)
	{
	  Student s=erepo.findById(id).get();
	 s.setName(st.getName());
	 s.setCity(st.getCity());
	 s.setAge(st.getAge());
	 s.setFname(st.getFname());
	 s.setLname(st.getLname());
	 erepo.save(s);
	 return "Data id updated";
	}
	
	// To delete data 
	@RequestMapping("del/{id}")
	public String delete(@PathVariable int id)
	{
		Student s=erepo.findById(id).get();
		erepo.deleteById(id);
		return "Data deleted";
	}
}
