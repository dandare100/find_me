package za.co.fnb.findmelocator.ocep.views;

import za.co.fnb.pe.framework.FrameworkSessionContext;
import za.co.fnb.pe.framework.api.UIViewContext;
import za.co.fnb.pe.framework.entity.OrderType;
import za.co.fnb.pe.framework.entity.factories.mm.ContainerFactory;
import za.co.fnb.pe.framework.entity.factories.mm.SymbolFactory;
import za.co.fnb.pe.framework.entity.mm.ActionType;
import za.co.fnb.pe.framework.entity.mm.StructuredContainer;
import za.co.fnb.pe.framework.entity.mm.SymbolColour;
import za.co.fnb.pe.framework.template.phone.MagicMountainViewTemplate;
import za.co.fnb.pe.framework.util.views.MagicMountainView;

/**
 * @author Valentine Nkosi (F4904672)
 * @Since 03 Oct 2017
 * @version 1.0
 */
public class OfficeLocatorSearchView extends MagicMountainView {

	@Override
	public void processMessage(UIViewContext context) {
		super.processMessage(context);
		FrameworkSessionContext sessionContext = context.getSessionContext();
		MagicMountainViewTemplate ui = (MagicMountainViewTemplate) context.getUI();
			
		StructuredContainer sc = (StructuredContainer)ContainerFactory.createStructuredContainer("root.structuredcontainer.0", "root", SymbolColour.GLASS, "0", OrderType.ASC).addToContainer(ui.getRootContainer());
//		SymbolFactory.addImage40(sc.getHeader().getKey() + ".image", sc.getHeader().getKey(), "0").withImage("resource.findmelocator.search").withAlignment(Alignment.CENTER).addToContainer(sc.getHeader());
//		SymbolFactory.addH2Text(sc.getHeader().getKey() + ".h2", sc.getHeader().getKey(), "1").withText("Find Me").withAlignment(Alignment.CENTER).withStyle(SymbolColour.INK).addToContainer(sc.getHeader());
			
		sc.getBody().setDataparent("ui.findmelocator.office.locator.search.view");
		sc.getBody().setDatasource("model.findmelocator.process.select.options");
		SymbolFactory.addSelect("province.select", "root.structuredcontainer.0.body.0", "1").withTextAndColour("Province", SymbolColour.INK, "Mpumalanga", SymbolColour.INK, "", SymbolColour.INK).withType(ActionType.UPDATE).addToContainer(sc.getBody());
		SymbolFactory.addSelect("office.select", "root.structuredcontainer.0.body.0", "2").withTextAndColour("Office", SymbolColour.INK, "Wesbank Private Client", SymbolColour.INK, "", SymbolColour.INK).withType(ActionType.UPDATE).addToContainer(sc.getBody());

	}

}
