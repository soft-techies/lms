package com.masters.Tables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masters.Tables.Repository.BatchRepo;
import com.masters.Tables.Repository.CourseRepo;
import com.masters.Tables.Repository.ExaminationRepo;
import com.masters.Tables.Repository.FacultyRepo;
import com.masters.Tables.Repository.GroupRepo;
import com.masters.Tables.Repository.SyllabusRepo;
import com.masters.Tables.Repository.TopicRepo;
import com.masters.Tables.Repository.UnitRepo;
import com.masters.Tables.Repository.UniversityRepo;
import com.masters.Tables.model.Batch;
import com.masters.Tables.model.BatchSubjectRel;
import com.masters.Tables.model.Course;
import com.masters.Tables.model.Examination;
import com.masters.Tables.model.Faculty;
import com.masters.Tables.model.Group;
import com.masters.Tables.model.Syllabus;
import com.masters.Tables.model.Topic;
import com.masters.Tables.model.Unit;
import com.masters.Tables.model.University;
import com.masters.Tables.service.FormsService;
import com.masters.Tables.service.UpdateService;

@CrossOrigin("*")
@RestController
@RequestMapping("/uni")
public class UniversityController {
	
	@Autowired
	UniversityRepo universityrepository;
	
	@Autowired
	BatchRepo batchrepository;
	
	@Autowired
	CourseRepo courserepo;
	
	@Autowired
	ExaminationRepo examrepo;
	
	@Autowired
	GroupRepo grprepo;
	
	@Autowired
	SyllabusRepo syllrepo;
	
	@Autowired
	TopicRepo topicrepo;
	
	@Autowired
	UnitRepo unitrepo;
	
	@Autowired
	FacultyRepo facutyrepo;
	
	@Autowired
	UpdateService updateservice;
	
	@Autowired
	FormsService form;
	
	
	@GetMapping("/string")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/getUniData")
	public List<University> getAllData(){
		return universityrepository.findAll();	
	}
	
	@PostMapping("/saveUniData")
	public University save(@RequestBody University data) {
		 return universityrepository.save(data);
		
	}
	
	@GetMapping("/getbatchData")
	public List<Batch> getbatchData(){
		return batchrepository.findAll();		
	}
	
	@PostMapping("/savebatchData")
	public Batch save(@RequestBody Batch data) {
		 return batchrepository.save(data);
		
	}
	
	@GetMapping("/getCourseData")
	public List<Course> getCourseData(){
		return courserepo.findAll();		
	}
	
	@PostMapping("/saveCourseData")
	public Course save(@RequestBody Course data) {
		 return courserepo.save(data);
		
	}
	
	@GetMapping("/getGroupData")
	public List<Group> getGroupdata(){
		return grprepo.findAll();
	}
	
	@PostMapping("/saveGroupData")
	public Group save(@RequestBody Group data) {
		 return grprepo.save(data);
		
	}
	
	@GetMapping("/getExaminationData")
	public List<Examination> getExamdata(){
		return examrepo.findAll();
	}
	
	@PostMapping("/saveExaminationData")
	public Examination save(@RequestBody Examination data) {
		 return examrepo.save(data);
		
	}
	
	@GetMapping("/getSyllData")
	public List<Syllabus> getSylldata(){
		return syllrepo.findAll();
	}
	
	@PostMapping("/saveSyllData")
	public Syllabus save(@RequestBody Syllabus data) {
		 return syllrepo.save(data);
		
	}
	
	@GetMapping("/getTopicData")
	public List<Topic> getTopicData(){
		return topicrepo.findAll();
	}
	
	@PostMapping("/saveTopicData")
	public Topic save(@RequestBody Topic data) {
		 return topicrepo.save(data);
		
	}
	
	@GetMapping("/getUnitData")
	public List<Unit> getUnitData(){
		return unitrepo.findAll();
	}
	
	@GetMapping("/getFacultyData")
	public List<Faculty> getFacultyData(){
		return facutyrepo.findAll();
	}
	@PostMapping("/saveFacultyData")
	public Faculty save(@RequestBody Faculty data) {
		return facutyrepo.save(data);
	}
	
	
	@PostMapping("/saveUnitData")
	public Unit save(@RequestBody Unit data) {
		 return unitrepo.save(data);
		
	}
	
	@PostMapping("/deleteUnitData")
	public String delete(@RequestBody Long id) {
	    
		unitrepo.deleteById(id);
		return "deleted";
		
	}
	
	
	
//	@PostMapping("/updateSingleFieldTable")
//	public int updateQuery(@RequestParam String tableName, @RequestParam(required = false) String setField,@RequestParam(required = false) String setValue,
//			@RequestParam(required = false) String whereField,@RequestParam(required = false) String whereValue) {
//		return updateservice.UpdateQuery(tableName, setField, setValue, whereField, whereValue);
//	}
	

	

}
