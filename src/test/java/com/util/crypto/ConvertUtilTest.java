package com.util.crypto;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertTrue;


/**
 * Created by tangcheng on 2017/2/10.
 */
public class ConvertUtilTest {
    @Test
    public void bytes2hex() throws Exception {
        String expected = "helloworld";
        byte[] bytes = expected.getBytes();
        String afterEncode = ConvertUtil.bytes2hex(bytes);
        System.out.println(afterEncode);
        byte[] afterDecode = ConvertUtil.hex2bytes(afterEncode);
        String actual = new String(afterDecode);
        System.out.println(actual);
        assertTrue(Objects.equals(expected, actual));
    }

    @Test
    public void base64CodeTest() throws Exception {
        String expected = "helloworld";
        String base64Str = ConvertUtil.bytes2base64(expected.getBytes());
        System.out.println(base64Str);
        byte[] afterDecode = ConvertUtil.base642byte(base64Str);
        String actual = new String(afterDecode);
        System.out.println(actual);
        assertTrue(Objects.equals(expected, actual));
    }

}