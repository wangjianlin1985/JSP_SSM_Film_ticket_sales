// 
// 
// 

package com.util;

import java.security.MessageDigest;

public final class MD5
{
    public static final String md5(final String s) {
        final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            final byte[] strTemp = s.getBytes();
            final MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            final byte[] md = mdTemp.digest();
            final int j = md.length;
            final char[] str = new char[j * 2];
            int k = 0;
            for (final byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xF];
                str[k++] = hexDigits[byte0 & 0xF];
            }
            return new String(str);
        }
        catch (Exception e) {
            return null;
        }
    }
}
