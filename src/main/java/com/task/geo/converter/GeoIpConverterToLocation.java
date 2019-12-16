package com.task.geo.converter;

import com.task.geo.dto.Location;
import com.task.geo.entity.GeoIpDataBase;

public class GeoIpConverterToLocation {
    public static Location createGeoLocationFromDB(GeoIpDataBase geoIpDataBase,
                                                   String canonicalIPv4Representation) {
        return new Location(canonicalIPv4Representation,
                geoIpDataBase.getCityName(),
                geoIpDataBase.getCountryCode(),
                geoIpDataBase.getCountryName(),
                IpConverter.stringToLong(canonicalIPv4Representation),
                geoIpDataBase.getLatitude(),
                geoIpDataBase.getLongitude(),
                geoIpDataBase.getRegionName());
    }
}
