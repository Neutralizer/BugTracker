package controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.defect.Defect;
import model.defect.DefectRequestData;
import model.defect.DefectRequestDataBuilder;
import model.defect.DefectRequestDataBuilderImpl;
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

	@RequestMapping(value = "/defectT", method = RequestMethod.GET)
	public @ResponseBody Defect getDefect() {
		DefectRequestData request = getDefectRequestDataBuilderImpl()
				.title("Test defect")
				.author("b.nikolov")
				.description("test defect description")
				.severity(Severity.MAJOR.toString())
				.status(Status.NEW.toString())
				.build();
		
		 Defect defect = defectActionService.createDefect(request);
		
//		 Comment comment = commentActionService.createComment("Fix it now!");
//		 Comment comment2 = commentActionService.createComment("Fix it now!");
//		 defect = defectActionService.addComment(defect, comment);
//		 defect = defectActionService.addComment(defect, comment2);
		
		
		 return defect;

	}
	
	@RequestMapping(value = "/defect", method = RequestMethod.GET)
	public String currencies(Model model) {
		
		Collection<Defect> list = defectActionService.getAll();
		
		model.addAttribute("issueList", list);
		return "list";
	}
	
	

	private DefectRequestDataBuilder getDefectRequestDataBuilderImpl() {
		return new DefectRequestDataBuilderImpl();
	}
}
