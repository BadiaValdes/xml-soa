package com.test.xml.test.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestNestedObject {
    private String nested1;
    private int nested2;
    private boolean nested3;
}
