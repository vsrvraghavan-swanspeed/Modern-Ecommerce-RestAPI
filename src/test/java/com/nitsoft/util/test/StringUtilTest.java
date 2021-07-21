package com.nitsoft.util.test;


import com.nitsoft.util.StringUtil;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;


public class StringUtilTest {

    @Test
    public void zeroPadIntWith1DigitTest() {
        String paddedString = StringUtil.zeroPadInt(5,1);

        Assert.assertEquals (1,   paddedString.length());
        Assert.assertEquals ("5", paddedString);
    }

    @Test
    public void zeroPadIntWithFewerDigitsTest() {
        String paddedString = StringUtil.zeroPadInt(500,1);

        Assert.assertEquals (3, paddedString.length());
        Assert.assertEquals ("500",paddedString);
    }


    @Test
    public void zeroPadIntWithMoreDigitsTest() {
        String paddedString = StringUtil.zeroPadInt(500,5);

        Assert.assertEquals (5,paddedString.length());
        Assert.assertEquals ("00500",paddedString);
    }

    @Test
    public void findAndReplaceLastCharTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","G","H");

        Assert.assertEquals ("ABCDEFH",modifiedString);
    }

    @Test
    public void findAndReplaceEntireStringWithSameTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","ABCDEFG","ABCDEFG");

        Assert.assertEquals ("ABCDEFG",modifiedString);
    }

    @Test
    public void findAndReplaceEntireStringWithEmptyTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","ABCDEFG","");

        Assert.assertEquals ("",modifiedString);
    }

    @Test
    public void deleteCharactersInStringWithNothingTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","");

        Assert.assertEquals ("ABCDEFG",modifiedString);
    }

    @Test
    public void deleteCharactersInStringWithEverythingTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","ABCDEFG");

        Assert.assertEquals ("",modifiedString);
    }


    @Test
    public void deleteCharactersInStringWithRepeatedCharctersTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","AABB");

        Assert.assertEquals ("CDEFG",modifiedString);
    }

    @Test
    public void restrictLengthOfStringWithSameLengthTest() {
        String shrunkString = StringUtil.restrictLength("ABCDEFG", 7);

        Assert.assertEquals("ABCDEFG", shrunkString);
    }

    @Test
    public void restrictLengthOfStringWithLesserLengthTest() {
        String shrunkString = StringUtil.restrictLength("ABCDEFG", 5);

        Assert.assertEquals("AB...", shrunkString);
    }

    @Test
    public void restrictLengthOfStringWithBiggerLengthTest() {
        String shrunkString = StringUtil.restrictLength("ABCDEFG", 10);

        Assert.assertEquals("ABCDEFG", shrunkString);
    }

}
