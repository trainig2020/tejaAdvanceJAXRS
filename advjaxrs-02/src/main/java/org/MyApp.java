package org;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@ApplicationPath("webapi")
public class MyApp extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		
		return new HashSet<Class<?>>();
	}

}
