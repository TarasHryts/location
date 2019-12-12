package com.task.geo.converter;

import com.task.geo.entity.GeoIpDataBase;
import com.task.geo.entity.Location;

public class GeoIpConverterToLocation {
    public static Location createGeoLocationFromDB(GeoIpDataBase geoIpDataBase,
                                                   String canonicalIPv4Representation) {
        Location location = new Location();
        location.setCanonicalIPv4Representation(canonicalIPv4Representation);
        location.setCityName(geoIpDataBase.getCityName());
        location.setCountryCode(geoIpDataBase.getCountryCode());
        location.setCountryName(geoIpDataBase.getCountryName());
        location.setIPv4(IpConverter.stringToLong(canonicalIPv4Representation));
        location.setLatitude(geoIpDataBase.getLatitude());
        location.setLongitude(geoIpDataBase.getLongitude());
        location.setRegionName(geoIpDataBase.getRegionName());
        return location;
    }
}
