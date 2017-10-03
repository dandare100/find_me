package za.co.fnb.findmelocator.ocep.controllers;

import za.co.fnb.pe.framework.api.UIController;
import za.co.fnb.pe.framework.api.UIControllerContext;

public class DoNothingController implements UIController {

	public String processMessage(UIControllerContext context) {
		return DEFAULT;
	}
	
}
