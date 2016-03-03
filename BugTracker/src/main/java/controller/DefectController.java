package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Severity;
import model.defect.Defect;
import model.defect.DefectRequestData;
import model.defect.DefectRequestDataBuilder;
import model.defect.DefectRequestDataBuilderImpl;
import service.CommentActionService;
import service.DefectActionService;

@Controller
public class DefectController {

	@Autowired
	DefectActionService defectActionService;

	@Autowired
	CommentActionService commentActionService;

	@RequestMapping(value = "/defect", method = RequestMethod.GET)
	public @ResponseBody Defect getDefect() {
		DefectRequestData request = getDefectRequestDataBuilderImpl()
				.title("Test defect")
				.author("b.nikolov")
				.description("test defect description")
				.severity(Severity.MAJOR.toString())
				.build();
		
		 Defect defect = defectActionService.createDefect(request);
		
//		 Comment comment = commentActionService.createComment("Fix it now!");
//		 Comment comment2 = commentActionService.createComment("Fix it now!");
//		 defect = defectActionService.addComment(defect, comment);
//		 defect = defectActionService.addComment(defect, comment2);
		
		
		 return defect;

	}

	private DefectRequestDataBuilder getDefectRequestDataBuilderImpl() {
		return new DefectRequestDataBuilderImpl();
	}
}
