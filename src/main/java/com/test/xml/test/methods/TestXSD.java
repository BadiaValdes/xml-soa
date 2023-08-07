package com.test.xml.test.methods;

import com.test.xml.XmlApplication;
import com.test.xml.test.objects.xsd.Address;
import com.test.xml.test.objects.xsd.Employee;
import com.test.xml.test.objects.xsd.Employees;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.SchemaOutputResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.spi.ObjectFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Esta clase nos permitirá trabajar con la tranformación de archivos XSD
 * @url https://www.baeldung.com/jaxb
 * @author Emilio
 */
public class TestXSD {

    private static final Logger log = LoggerFactory.getLogger(TestXSD.class);

    /**
     * Este método permite tranformar un objeto de java en XML
     * @throws JAXBException
     */
    public static void objectToXML() throws JAXBException {
        Employee employee = Employee.builder()
                .id(UUID.randomUUID().toString())
                .name("Employee1")
                .address(Address
                        .builder()
                        .name("CASA")
                        .build())
                .build();

        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(employee, new File("src/main/resources/static/employee.xml"));
    }

    /**
     * Este método permite tranformar una lista objetos de java en XML
     * @throws JAXBException
     */
    public static void objectsToXML() throws JAXBException {
        Employees employees = new Employees();
        List<Employee> employeeList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            employeeList.add(Employee.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Employee" + (i+1))
                    .address(Address
                            .builder()
                            .name("CASA"+ (i+1))
                            .build())
                    .build());
        }

        employees.setEmployees(employeeList);

        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(employees, new File("src/main/resources/static/employees.xml"));
    }



    /**
     * Este metodo nos permite convertir de XML a un objeto en java
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static void xMLToObject() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Employee e = (Employee) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/static/employee.xml"));
        log.info(e.toString());
    }

    /**
     * This schema resolver allows us to describe the location for the XSD file
     * that will be saved
     */
    public static class CustomSchemaOutputResolver extends SchemaOutputResolver {
        @Override
        public Result createOutput(String s, String s1) throws IOException {
            File file = new File("src/main/resources/static/employee_schemas.xsd");
            StreamResult result = new StreamResult(file);
            return result;
        }
    }

    /**
     * Generate a XSD schema from and object
     */
    public static void generateXSDSchemaFromObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            context.generateSchema(new CustomSchemaOutputResolver());
        } catch (Exception e){
            log.error("An error occurred in generateXSDSchemaFromObject method");
        }
    }

    /**
     * Generate and XSD Schema from a List of objects
     */
    public static void generateXSDSchemaFromListObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            context.generateSchema(new CustomSchemaOutputResolver());
        } catch (Exception e){
            log.error("An error occurred in generateXSDSchemaFromObject method");
        }
    }

    /**
     * Transform one XML to antoher using XSLT
     * @throws TransformerException
     */
    public static void transformXMLtoXML() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.
                newTransformer
                        (
                                new StreamSource(
                                        (
                                                new File("src/main/resources/static/employeeToEmployee.xsl"))));

        transformer.transform(
                new StreamSource(new File("src/main/resources/static/employee.xml")),
                new StreamResult(new File("src/main/resources/static/employee_out.xml"))
        );

        log.info("The transformation has ended");
    }

    /**
     * Transform one XML to antoher using XSLT
     * @throws TransformerException
     */
    public static void transformXMLstoXML() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.
                newTransformer
                        (
                                new StreamSource(
                                        (
                                                new File("src/main/resources/static/employeesToEmployees.xsl"))));

        transformer.transform(
                new StreamSource(new File("src/main/resources/static/employees.xml")),
                new StreamResult(new File("src/main/resources/static/employees_out.xml"))
        );

        log.info("The transformation has ended");
    }

}

