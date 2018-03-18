/**
 * 
 */
package com.rcp.mgnt.main;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.w3c.dom.Document;


@Configuration
@EnableAutoConfiguration
@WebAppConfiguration
@ImportResource(value = { "classpath:/WEB-INF/spring/ApplicationContext.xml" })
public class TomcatEmbedServer {

	private static String path = "WEB-INF/log4j.xml";

	public static void main(String[] args) {
		//initLogger();
		SpringApplication.run(TomcatEmbedServer.class, args);
	}

	public static void initLogger() {
		System.out.println("Init log4j.xml");

		InputStream is = null;

		try {
			ClassPathResource resource = new ClassPathResource(path);
			if (resource.exists()) {
				is = resource.getInputStream();
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

				DOMConfigurator.configure(doc.getDocumentElement());
			} else {
				System.out.println("Not able to read the [" + path + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
