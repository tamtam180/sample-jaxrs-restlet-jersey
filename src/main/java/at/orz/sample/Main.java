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

package at.orz.sample;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.restlet.ext.servlet.ServerServlet;

import at.orz.sample.restlet.RestletSampleApplication;

import com.sun.jersey.spi.container.servlet.ServletContainer;

/**
 * @author tamtam180 - kirscheless at gmail.com
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		
		final int listenPort = 20000;
		
		// Webアプリケーション起動
		Server httpServer = new Server(listenPort);
		// Context
		ServletContextHandler rootContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		rootContextHandler.setContextPath("/");
		rootContextHandler.setResourceBase("WebContent");
		rootContextHandler.addServlet(DefaultServlet.class, "/*");
		// Restletの実装
		{
			ServletHolder holder = new ServletHolder(ServerServlet.class);
			holder.setInitParameter("org.restlet.application", RestletSampleApplication.class.getName());
			rootContextHandler.addServlet(holder, "/restlet/*");
		}
		// Jerseyの実装
		{
			ServletHolder holder = new ServletHolder(ServletContainer.class);
			holder.setInitParameter("com.sun.jersey.config.property.packages", "at.orz.sample.jersey"); // Resourceを置くパッケージ名
			rootContextHandler.addServlet(holder, "/jersey/*");
		}
		
		//rootContextHandler.addEventListener(new AppContextListener());
		
		httpServer.setHandler(rootContextHandler);
		httpServer.start();
		httpServer.join();

	}

}
