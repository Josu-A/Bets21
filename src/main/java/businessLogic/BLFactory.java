package businessLogic;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;

public final class BLFactory {
	
	private BLFactory() {
		throw new IllegalStateException("Utility class");
	}
	
	public static BLFacade createBusinessLogic(ConfigXML c) throws NullPointerException {
		if (c.isBusinessLogicLocal()) {
			DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			return new BLFacadeImplementation(da);
		}
		
		String serviceName = "http://" + c.getBusinessLogicNode() + ":" 
				+ c.getBusinessLogicPort() + "/ws/" + c.getBusinessLogicName()
				+ "?wsdl";
		try {
			URL url = new URL(serviceName);
	        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
	        Service service = Service.create(url, qname);
	        return service.getPort(BLFacade.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		throw new NullPointerException("Function returned a null value");
	}

}
