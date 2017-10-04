package za.co.fnb.findmelocator.ocep.models;

import za.co.fnb.findmelocator.ocep.utils.StringUtil;
import za.co.fnb.pe.framework.api.UIModel;
import za.co.fnb.pe.framework.api.UIModelContext;
import za.co.fnb.pe.framework.api.UIModelResponse;
import za.co.fnb.pe.framework.template.elements.DropdownOption;

/**
 * @author Valentine Nkosi (F4904672)
 * @Since 04 Oct 2017
 * @version 1.0
 */
public class OfficeLocatorSearchModel implements UIModel {
	public static final String MODEL_ID = "model.findmelocator.search";

	@Override
	public UIModelResponse processMessage(UIModelContext context) {
		
		for (int i = 0; i < 51; i++) {
			   DropdownOption provinces = new DropdownOption();
			   provinces.setId("office.location.province." + i);
			   provinces.setParent("office.location.province");
			   provinces.setText("" + i);
			   provinces.setSort(StringUtil.sortableASCIIString((i + 1)));
			   provinces.setSort(""+(i + 1));
			   context.getData().add(provinces);
		}
		return SUCCESS;
	}

}
