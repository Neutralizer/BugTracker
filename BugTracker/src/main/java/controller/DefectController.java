package controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.defect.Defect;
import model.defect.DefectRequestData;
import model.defect.Severity;
import model.defect.Status;
import service.comment.CommentActionService;
import service.defect.DefectActionService;

@Controller
public class DefectController {

	@Autowired
	DefectActionService defectActionService;

	@Autowired
	CommentActionService commentActionService;

	
	@RequestMapping(value = "/defect", method = RequestMethod.GET)
	public String defects(Model model) {
		
//		Collection<Defect> list = defectActionService.getAll();
		Collection<Defect> list = defectActionService.getList();
		
		
		model.addAttribute("defectList", list);
		return "list";
		
	}
	
	@RequestMapping(value = "/defect", method = RequestMethod.POST)
	public String search(Model model, @ModelAttribute("name") String name) {
		Collection<Defect> list = defectActionService.getAllLike(name);
		model.addAttribute("defectList", list);
		model.addAttribute("searchedValue", name);
		return "list";
//		return "redirect:/defect";
	}
	
	@RequestMapping(value = "/defect/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute("allSeverity", Severity.values());
		
		return "defect-add";
	}
	
	@RequestMapping(value = "/defect/add", method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute 
			DefectRequestData defectRequestData) {
		
		//assignedTo not mandatory
		if (defectRequestData.getTitle().equals("") 
				|| defectRequestData.getDescription().equals("")) {
			model.addAttribute("error", "Required fields are empty!");

			return add(model);
			
		} else {
			// add author 

		defectActionService.createDefect(defectRequestData);


		return "redirect:/defect";
		}
	}
	
	@RequestMapping(value = "/defect/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(value = "id", required = true) int id) {
		
		Defect defect = defectActionService.getDefect(id);
		model.addAttribute("defect", defect);
		model.addAttribute("allSeverity", Severity.values());
		model.addAttribute("allStatus", Status.values());
		model.addAttribute("commentList", defectActionService.getDefect(id).getComments());
		
		return "defect-edit";
	}
	
	@RequestMapping(value = "/defect/edit", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute DefectRequestData defectRequestData) {
		
			if (defectRequestData.getTitle().equals("") 
				|| defectRequestData.getDescription().equals("")) {
			model.addAttribute("error", "Required fields are empty!");


			return edit(model, defectRequestData.getId());
		} else {
		
		defectActionService.edit(defectRequestData, 
				defectActionService.getDefect(defectRequestData.getId()));



		return "redirect:/defect";
		}
	}
	
	@RequestMapping(value = "/defect/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(value = "id", required = true) int id) {
		
		
		defectActionService.delete(id);
		
		return "redirect:/defect";
	}
	
	@RequestMapping(value = "/defect/view", method = RequestMethod.GET)
	public String viewGet(Model model, @RequestParam(value = "id", required = true) int id) {
		
		Defect defect = defectActionService.getDefect(id);
		model.addAttribute("disabled", "disabled");
		model.addAttribute("defect", defect);
		model.addAttribute("allSeverity", Severity.values());
		model.addAttribute("allStatus", Status.values());
		model.addAttribute("commentList", defectActionService.getDefect(id).getComments());
		
		return "defect-edit";
	}
	
	
	
	@RequestMapping(value = "/defect/view", method = RequestMethod.POST)
	public String view(Model model, @ModelAttribute DefectRequestData defectRequestData) {
		
		
		defectActionService.edit(defectRequestData, 
				defectActionService.getDefect(defectRequestData.getId()));

		return "redirect:/defect";
	}
	
	

}
