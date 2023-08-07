package com.test.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.xml.test.methods.TestMethods;
import com.test.xml.test.methods.TestXSD;
import com.test.xml.test.objects.TestValues;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@SpringBootApplication
public class XmlApplication implements CommandLineRunner {
	private static final Logger log = (Logger) LoggerFactory.getLogger(XmlApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(XmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
			TestXSD.transformXMLstoXML();

	}


}
