package com.nitsoft.util.test;


import com.nitsoft.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;



public class StringUtilTest {

    @Test
    public void zeroPadIntWith1DigitTest() {
        String paddedString = StringUtil.zeroPadInt(5,1);

        assert (paddedString.length() == 1);
        assert (paddedString.startsWith("5"));
    }

    @Test
    public void zeroPadIntWithFewerDigitsTest() {
        String paddedString = StringUtil.zeroPadInt(500,1);

        assert (paddedString.length() == 3);
        assert (paddedString.equals("500"));
    }


    @Test
    public void zeroPadIntWithMoreDigitsTest() {
        String paddedString = StringUtil.zeroPadInt(500,5);

        assert (paddedString.length() == 5);
        assert (paddedString.equals("00500"));
    }

    @Test
    public void findAndReplaceLastCharTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","G","H");

        assert (modifiedString.equals("ABCDEFH"));
    }

    @Test
    public void findAndReplaceEntireStringWithSameTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","ABCDEFG","ABCDEFG");

        assert (modifiedString.equals("ABCDEFG"));
    }

    @Test
    public void findAndReplaceEntireStringWithEmptyTest() {
        String modifiedString = StringUtil.findAndReplace("ABCDEFG","ABCDEFG","");

        assert (modifiedString.equals(""));
    }

    @Test
    public void deleteCharactersInStringWithNothingTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","");

        assert (modifiedString.equals("ABCDEFG"));
    }

    @Test
    public void deleteCharactersInStringWithEverythingTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","ABCDEFG");

        assert (modifiedString.equals(""));
    }


    @Test
    public void deleteCharactersInStringWithRepeatedCharctersTest() {
        String modifiedString = StringUtil.deleteCharacters("ABCDEFG","AABB");

        assert (modifiedString.equals("CDEFG"));
    }
}
