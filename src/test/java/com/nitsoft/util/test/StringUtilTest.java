package com.nitsoft.util.test;


import com.nitsoft.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;



public class StringUtilTest {

    @Test
    public void zeroPadIntWith1DigitTest() {
        String paddedString = StringUtil.zeroPadInt(5,1);

        Assert.assertEquals (paddedString, 1);
        Assert.assertEquals(paddedString,("5"));
    }

    @Test
    public void zeroPadIntWithFewerDigitsTest() {
        String paddedString = StringUtil.zeroPadInt(500,1);

        Assert.assertEquals (paddedString.length(),3);
        Assert.assertEquals (paddedString, ("500"));
    }


    @Test
    public void zeroPadIntWithMoreDigitsTest() {
        String paddedString = StringUtil.zeroPadInt(500,5);

        Assert.assertEquals (paddedString.length(), 5);
        Assert.assertEquals (paddedString,("00500"));
    }

    @Test
    public void findAndReplaceLastCharTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","G","H");

        Assert.assertEquals (modifiedString,("ABCDEFH"));
    }

    @Test
    public void findAndReplaceEntireStringWithSameTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","ABCDEFG","ABCDEFG");

        Assert.assertEquals (modifiedString,("ABCDEFG"));
    }

    @Test
    public void findAndReplaceEntireStringWithEmptyTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","ABCDEFG","");

        Assert.assertEquals (modifiedString,(""));
    }

    @Test
    public void deleteCharactersInStringWithNothingTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","");

        Assert.assertEquals (modifiedString,("ABCDEFG"));
    }

    @Test
    public void deleteCharactersInStringWithEverythingTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","ABCDEFG");

        Assert.assertEquals (modifiedString,(""));
    }


    @Test
    public void deleteCharactersInStringWithRepeatedCharctersTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","AABB");

        Assert.assertEquals (modifiedString,("CDEFG"));
    }
}
