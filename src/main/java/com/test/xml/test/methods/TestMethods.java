package com.test.xml.test.methods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.xml.XmlApplication;
import com.test.xml.test.objects.TestObjects;
import com.test.xml.test.objects.TestValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Test class to implement XML serialization and deserialization
 * @author Emilio
 */
public class TestMethods {
    private static final Logger log = LoggerFactory.getLogger(XmlApplication.class);
    private static final XmlMapper mapper = new XmlMapper();

    // Serialization 1 element

    /**
     * Serialize object to string
     * @throws JsonProcessingException
     */
    public static void serializeJavaToXMLAsString() throws JsonProcessingException {
        String objectToXml = mapper.writeValueAsString(TestValues.TEST_VALUE_1);
        log.info(objectToXml);
    }

    /**
     * Serialize object to xml file
     * @throws IOException
     */
    public static void serializeJavaToXMLFile() throws IOException {
       mapper.writeValue(new File("xmlTest.xml"), TestValues.TEST_VALUE_1);
        log.info("Object was written");
    }

    // Deserialization 1 element

    /**
     * Deserialize xml string to object
     * @throws JsonProcessingException
     */
    public static void deserializeXmlToJavaString() throws JsonProcessingException {
        TestObjects result = mapper.readValue(TestValues.TEST_VALUE_1_XML, TestObjects.class);
        log.info(result.toString());
    }

    /**
     * Deserialize xml file to object
     * @throws IOException
     */
    public static void deserializeXmlToJavaFromFile() throws IOException {
        File localFile = new File("xmlTest.xml");
        TestObjects result = mapper.readValue(localFile, TestObjects.class);
        log.info(result.toString());
    }

    // Serialization con listas

    /**
     * Serialize object with nested list to string
     * @throws IOException
     */
    public static void serializationListObjectToXMLString() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mapper.writeValue(byteArrayOutputStream, TestValues.NESTED_VALUE_1());
        log.info(byteArrayOutputStream.toString());
    }

    /**
     * Serialize object with nested list to File
     * @throws IOException
     */
    public static void serializationListObjectToXMLFile() throws IOException {
        mapper.writeValue(new File("list.xml"), TestValues.NESTED_VALUE_1());
    }

    /**
     * Serialize List of object with nested list to file
     * @throws IOException
     */
    public static void serializationListObjectToXMLFileMultiple() throws IOException {
        mapper.writeValue(new File("list_list.xml"), TestValues.LIST_NESTED_VALUE_1());
    }

    // Deserialize with list

    /**
     * Deserialize object with nested list
     * @throws IOException
     */
    public static void deserializationXMLToListObjectFile() throws IOException {
        File file = new File("list.xml");
        TestObjects t = mapper.readValue(file, TestObjects.class);
        log.info(t.toString());
    }


}
