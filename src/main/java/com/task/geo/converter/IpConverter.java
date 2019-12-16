package com.task.geo.converter;

import com.task.geo.exception.IncorrectIpException;

public class IpConverter {
    public static Long stringToLong(String stringIp) {
        Long result = 0L;
        String[] ipParts = stringIp.split("\\.");
        if (ipParts.length != 4) {
            throw new IncorrectIpException("Incorrect ip address " + stringIp);
        }
        for (int i = 3; i >= 0; i--) {
            long ip = Long.parseLong(ipParts[3 - i]);
            if ((ip < 0L) && (ip > 255L)) {
                throw new IncorrectIpException("Incorrect ip address " + stringIp);
            }
            result |= ip << (i * 8);
        }
        return result;
    }

    public static String longToString(Long longIp) {
        return ((longIp >> 24) & 0xFF) + "."
                + ((longIp >> 16) & 0xFF) + "."
                + ((longIp >> 8) & 0xFF) + "."
                + (longIp & 0xFF);
    }
}
