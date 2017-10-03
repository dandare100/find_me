package za.co.fnb.findmelocator.ocep.views;

import za.co.fnb.findmelocator.ocep.utils.StringUtil;
import za.co.fnb.pe.framework.api.UIViewContext;
import za.co.fnb.pe.framework.entity.header.Customer;
import za.co.fnb.pe.framework.util.views.ISView;

public class CustomerView extends ISView {

	@Override
	public void processMessage(UIViewContext context) {
		Customer customer = context.getRequest().getCustomer();
		context.getClipboard().put("ucn", customer.getUcn() == 0l ? "N/A" : customer.getUcn());
		context.getClipboard().put("coid", customer.getCompany() == 0 ? "N/A" : customer.getCompany());
		context.getClipboard().put("name", customer.getFirstName() == null || customer.getFirstName().isEmpty() ? "N/A" : StringUtil.applyCamelCaseRules(customer.getFirstName()));
		context.getClipboard().put("surname", customer.getLastName() == null || customer.getLastName().isEmpty() ? "N/A" : StringUtil.applyCamelCaseRules(customer.getLastName()));
//		context.getClipboard().put("cellnumber", customer.getCellNumber() == null || customer.getIdNumber().isEmpty() ? "N/A" : customer.getCellNumber());
		context.getClipboard().put("idnumber", customer.getIdNumber() == null || customer.getIdNumber().isEmpty() ? "N/A" : customer.getIdNumber());
		super.processMessage(context);
	}
}
