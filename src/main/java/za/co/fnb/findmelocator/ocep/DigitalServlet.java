package za.co.fnb.findmelocator.ocep;

import javax.servlet.ServletConfig;

import za.co.fnb.pe.framework.PlatformExtensionServlet;

public class DigitalServlet extends PlatformExtensionServlet {
    protected String loadXMLFile(final ServletConfig config) {
        return( config.getServletContext().getRealPath( "/WEB-INF/classes/platform-extension-config.xml" ) );
    }
}
