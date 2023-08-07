package com.test.xml.test.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TestObjects {
    private String data1;
    private String data2;
    private int data3;
    private boolean data4;
}
