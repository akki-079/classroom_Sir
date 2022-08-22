package com.demo.layered.app;

public class ServiceLayer {

	private PersistenceLayer persistenceLayer=new PersistenceLayer();
	
	public String compose(String header, String body) {
		
		String message=header+" : "+body;
		String response=persistenceLayer.save(message);
		return response;
		
	}
}
