package za.co.fnb.findmelocator.ocep.views;

import za.co.fnb.pe.framework.api.UIView;
import za.co.fnb.pe.framework.api.UIViewContext;
import za.co.fnb.pe.framework.template.elements.Overview;
import za.co.fnb.pe.framework.template.elements.OverviewPanel;
import za.co.fnb.pe.framework.template.phone.OverviewViewTemplate;
import za.co.fnb.pe.framework.util.views.OverviewView;

public class StartView extends OverviewView implements UIView {

	@Override
	public void processMessage(UIViewContext context) {
		OverviewViewTemplate ui = (OverviewViewTemplate) context.getUI();

		for (Overview overview : ui.getOverviews().getOverviews()) {
			if (overview.getId().equalsIgnoreCase("overview_1")) {
				for (OverviewPanel panel : overview.getPanels()) {
					if (panel.getId().equalsIgnoreCase("overview_panel_1")) {
						panel.setHeading(" ATM, Branch & " + "\n" + " Office Locator");
						break;
					}
				}
				break;
			}
		}
	}
}
