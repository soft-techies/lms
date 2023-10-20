package com.masters.Tables.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masters.Tables.Repository.BatchRepo;
import com.masters.Tables.Repository.CourseRepo;
import com.masters.Tables.Repository.UniversityRepo;
import com.masters.Tables.model.Batch;
import com.masters.Tables.model.BatchRel;
import com.masters.Tables.model.BatchSubjectRel;
import com.masters.Tables.model.Course;
import com.masters.Tables.model.University;
import com.masters.Tables.model.request.BatchRelRequest;
import com.masters.Tables.service.FormsService;
import com.masters.Tables.service.UpdateService;

@CrossOrigin("*")
@RestController
@RequestMapping("/uniform")
public class UniformController {
	
	@Autowired
	UpdateService updateservice;
	
	@Autowired
	FormsService formrepo;
	
	@Autowired
	UniversityRepo unirepo;
	
	@Autowired
	BatchRepo batchrepo;
	
	@Autowired 
	CourseRepo courserepo;
	
	@PostMapping("/updateMultipleFieldTable")
	public int updateMultiple(@RequestParam String tableName, @RequestParam(required = false) String[] setField,@RequestParam(required = false) String[] setValue,
			@RequestParam(required = false) String whereField,@RequestParam(required = false) String whereValue) {
		return updateservice.UpdateMultiple(tableName, setField, setValue, whereField, whereValue);
	}
	
	@PostMapping("/insert")
	public int insert(@RequestBody BatchSubjectRel requestdata){
		Long batchid = requestdata.getBatch_id();
		Long subid = requestdata.getSubject_id();
		String tablename = requestdata.getTablename();
		return formrepo.insertIntoBatchSubjectRel(tablename,batchid, subid);
	}
	
	@PostMapping("/insertRel")
	public int insert(@RequestBody BatchRel requestdata){
		Long batchid = requestdata.getBatch_id();
		Long uniid = requestdata.getUni_id();
		Long courseid = requestdata.getCourse_id();
		String tablename = requestdata.getTablename();
		return formrepo.insertIntoRel(tablename,batchid, uniid,courseid);
	}
	
	//@RequestParam University university,@RequestParam Batch batch,@RequestParam Course course
	@PostMapping("/dropdown")
	public List<Long> dropdownForm(@RequestBody BatchRelRequest data) {  //,String batch,String course 
		List<Long> ids = new ArrayList<Long>();
		Long course_id = null,batch_id = null,uni_id = null;
		System.out.println(data.getUni_name());
		University uni = unirepo.findByName(data.getUni_name());
		System.out.println(uni);
		
		
		if(uni!=null) {
		 uni_id = uni.getId();
			ids.add(uni.getId());
		}
		
		Batch batchname = batchrepo.findByName(data.getBatch_name());
		if(batchname!=null) {
			 batch_id = batchname.getId();
			ids.add(batchname.getId());
		}
		
	    Course coursename = courserepo.findByName(data.getCourse_name());		
		if(coursename!=null) {
			 course_id = coursename.getId();
			ids.add(coursename.getId());
		}
		
        formrepo.insertIntoRel("batchrel", uni_id, batch_id, course_id)	;	
		return ids;
	}

}
