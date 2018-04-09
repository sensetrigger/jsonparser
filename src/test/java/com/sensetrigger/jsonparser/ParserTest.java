package com.sensetrigger.jsonparser;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    Parser pars = new Parser();

    @Test
    public void testParentClass() {
        TestParent tparent = new TestParent();
        assertEquals("{\n" +
                "\t\"intValue\": 1," +
                "\n" +
                "\t\"doubleValue\": 1.1," +
                "\n" +
                "\t\"stringValue\": \"example\"" +
                "\n}\n", pars.parser(tparent));
    }

    @Test
    public void testChildClass() {
        TestChild tchild = new TestChild();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        assertEquals("{\n" +
                "\t\"dateValue\": " + sdf.format(new Date()) + "," +
                "\n" +
                "\t\"calendarValue\": " + sdf.format(new Date()) + "," +
                "\n" +
                "\t\"integerValue\": 10," +
                "\n" +
                "\t\"TestParent\": {" +
                "\n" +
                "\t\t\"intValue\": 1," +
                "\n" +
                "\t\t\"doubleValue\": 1.1," +
                "\n" +
                "\t\t\"stringValue\": \"example\"" +
                "\n\t}\n" +
                "}\n" +
                "", pars.parser(tchild));
    }

    @Test
    public void testGrandsonClass() {
        TestGrandson tgrandson = new TestGrandson();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        assertEquals("{\n" +
                "\t\"arr\": [\n" +
                "\t\t\"0\",\n" +
                "\t\t\"1\",\n" +
                "\t\t\"2\"\n" +
                "\t],\n"+
                "\t\"setValue\": [\n" +
                "\t\t\"OneSet\",\n" +
                "\t\t\"TwoSet\"\n" +
                "\t],\n"+
                "\t\"mapValue\": [\n" +
                "\t\t\"1=OneMap\",\n" +
                "\t\t\"2=TwoMap\"\n" +
                "\t],\n"+
                "\t\"listValue\": [\n" +
                "\t\t\"OneList\",\n" +
                "\t\t\"TwoList\"\n" +
                "\t],\n"+
                "\t\"TestParent\": {" +
                "\n" +
                "\t\t\"intValue\": 1," +
                "\n" +
                "\t\t\"doubleValue\": 1.1," +
                "\n" +
                "\t\t\"stringValue\": \"example\"" +
                "\n\t}\n" +
                "}\n", pars.parser(tgrandson));
    }

    @Test
    public void testAddType() {
        pars.addType(LinkedList.class, new JSONList());
        List<String> testList = new LinkedList<>();
        testList.add("oneTest");
        testList.add("twoTest");

        assertEquals("\"LinkedList\": [\n" +
                        "\t\"oneTest\",\n" +
                        "\t\"twoTest\"\n" +
                        "]", pars.parser(testList));
    }

    @Test
    public void testArray() {
        int [] mas = {1,2};
        assertEquals("\"int[]\": [\n" +
                "\t\"1\",\n" +
                "\t\"2\"\n" +
                "]", pars.parser(mas));
    }

    @Test
    public void testPrimitive() {
        Integer num = 5;
        assertEquals("\"Integer\": 5", pars.parser(num));
    }
}

