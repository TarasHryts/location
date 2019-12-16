package com.task.geo.converter;

import com.task.geo.exception.IncorrectIpException;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void IpConverterOk() {
        Long expected = 16843009L;
        Assert.assertEquals(expected, IpConverter.stringToLong("1.1.1.1"));
        expected = 134744072L;
        Assert.assertEquals(expected, IpConverter.stringToLong("8.8.8.8"));
        expected = 3232235777L;
        Assert.assertEquals(expected, IpConverter.stringToLong("192.168.1.1"));
    }

    @Test
    public void LongConvertToIpOk() {
        String expected = "1.1.1.1";
        Assert.assertEquals(expected, IpConverter.longToString(16843009L));
        expected = "8.8.8.8";
        Assert.assertEquals(expected, IpConverter.longToString(134744072L));
        expected = "192.168.1.1";
        Assert.assertEquals(expected, IpConverter.longToString(3232235777L));
    }

    @Test(expected = IncorrectIpException.class)
    public void incorrectIpException() {
        IpConverter.stringToLong("1.1.1.300");
        IpConverter.stringToLong("1.1.1");
    }

}