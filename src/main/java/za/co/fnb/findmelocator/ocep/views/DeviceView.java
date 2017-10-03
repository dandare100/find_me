package za.co.fnb.findmelocator.ocep.views;

import za.co.fnb.findmelocator.ocep.utils.StringUtil;
import za.co.fnb.pe.framework.api.UIViewContext;
import za.co.fnb.pe.framework.util.views.ISView;

public class DeviceView extends ISView {

	@Override
	public void processMessage(UIViewContext context) {
		context.getClipboard().put("platform", context.getRequest().getDevice().getPlatform() == null ? "N/A" : StringUtil.applyCamelCaseRules(context.getRequest().getDevice().getPlatform().toString()));
		context.getClipboard().put("resolution", context.getRequest().getDevice().getResolution() == null ? "N/A" : context.getRequest().getDevice().getResolution());
		context.getClipboard().put("gsm", context.getRequest().getDevice().isGsm());
		context.getClipboard().put("status", context.getRequest().getDevice().getStatus() == null ? "N/A" : StringUtil.applyCamelCaseRules(context.getRequest().getDevice().getStatus().toString()));
		super.processMessage(context);
	}
}
