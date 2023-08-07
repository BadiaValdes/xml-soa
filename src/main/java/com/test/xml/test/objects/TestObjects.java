package com.test.xml.test.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TestObjects {
//    @JsonProperty("DATA1") // Esta anotacion nos permite definir un dato del objeto con nombre diferente
    private String data1;
    private String data2;
    private int data3;
    private boolean data4;
    List<TestNestedObject> wrapperNested;
    @JacksonXmlElementWrapper(useWrapping = false) // Nos permite definir si los resultados de una lista estarán dentro de una misma etiqueta o separados
    List<TestNestedObject> unWrapperNested;
}
