package com.aniketsenvasy.sessionerppos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aniketsenvasy.sessionerppos.model.UserRecord;
import com.aniketsenvasy.sessionerppos.repository.RecordRepository;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/records")
public class RecordController {

	@Autowired
	private RecordRepository recordRepository;

	@GetMapping("/create")
	public String showCreateRecordForm() {
		return "createRecord"; // Return the create record view page name
	}

	@PostMapping("/create")
	public String createRecord(String name, String mobileNumber) {
		UserRecord record = new UserRecord();
		record.setName(name);
		record.setMobileNumber(mobileNumber);
		recordRepository.save(record);

		return "redirect:/records/list"; // Redirect to the record listing page
	}

	@GetMapping("/list")
	@ResponseBody
	public List<UserRecord> showRecordList() {
		List<UserRecord> records = recordRepository.findAll();
//         model.addAttribute("records", records);
		return records; // Return the record list view page name
	}

//    @GetMapping("/list")
//    public ModelAndView showRecordList() {
//    	List<UserRecord> records = recordRepository.findAll();
//    	System.out.println("========>"+records.size());
//        ModelAndView modelAndView = new ModelAndView("viewRecords");
//        modelAndView.addObject("records", records);
//
//        return modelAndView; 
//    }

}
