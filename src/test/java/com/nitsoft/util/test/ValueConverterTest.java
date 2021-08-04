package com.nitsoft.util.test;

import com.nitsoft.util.StringUtil;
import com.nitsoft.util.ValueConverter;
import org.junit.Assert;
import org.junit.Test;

public class ValueConverterTest {



    @Test
    public void conversionToDoubleTestWithOKParsing() {
        Double computedDouble = ValueConverter.convertStringToDouble("19.21",0.01);

        Assert.assertEquals (Double.valueOf(19.21),   computedDouble);

    }


    @Test
    public void conversionToDoubleTestWithNOTOKParsing() {
        Double computedDouble = ValueConverter.convertStringToDouble("19.A",0.01);

        Assert.assertEquals (Double.valueOf(0.01),   computedDouble);

    }
}
