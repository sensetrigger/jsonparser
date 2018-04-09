package com.sensetrigger.jsonparser;

import java.util.Calendar;
import java.util.Date;

public class TestChild extends TestParent {
    Date dateValue;
    Calendar calendarValue;
    Integer integerValue;

    TestChild() {
        super();
        dateValue = new Date();
        calendarValue = Calendar.getInstance();
        integerValue = 10;
    }
}
