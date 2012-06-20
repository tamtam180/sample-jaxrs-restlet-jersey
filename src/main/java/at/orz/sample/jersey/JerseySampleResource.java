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

package at.orz.sample.jersey;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author tamtam180 - kirscheless at gmail.com
 *
 */
@Path("sample")
@Produces(MediaType.TEXT_PLAIN)
public class JerseySampleResource {
	
	@GET
	@Path("app1")
	public String doGetApp1(
			@QueryParam("name") List<String> name
			) {
		
		if (name == null) {
			return null;
		} else {
			return name.toString();
		}
		
	}

	@GET
	@Path("app2")
	public String doGetApp2(
			@QueryParam("name[]") List<String> name
			) {
		
		if (name == null) {
			return null;
		} else {
			return name.toString();
		}
		
	}

	@POST
	@Path("app")
	public String doPostApp(
			@FormParam("name") List<String> name
			) {
		
		if (name == null) {
			return null;
		} else {
			return name.toString();
		}
		
	}
	
}

