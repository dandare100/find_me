package za.co.fnb.findmelocator.ocep.views;

import za.co.fnb.pe.framework.api.UIViewContext;
import za.co.fnb.pe.framework.template.elements.FormControl;
import za.co.fnb.pe.framework.template.phone.InstantServicesViewTemplate;
import za.co.fnb.pe.framework.util.views.ISView;

public class GPSView extends ISView {

	@Override
	public void processMessage(UIViewContext context) {
		super.processMessage(context);
		InstantServicesViewTemplate ui = (InstantServicesViewTemplate) context.getUI();

		for (FormControl control : ui.getControls()) {
			if (control.getKey().equalsIgnoreCase("map")) {
				control.setValue(context.getRequest().getLocation().getLatitude() + "," + context.getRequest().getLocation().getLongitude());
				break;
			}
		}
	}
}
