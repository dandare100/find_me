package za.co.fnb.findmelocator.ocep.controllers;

import org.apache.log4j.Logger;

import za.co.fnb.pe.framework.api.UIController;
import za.co.fnb.pe.framework.api.UIControllerContext;
import za.co.fnb.pe.framework.entity.DevicePlatforms;
import za.co.fnb.pe.framework.entity.header.Location;

public class DeviceSupportsLocationServicesController implements UIController {
	private static final Logger LOG = Logger.getLogger(DeviceSupportsLocationServicesController.class);

	@Override
	public String processMessage(UIControllerContext context) {
		// first check if the device supports location based services
		Location gps = context.getRequest().getLocation();
		LOG.debug("Checking if devices supports GPS from coordinates[" + gps + "]...");
		if (gps.getLatitude() == 0.00 && gps.getLongitude() == 0.00) {
			LOG.warn("Device GPS[" + gps + "] does not support GPS or has not yet established coordinates yet!");
			return "notsupported";
		}

		DevicePlatforms platform = context.getRequest().getDevice().getPlatform();
		if (DevicePlatforms.BLACKBERRY_ANDROID.equals(platform)) {
			LOG.warn("Device is a BLACKBERRY_ANDROID and does not support GPS properly, so GPS Locations services are disabled for this platform at the moment!");
			return "notsupported";
		}

		return "supported";
	}
}
