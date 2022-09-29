package com.config.cowin;

import java.io.IOException;

public class CowinConfigHelper {
	
	
	
	private CowinConfigHelper() {
		
	}

	public static CowinConfigReader getInstance() throws IOException {
		
		CowinConfigReader cwreader = new CowinConfigReader();
		return cwreader;
		
	}
}
