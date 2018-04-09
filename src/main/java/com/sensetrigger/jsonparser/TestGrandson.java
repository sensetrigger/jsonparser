package com.sensetrigger.jsonparser;

import java.util.*;

public class TestGrandson extends TestParent {
    int [] arr = new int[3];
    Set<String> setValue;
    Map<Integer, String> mapValue;
    List<String> listValue;


    TestGrandson() {
        super();

        for (int i = 0; i < 3; i++)
            arr[i] = i;

        setValue = new HashSet<String>();
        setValue.add("OneSet");
        setValue.add("TwoSet");


        mapValue = new HashMap<Integer, String>();
        mapValue.put(1,"OneMap");
        mapValue.put(2,"TwoMap");

        listValue = new ArrayList<>();
        listValue.add("OneList");
        listValue.add("TwoList");
    }
}
