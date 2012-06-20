/*
 * Copyright (C) 2012 tamtam180
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.orz.sample.restlet;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;

/**
 * @author tamtam180 - kirscheless at gmail.com
 *
 */
public class RestletSampleApplication extends JaxRsApplication {

	public static class APIApplicationConfig extends Application {

		@Override
		public Set<Class<?>> getClasses() {
			
			Set<Class<?>> rrcs = new HashSet<Class<?>>();
			rrcs.add(RestletSampleResource.class);
			return rrcs;

		}

	}
	
	public RestletSampleApplication(Context context) {
		super(context);
		this.add(new APIApplicationConfig());
	}

}

