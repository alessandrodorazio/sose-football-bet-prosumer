package it.univaq.aggm;

import java.util.List;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class StartService {

	public static void main(String[] args) {
		System.out.println("football-bet-prosumer");
		startRest();
		startSoap();
		
	}
	
	public static void startRest() {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(ServiceRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new ServiceRepository()));
        factoryBean.setAddress("http://0.0.0.0:8084/");
        Server server = factoryBean.create();
        System.out.println("Server ready...");
	}
	
	public static void startSoap() {
		Endpoint ep = Endpoint.create(new ServiceRepository());
		List<Handler> handlerChain = ep.getBinding().getHandlerChain();
		ep.getBinding().setHandlerChain(handlerChain);
		ep.publish("http://localhost:8094/");
		System.out.println("SOAP server ready...");
	}

}
