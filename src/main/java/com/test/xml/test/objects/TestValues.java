package com.test.xml.test.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class TestValues {
    public static TestObjects TEST_VALUE_1 = TestObjects
            .builder()
            .data3(1)
            .data1(UUID.randomUUID().toString())
            .data2("Prueba 1")
            .data4(false)
            .build();

    public static String TEST_VALUE_1_XML = "<TestObjects><data1>9a7ec406-676f-4e67-8add-ca791d3b7624</data1><data2>Prueba 1</data2><data3>1</data3><data4>false</data4></TestObjects>";

    public static TestObjects NESTED_VALUE_1 () {

        TestObjects testObjects = TestObjects
                .builder()
                .data1(UUID.randomUUID().toString())
                .data2("Test")
                .data3(1)
                .data4(false)
                .build();

        List<TestNestedObject> nestedObject1 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            nestedObject1.add( TestNestedObject
                    .builder()
                    .nested1(UUID.randomUUID().toString())
                    .nested2(RandomGenerator.getDefault().nextInt())
                    .nested3(true)
                    .build());
        }
        testObjects.setWrapperNested(nestedObject1);

        nestedObject1.clear();
        for (int i = 0; i < 10; i++) {
            nestedObject1.add( TestNestedObject
                    .builder()
                    .nested1(UUID.randomUUID().toString())
                    .nested2(RandomGenerator.getDefault().nextInt())
                    .nested3(true)
                    .build());
        }

        testObjects.setUnWrapperNested(nestedObject1);

        return testObjects;
    }

    public static List<TestObjects> LIST_NESTED_VALUE_1 () {
        List<TestObjects> testObjects = new LinkedList<>();

        testObjects.add(NESTED_VALUE_1());
        testObjects.add(NESTED_VALUE_1());
        testObjects.add(NESTED_VALUE_1());
        testObjects.add(NESTED_VALUE_1());
        testObjects.add(NESTED_VALUE_1());
        testObjects.add(NESTED_VALUE_1());
        testObjects.add(NESTED_VALUE_1());

        return testObjects;
    }
}
